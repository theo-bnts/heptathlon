package fr.bnts.heptathlon.main_server.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;

public interface Database {
    public void prepareQuery(String query, Consumer<PreparedStatement> preparedStatementConsumer) throws SQLException;
    public void executeQuery(String query, Consumer<ResultSet> resultSetConsumer) throws SQLException;
}
