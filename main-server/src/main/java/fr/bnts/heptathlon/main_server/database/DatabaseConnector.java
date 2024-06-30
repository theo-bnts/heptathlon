package fr.bnts.heptathlon.main_server.database;

import java.io.Serializable;
import java.sql.*;
import java.util.function.Consumer;

public class DatabaseConnector implements Serializable {
    public final String url;
    public final String user;
    public final String password;

    public Connection connection;

    public DatabaseConnector(String host, int port, String database,
                             String user,
                             String password) {
        this.url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        this.user = user;
        this.password = password;
    }

    public void checkConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, user, password);
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
