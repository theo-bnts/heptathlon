package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.tools.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ProductDAO {
    public static Product get(String reference) throws SQLException {
        AtomicReference<Product> product = new AtomicReference<>();
        Database.prepareQuery("SELECT * FROM PRODUCT WHERE REFERENCE = ?", preparedStatement -> {
            try {
                preparedStatement.setString(1, reference);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    float price = resultSet.getFloat("PRICE");
                    int quantity = resultSet.getInt("QUANTITY");
                    int idCategory = resultSet.getInt("ID_PRODUCT_CATEGORY");

                    ProductCategory category = ProductCategoryDAO.get(idCategory);

                    product.set(new Product(reference, name, price, quantity, category));
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return product.get();
    }

    public static List<Product> get(ProductCategory category) throws SQLException {
        List<Product> products = new ArrayList<>();
        Database.prepareQuery("SELECT * FROM PRODUCT WHERE ID_PRODUCT_CATEGORY = ?", preparedStatement -> {
            try {
                preparedStatement.setInt(1, category.getId());

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String reference = resultSet.getString("REFERENCE");
                    String name = resultSet.getString("NAME");
                    float price = resultSet.getFloat("PRICE");
                    int quantity = resultSet.getInt("QUANTITY");

                    if (quantity > 0) {
                        products.add(new Product(reference, name, price, quantity, category));
                    }
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return products;
    }
}
