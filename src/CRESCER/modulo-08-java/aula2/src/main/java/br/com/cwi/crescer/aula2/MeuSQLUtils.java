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
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
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
                final Statement statement = connection.createStatement();
            ) {
                statement.executeQuery(query);
                //statement.close();
            } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
