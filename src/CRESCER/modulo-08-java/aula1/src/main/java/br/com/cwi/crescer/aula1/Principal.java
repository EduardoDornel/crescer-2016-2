/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author eduardo.ribas
 */
public class Principal {
    public static void main(String [] args){
        String nome = "eduardo/bin/args.";
        String extensao = nome.substring(nome.lastIndexOf("."), nome.length());
        System.out.println(extensao);
        
        
       Parcelator p = new Parcelator();
       MeuCalendarioUtil m = new MeuCalendarioUtil();
       
       System.out.println(m.diaDaSemana(new Date()));
       System.out.println(p.jurosSimples(1000, 10, 10, new Date()));
      }
}
