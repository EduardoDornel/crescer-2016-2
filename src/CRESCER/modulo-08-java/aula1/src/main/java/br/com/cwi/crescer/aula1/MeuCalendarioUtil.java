/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 *
 * @author eduardo.ribas
 */
public class MeuCalendarioUtil {
    public String diaDaSemana(Date date){
        final Calendar calendar = Calendar.getInstance();
        final Locale locale = new Locale("pt", "BR");
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);  
    }
    
    public String calcularDiferencaData(LocalDate date){
        LocalDate now = LocalDate.now();
        
        int dia = 0;
        int mes = 0;
        int ano = 0;
        
        //long diferencaAnos = ((now.getTime() - date.getTime()) / (1000*60*60*24) / 30) / 12;
        //long diferenca = now.getDay() - date.getDay();
        //int tempoDia = 1000 * 60 * 60 * 24;
        int diferencaEmDias = Math.abs((int)ChronoUnit.DAYS.between(now, date));
        
       // long diferencaEmMes = ChronoUnit.MONTHS.between(now, date);
       //long diferencaEmAnos = ChronoUnit.YEARS.between(now, date);
        //if(diferencaEmDias >= 365){
        //}
        while(diferencaEmDias != 0){
            if(diferencaEmDias >= 365){
                ano++;
                diferencaEmDias -= 365;
            }
            else if(diferencaEmDias >= 30){
                mes++;
                diferencaEmDias -= 30;
            }
            else{
                dia = (int)diferencaEmDias;
                diferencaEmDias = 0;
            }
        }
        String diferenca = "";
        diferenca += System.out.format("%s ano(s), %s mes(es), e %s dia(s)", ano, mes, dia);
        return diferenca;
    }
    
    public void main(){
        System.out.println("Dia da semana que nasceu\n"+
                           "Calcular tempo decorrido a partir de uma data");
    }
}
