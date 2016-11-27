/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Eduardo
 */
public class MeuFileUtils {

    public void mk(String nome) {
        String extensao = null;
        try{
            extensao = nome.substring(nome.lastIndexOf("."), nome.length());
        }catch(Exception e){
        }
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

    public void rm(String nome) {
        String extensao = null;
        try{
            extensao = nome.substring(nome.lastIndexOf("."), nome.length());
        }catch(Exception e){
        }
        if (extensao == null) {
            System.out.println("Arquivo inválido");
        } else {
            final boolean b = new File(nome).delete();
        }
    }

    public void ls(String nome) {
        String extensao = null;
        File file = new File(nome);       
        try{
            extensao = nome.substring(nome.lastIndexOf("."), nome.length());
        }catch(Exception e){
        }      
        if (extensao == null) {
            final File[] list = file.listFiles();
            for (File f : list) {
                System.out.println(f);
            }
        } else {
            System.out.println(file.getAbsolutePath());
        }
    }

    public void mv(String nome, String nomeNovo) {
        String extensao = null;
        try{
            extensao = nome.substring(nome.lastIndexOf("."), nome.length());
        }catch(Exception e){
        }     
        if (extensao == null) {
            System.out.println("Arquivo inválido");
        } else {
            File file = new File(nome);
            if (file.renameTo(new File(nomeNovo + file.getName()))) {
                System.out.println("Arquivo movido com sucesso");
            }
        }
    }
}
