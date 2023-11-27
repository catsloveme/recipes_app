package app.recipes.repository;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnector {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";

    private static Connection connection;


    static {
        FileInputStream fileInputStream;
        Properties property = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            property.load(fileInputStream);

            String URL = property.getProperty("datasource.url");
            String USERNAME = System.getenv("POSTGRESQL_USERNAME");
            String PASSWORD = System.getenv("POSTGRESQL_PASSWORD");

            Class.forName(property.getProperty("datasource.driver"));
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
