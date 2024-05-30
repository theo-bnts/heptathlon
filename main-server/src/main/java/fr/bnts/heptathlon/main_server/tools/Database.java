package fr.bnts.heptathlon.main_server.tools;

import java.sql.*;
import java.util.function.Consumer;

public abstract class Database {
    public static final String URL = "jdbc:mysql://localhost:3308/main_server";
    public static final String USER = "main_server";
    public static final String PASSWORD = "main_server";

    public static void prepareQuery(String query, Consumer<PreparedStatement> preparedStatementConsumer) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatementConsumer.accept(preparedStatement);
        }
    }

    public static void executeQuery(String query, Consumer<ResultSet> resultSetConsumer) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            resultSetConsumer.accept(resultSet);
        }
    }
}
