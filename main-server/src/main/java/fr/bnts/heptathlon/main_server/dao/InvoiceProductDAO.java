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
    public static List<InvoiceProduct> get(Invoice invoice) throws SQLException {
        List<InvoiceProduct> products = new ArrayList<>();
        Database.prepareQuery("SELECT * FROM INVOICE_PRODUCT WHERE ID_INVOICE = ?",
                preparedStatement -> {
            try {
                preparedStatement.setInt(1, invoice.getId());

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID_INVOICE_PRODUCT");
                    int checkout = resultSet.getInt("CHECKOUT");
                    float price = resultSet.getFloat("PRICE");
                    int quantity = resultSet.getInt("QUANTITY");
                    String productId = resultSet.getString("ID_PRODUCT");

                    Product product = ProductDAO.get(productId);

                    products.add(new InvoiceProduct(id, checkout, price, quantity, product));
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return products;
    }
}
