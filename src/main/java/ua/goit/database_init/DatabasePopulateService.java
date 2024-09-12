package ua.goit.database_init;

import ua.goit.exception.ConnectionException;
import ua.goit.reader.SQLReader;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static ua.goit.constant.Constant.CONNECTION_TROUBLE_MESSAGE;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String contentSql = new SQLReader().readContent(Path.of("./sql/populate_db.sql"));
        Connection connection = null;
        try {
            connection = DataBase.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConnectionException(CONNECTION_TROUBLE_MESSAGE);
        }
        try (Statement statement = connection.createStatement()) {
            statement.execute(contentSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
