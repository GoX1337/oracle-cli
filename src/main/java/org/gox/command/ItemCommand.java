package org.gox.command;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import io.quarkus.launcher.shaded.com.google.inject.Inject;
import picocli.CommandLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

@CommandLine.Command(name = "item", description = "Get an item from database")
public class ItemCommand implements Runnable {

    @Inject
    @DataSource("oracleds")
    AgroalDataSource dataSource;

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ITEM");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) sb.append(" ");
                sb.append(rsmd.getColumnName(i));
            }
            sb.append("\n");

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) sb.append(" ");
                    sb.append(rs.getString(i));
                }
                sb.append("\n");
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(sb);
    }
}
