/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.*;

/**
 *
 * @author Eduardo
 */
public class MeuWriterUtils {
    public void escreveArquivo(String arquivo, String texto){
        String extensao = null;
        try{
            extensao = arquivo.substring(arquivo.lastIndexOf("."), arquivo.length());
        }catch(Exception e){
        }
        if(extensao == null){
            System.out.println("Você não passou o arquivo corretamente.");
        }
        else if(!extensao.equals(".txt") && !extensao.equals(".csv")){
            System.out.println("Arquivo incompatível.");
        }
        else{
            File file = new File(arquivo);
            if(file.exists()){
                try {
                    FileWriter fr = new FileWriter(file);
                    PrintWriter out = new PrintWriter(fr);
                    out.println(texto);
                    out.close();
                } catch (FileNotFoundException e) {
                }catch (IOException e) {
                    System.out.println("Erro na escrita de " + arquivo+".");
                }
            }
            else{
                System.out.println("Arquivo não encontrado");
            }
        }
    }
}
