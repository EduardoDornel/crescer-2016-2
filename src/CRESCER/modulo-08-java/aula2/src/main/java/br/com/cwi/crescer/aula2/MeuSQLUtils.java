/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.*;
import java.sql.*;

/**
 *
 * @author Eduardo
 */
public class MeuSQLUtils {

    public void executarSQLDeArquivo(String arquivo) throws SQLException {
        String textoDoArquivo = "";
        String extensao = null;
        try {
            extensao = arquivo.substring(arquivo.lastIndexOf("."), arquivo.length());
        } catch (Exception e) {
        }
        if (extensao == null) {
            System.out.println("Você não passou o arquivo corretamente.");
        } else if (!extensao.equals(".sql")) {
            System.out.println("Arquivo incompatível.");
        } else {
            File file = new File(arquivo);
            if (file.exists()) {
                try {
                    final Reader reader = new FileReader(file);
                    final BufferedReader bufferReader = new BufferedReader(reader);
                    String linha = bufferReader.readLine();
                    while (linha != null) {
                        textoDoArquivo += linha;
                        linha = bufferReader.readLine();
                    }
                } catch (IOException e) {
                    System.out.println("Erro na leitura de " + arquivo + ".");
                }
            } else {
                System.out.println("Arquivo não encontrado");
            }
        }
        executarComando(textoDoArquivo);
    }

    private void executarComando(String query) throws SQLException {
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            statement.executeQuery(query);
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public void receberInstrucao(String query) {

        String select = "SELECT * FROM " + descobrirNomeTabela(query);

        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            try (final ResultSet resultSet = statement.executeQuery(select)) {

                while (resultSet.next()) {
                    final long id = resultSet.getLong("ID");
                    final String nome = resultSet.getString("NOME");
                    final int idade = resultSet.getInt("IDADE");

                    System.out.format("ID: %s NOME: %s IDADE: %s \n", id, nome, idade);
                }

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    private String descobrirNomeTabela(String query) {
        String[] arrayQuery = query.split(" ");
        String nomeTabela = "";
        for (int i = 0; i < arrayQuery.length; i++) {
            if (arrayQuery[i].equalsIgnoreCase("from") || arrayQuery[i].equalsIgnoreCase("into")) {
                nomeTabela = arrayQuery[i + 1];
                return nomeTabela;
            }
        }
        return null;
    }

    public void importarCSV(String arquivo) {
        try {
            final Reader reader = new FileReader(arquivo);
            final BufferedReader bufferReader = new BufferedReader(reader);

            String propriedades[];
            String linha = bufferReader.readLine();
            while (linha != null) {
                propriedades = linha.split(";");
                executarComando(propriedades);
                linha = bufferReader.readLine();
            }
        } catch (Exception e) {

        }
    }
    private void executarComando(String array[]) throws SQLException{
        for (int i = 0; i < array.length; i++) {
            executarComando(array[i]);
        }
    }

    public void exportarCSV(String nomeTabela) throws IOException {
        File file = new File("teste.csv");
        file.createNewFile();
        String tabela = "";

        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            try (final ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nomeTabela)) {

                while (resultSet.next()) {
                    final long id = resultSet.getLong("ID");
                    final String nome = resultSet.getString("NOME");
                    final int idade = resultSet.getInt("IDADE");
                    tabela += String.format("ID: %s NOME: %s IDADE: %s;\n", id, nome, idade);
                }
                new MeuWriterUtils().escreveArquivo(file.getName(), tabela);
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
