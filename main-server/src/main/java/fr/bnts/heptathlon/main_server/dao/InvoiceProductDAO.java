package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class InvoiceProductDAO {
    public static List<InvoiceProduct> get(Database database,
                                           String checkoutId) throws SQLException {
        List<InvoiceProduct> products = new ArrayList<>();
        database.prepareQuery("SELECT * FROM INVOICE_PRODUCT WHERE " +
                        "CHECKOUT_ID = ?",
                preparedStatement -> {
            try {
                preparedStatement.setString(1, checkoutId);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("ID_INVOICE_PRODUCT");
                    float price = resultSet.getFloat("PRICE");
                    int quantity = resultSet.getInt("QUANTITY");
                    String productId = resultSet.getString("ID_PRODUCT");

                    Product product = ProductDAO.get(database, productId);

                    products.add(new InvoiceProduct(id, checkoutId, price, quantity, product));
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return products;
    }

    public static List<InvoiceProduct> get(Database database, Invoice invoice) throws SQLException {
        return get(database, invoice.getId());
    }

    public static void add(Database database, InvoiceProduct invoiceProduct) throws SQLException {
        database.prepareQuery("INSERT INTO INVOICE_PRODUCT " +
                        "(ID_INVOICE_PRODUCT, CHECKOUT_ID, PRICE, QUANTITY, ID_PRODUCT) VALUES (?, ?, ?, ?, ?)",
                preparedStatement -> {
            try {
                preparedStatement.setString(1, invoiceProduct.getId());
                preparedStatement.setString(2, invoiceProduct.getCheckoutId());
                preparedStatement.setFloat(3, invoiceProduct.getPrice());
                preparedStatement.setInt(4, invoiceProduct.getQuantity());
                preparedStatement.setString(5,
                        invoiceProduct.getProduct().getId());

                preparedStatement.executeUpdate();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
