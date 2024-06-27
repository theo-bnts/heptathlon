package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.tools.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class InvoiceProductDAO {
    public static List<InvoiceProduct> get(String checkoutId) throws SQLException {
        List<InvoiceProduct> products = new ArrayList<>();
        Database.prepareQuery("SELECT * FROM INVOICE_PRODUCT WHERE CHECKOUT_ID = ?",
                preparedStatement -> {
            try {
                preparedStatement.setString(1, checkoutId);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("ID_INVOICE_PRODUCT");
                    float price = resultSet.getFloat("PRICE");
                    int quantity = resultSet.getInt("QUANTITY");
                    String productId = resultSet.getString("ID_PRODUCT");

                    Product product = ProductDAO.get(productId);

                    products.add(new InvoiceProduct(id, checkoutId, price, quantity, product, null));
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return products;
    }

    public static List<InvoiceProduct> get(Invoice invoice) throws SQLException {
        List<InvoiceProduct> products = new ArrayList<>();
        Database.prepareQuery("SELECT * FROM INVOICE_PRODUCT WHERE ID_INVOICE = ?",
                preparedStatement -> {
            try {
                preparedStatement.setString(1, invoice.getId());

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("ID_INVOICE_PRODUCT");
                    String checkoutId = resultSet.getString("CHECKOUT_ID");
                    float price = resultSet.getFloat("PRICE");
                    int quantity = resultSet.getInt("QUANTITY");
                    String productId = resultSet.getString("ID_PRODUCT");

                    Product product = ProductDAO.get(productId);

                    products.add(new InvoiceProduct(id, checkoutId, price, quantity, product, invoice));
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return products;
    }

    public static void add(InvoiceProduct invoiceProduct) throws SQLException {
        Database.prepareQuery("INSERT INTO INVOICE_PRODUCT " +
                        "(ID_INVOICE_PRODUCT, CHECKOUT_ID, PRICE, QUANTITY, " +
                "REFERENCE, ID_INVOICE, ID_PRODUCT) VALUES (?, ?, ?, ?, ?, ?," +
                " ?)",
                preparedStatement -> {
            try {
                preparedStatement.setString(1, invoiceProduct.getId());
                preparedStatement.setString(2, invoiceProduct.getCheckoutId());
                preparedStatement.setFloat(3, invoiceProduct.getPrice());
                preparedStatement.setInt(4, invoiceProduct.getQuantity());
                preparedStatement.setString(5, invoiceProduct.getProduct().getId());
                preparedStatement.setString(6, invoiceProduct.getInvoice() != null ? invoiceProduct.getInvoice().getId() : null);
                preparedStatement.setInt(7, invoiceProduct.getProduct().getCategory().getId());
                preparedStatement.executeUpdate();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
