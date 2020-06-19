import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import io.quarkus.launcher.shaded.com.google.inject.Inject;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@QuarkusMain
public class HelloWorldMain implements QuarkusApplication {

    @Inject
    @DataSource("item")
    AgroalDataSource dataSource;

    @Override
    public int run(String... args) {
        System.out.println("Get sysdate");
        StringBuilder sb = new StringBuilder();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT SYSDATE FROM DUAL");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sb.append(rs.getString("sysdate")).append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(sb);
        return 0;
    }

}