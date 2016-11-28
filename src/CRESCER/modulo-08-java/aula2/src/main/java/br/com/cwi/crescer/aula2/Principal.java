/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.sql.SQLException;

/**
 *
 * @author Eduardo
 */
public class Principal {
    public static void main(String[] args) throws SQLException {
        MeuSQLUtils m = new MeuSQLUtils();
        
        m.executarSQLDeArquivo("teste.sql");
    }
}
