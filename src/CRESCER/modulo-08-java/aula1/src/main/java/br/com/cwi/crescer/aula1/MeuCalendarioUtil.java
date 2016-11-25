/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    
    public Date calcularDiferencaData(LocalDate date){
        LocalDate now = LocalDate.now();
        
        //long diferencaAnos = ((now.getTime() - date.getTime()) / (1000*60*60*24) / 30) / 12;
        //long diferenca = now.getDay() - date.getDay();
        //int tempoDia = 1000 * 60 * 60 * 24;
        //long diferencaEmDias = ChronoUnit.DAYS.between(now, date);
       // long diferencaEmMes = ChronoUnit.MONTHS.between(now, date);
       //long diferencaEmAnos = ChronoUnit.YEARS.between(now, date);
        //if(diferencaEmDias >= 365){
            
        //}
        
        return new Date(12, 02, 1997);
    }
    
    public void main(){
        System.out.println("Dia da semana que nasceu/n"+
                           "Calcular tempo decorrido a partir de uma data");
    }
}
