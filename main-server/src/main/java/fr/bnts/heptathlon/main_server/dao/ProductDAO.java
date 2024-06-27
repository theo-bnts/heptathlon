package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.Product;
import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ProductDAO {
    public static List<Product> get(Database database) throws SQLException {
        List<Product> products = new ArrayList<>();
        database.executeQuery("SELECT * FROM PRODUCT", resultSet -> {
            try {
                while (resultSet.next()) {
                    String id = resultSet.getString("ID_PRODUCT");
                    String name = resultSet.getString("NAME");
                    float price = resultSet.getFloat("PRICE");
                    int quantity = resultSet.getInt("QUANTITY");
                    int categoryId = resultSet.getInt("ID_PRODUCT_CATEGORY");

                    ProductCategory category =
                            ProductCategoryDAO.get(database, categoryId);
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return products;
    }

    public static Product get(Database database, String reference) throws SQLException {
        AtomicReference<Product> product = new AtomicReference<>();
        database.prepareQuery("SELECT * FROM PRODUCT WHERE ID_PRODUCT = ?",
                preparedStatement -> {
            try {
                preparedStatement.setString(1, reference);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    float price = resultSet.getFloat("PRICE");
                    int quantity = resultSet.getInt("QUANTITY");
                    int categoryId = resultSet.getInt("ID_PRODUCT_CATEGORY");

                    ProductCategory category =
                            ProductCategoryDAO.get(database, categoryId);

                    product.set(new Product(reference, name, price, quantity, category));
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return product.get();
    }

    public static List<Product> get(Database database, ProductCategory category) throws SQLException {
        List<Product> products = new ArrayList<>();
        System.out.println(category);
        database.prepareQuery("SELECT * FROM PRODUCT WHERE " +
                "ID_PRODUCT_CATEGORY = ?", preparedStatement -> {
            try {
                preparedStatement.setInt(1, category.getId());

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString("ID_PRODUCT");
                    String name = resultSet.getString("NAME");
                    float price = resultSet.getFloat("PRICE");
                    int quantity = resultSet.getInt("QUANTITY");

                    products.add(new Product(id, name, price, quantity, category));
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return products;
    }

    public static void add(Database database, Product product) throws SQLException {
        database.prepareQuery("INSERT INTO PRODUCT (ID_PRODUCT, NAME, PRICE, QUANTITY, ID_PRODUCT_CATEGORY) VALUES (?, ?, ?, ?, ?)",
                preparedStatement -> {
            try {
                preparedStatement.setString(1, product.getId());
                preparedStatement.setString(2, product.getName());
                preparedStatement.setFloat(3, product.getPrice());
                preparedStatement.setInt(4, product.getQuantity());
                preparedStatement.setInt(5, product.getCategory().getId());

                preparedStatement.executeUpdate();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
