package org.gox.command;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import io.quarkus.launcher.shaded.com.google.inject.Inject;
import picocli.CommandLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            while (rs.next()) {
                sb.append(rs.getString("sysdate")).append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(sb);
    }
}
