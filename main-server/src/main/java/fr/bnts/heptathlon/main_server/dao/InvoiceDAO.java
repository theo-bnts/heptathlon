package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.tools.Database;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class InvoiceDAO {
    public static List<Invoice> get() throws SQLException {
        List<Invoice> invoices = new ArrayList<>();
        Database.executeQuery("SELECT * FROM INVOICE", resultSet -> {
            try {
                while (resultSet.next()) {
                    String id = resultSet.getString("ID_INVOICE");
                    LocalDateTime publishedDate =
                            resultSet.getTimestamp("PUBLISHED_DATE").toLocalDateTime();
                    float price = resultSet.getFloat("PRICE");
                    String paymentMethod = resultSet.getString("PAYMENT_METHOD");

                    invoices.add(new Invoice(id, publishedDate, price, paymentMethod));
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return invoices;
    }

    public static void add(Invoice invoice) throws SQLException {
        Database.prepareQuery("INSERT INTO INVOICE (ID_INVOICE, " +
                        "PUBLISHED_DATE, PRICE, PAYMENT_METHOD) VALUES (?, ?, ?)",
                preparedStatement -> {
            try {
                preparedStatement.setString(1, invoice.getId());
                preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(invoice.getPublishedDate()));
                preparedStatement.setFloat(3, invoice.getPrice());
                preparedStatement.setString(4, invoice.getPaymentMethod());

                preparedStatement.executeUpdate();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
