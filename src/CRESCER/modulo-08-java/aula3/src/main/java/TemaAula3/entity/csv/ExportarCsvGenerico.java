/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemaAula3.entity.csv;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Eduardo
 */
public class ExportarCsvGenerico {

    public void exportarCsv(String nomeTabela) throws SQLException, IOException {
        File file = new File("teste.csv");
        file.createNewFile();
        String tabela = "";

        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();
            ) {
            try (final ResultSet resultSet = statement.executeQuery("SELECT * FROM "+nomeTabela+" INTO OUTFILE 'teste.csv' LINES TERMINATED BY 'n';")) {
            }
        catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
