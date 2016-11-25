/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

//import br.com.cwi.crescer.aula1.MeuCalendarioUtil;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author eduardo.ribas
 */
public class Exemplo1 {
    public  static void main(String args[]){
        try {
            final File file= new File("aula2.txt");
            final boolean b = file.createNewFile();
            if(file.exists()){
                System.out.println(file.getAbsolutePath());
            }
            
            } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
