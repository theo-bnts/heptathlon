package fr.bnts.heptathlon.main_server.database;

import java.io.Serializable;
import java.sql.*;
import java.util.function.Consumer;

public class DatabaseImpl implements Database, Serializable {
    public static final String URL = "jdbc:mysql://localhost:3308/main_server";
    public static final String USER = "main_server";
    public static final String PASSWORD = "main_server";

    public Connection connection;

    public void checkConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

    public void prepareQuery(String query,
                             Consumer<PreparedStatement> preparedStatementConsumer) throws SQLException {
        checkConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatementConsumer.accept(preparedStatement);
    }

    public void executeQuery(String query, Consumer<ResultSet> resultSetConsumer) throws SQLException {
        checkConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        resultSetConsumer.accept(resultSet);
    }
}
