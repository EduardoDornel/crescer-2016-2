/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eduardo.ribas
 */
public class PessoaFactory {

  /*  public static void create(String[] args) {
        final String ddl = "CREATE TABLE EDUARDO ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            statement.executeUpdate(ddl);

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }*/

    public void insert() throws SQLException {
        final String insert = "INSERT INTO EDUARDO("
                + "ID_PESSOA, NM_PESSOA ) "
                + "VALUES (?, ?)";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(insert)
            ) {
            for (int i = 1; i <= 10; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, String.format("%s pessoa de 10", i));
                preparedStatement.executeUpdate();
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
    
    public static void main(String[] args) throws SQLException {
        final PessoaFactory pessoaFactory = new PessoaFactory();
        pessoaFactory.insert();
    }
}
