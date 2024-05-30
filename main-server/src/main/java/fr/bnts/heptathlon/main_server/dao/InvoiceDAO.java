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
                    int id = resultSet.getInt("ID_INVOICE");
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
}
