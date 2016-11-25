/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula1;

import java.util.*;

/*
 * @author Eduardo
 */
public class Parcelator {
    /*
    Deve receber o valor, a taxa de juros, o nº de parcelas(messes) e a data do 1º 
    vencimento e retornar os valores e datas das parcelas. Ex. valor: 1000 juros: 10%, parcelas: 10 data: 30/06/2016
    30/06/2016 - R$ 110,00
    31/07/2016 - R$ 110,00
    30/08/2016 - R$ 110,00 ..
    */
    public String jurosSimples(double valor, double taxaJuros, int numParcelas, Date primeiroVencimento){
        double valorPorParcela = (valor + (valor * (taxaJuros / 100))) / numParcelas;
        String parcelasDetalhe = "";
        for (int i = 1; i <= numParcelas; i++) {
            parcelasDetalhe += System.out.format("%s - R$ %s \n",primeiroVencimento.toString(), valorPorParcela);
            primeiroVencimento.setMonth(primeiroVencimento.getMonth() + 1);
        }        
        return parcelasDetalhe;
    }
}
