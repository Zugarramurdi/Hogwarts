package DataBase;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

        private static Properties loadProperties(){
            Properties prop = new Properties();
            try(InputStream in = Files.newInputStream(Paths.get("config/db.properties"))){
                prop.load(in);
            } catch (IOException e){
                System.err.println("Nose ha podido leer el fichero properties "+e.getMessage());
            }
            return prop;
        }

        public static Connection getConnection() {
            try {
                Properties prop = loadProperties();

                String url = prop.getProperty("db.url");
                String user = prop.getProperty("db.user");
                String password = prop.getProperty("db.password");

                Connection conn = DriverManager.getConnection(url,user,password);
                System.out.println("✅✅✅ Connected to Hogwarts!");

                return conn;

            } catch (SQLException e) {
                throw new RuntimeException("❌❌❌ No se admiten Muggles ",e);
            }
        }

}
