/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.sql.*;

/**
 *
 * @author eduardo.ribas
 */
public class ConnectionUtils {

    private static final String URL = /*"jdbc:oracle:thin:@10.99.2.45:1521:xe"*/ "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = /*"cwi"*/ "system";
    private static final String PASS = /*"cwi"*/ "crescer";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
    
}
