/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.util.*;

/**
 *
 * @author eduardo.ribas
 */
public class MeuCalendarioUtil {
    public String diaDaSemana(Date date){
       /* ESTE EXEMPLO RETORNA O DIA EM INGLES 
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String diaDaSemana = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
        return diaDaSemana;*/
        final Calendar calendar = Calendar.getInstance();
        final Locale locale = new Locale("pt", "BR");
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);  
    }
    
    public Date calcularDiferencaData(Date date){
        return null;
    }
}
