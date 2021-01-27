package solid.srp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SecondWrongSRP {
    private String url;
    private List<String> store;

    public SecondWrongSRP(String url) {
        this.url = url;

    }

    public List<String> read(String url) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
            while (reader.ready()) {
                result.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void save(Properties properties, String string) {
        try (Connection connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties
        )) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "insert into some_db (text) values (?)"
            )) {
                statement.setString(1, string);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
