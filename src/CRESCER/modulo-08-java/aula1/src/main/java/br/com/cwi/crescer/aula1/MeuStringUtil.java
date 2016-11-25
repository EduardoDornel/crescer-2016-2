/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

/**
 *
 * @author eduardo.ribas
 */
public class MeuStringUtil {
    public boolean validarString(String texto){
        return texto.length() > 0;
    }
    
    public int calcularVogais(String texto){
        int quantidade = 0;
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            switch (letra){
                case 'a':
                    quantidade++;
                    break;
                case 'e':
                    quantidade++;
                    break;
                case 'i':
                    quantidade++;
                    break;
                case 'o':
                    quantidade++;
                    break;
                case 'u':
                    quantidade++;
                    break;
            }
        }
        return quantidade;
    }
    
    public String inverterString(String texto){
        return new StringBuilder(texto).reverse().toString();
    }    
    
    public boolean identificarPalindromo(String texto){
        return texto.equals(inverterString(texto));
    }
    
    public void main(){
        System.out.println("Validar String\n"
                         + "Calcular Vogais\n"
                         + "Inverter String\n"
                         + "Identificar palíndromo");
    }
}
