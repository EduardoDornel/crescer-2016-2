/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class MeuFileUtils {
        
    public MeuFileUtils(String metodo){
        Scanner s = new Scanner(System.in);
        switch(metodo){
            case "mk":
                System.out.println("Digite o caminho do arquivo/pasta que deseja criar!");
                mk(s.nextLine());
                break;
            case "rm":
                System.out.println("Digite o caminho do arquivo que deseja excluir");
                rm(s.nextLine());
                break;
            case "ls":
                System.out.println("Digite o nome do arquivo que deseja saber o caminho absoluto ou da pasta que deseja conhecer seus itens");
                ls(s.nextLine());
                break;
            case "mv":
                System.out.println("Digite o caminho atual do arquivo");
                String antigoCaminho = s.nextLine();
                System.out.println("Digite o novo caminho do arquivo");
                String novoCaminho = s.nextLine();
                mv(antigoCaminho, novoCaminho);
                break;
            default:
                System.out.println("Você não digitou um comando existente.");
        }
        s.close();
    }

    private void mk(String nome) {
        String extensao = verificaExtensao(nome);  
        if (extensao == null) {
            final File diretorio = new File(nome);
            diretorio.mkdirs();
        } else{ 
            try{
                File arquivo = new File(nome);
                boolean b = arquivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void rm(String nome) {
        String extensao = verificaExtensao(nome);  
        if (extensao == null) {
            System.out.println("Arquivo inválido");
        } else {
            final boolean b = new File(nome).delete();
        }
    }

    private void ls(String nome) {
        String extensao = verificaExtensao(nome);  
        File file = new File(nome);             
        if (extensao == null) {
            final File[] list = file.listFiles();
            for (File f : list) {
                System.out.println(f);
            }
        } else {
            System.out.println(file.getAbsolutePath());
        }
    }

    private void mv(String nome, String nomeNovo) {
        String extensao = verificaExtensao(nome);  
        if (extensao == null) {
            System.out.println("Arquivo inválido");
        } else {
            File file = new File(nome);
            if (file.renameTo(new File(nomeNovo + file.getName()))) {
                System.out.println("Arquivo movido com sucesso");
            }
        }
    }
    
    private String verificaExtensao(String arquivo){
        String extensao = null;
        try{
            extensao = arquivo.substring(arquivo.lastIndexOf("."), arquivo.length());
        }catch(Exception e){
        }
        return extensao;
    }
}
