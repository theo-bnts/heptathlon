package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.database.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ProductCategoryDAO {
    public static ProductCategory get(Database database, int idCategory) throws SQLException {
        AtomicReference<ProductCategory> category = new AtomicReference<>();
        database.prepareQuery("SELECT NAME FROM PRODUCT WHERE " +
                        "ID_PRODUCT_CATEGORY = ?",
                preparedStatement -> {
                    try {
                        preparedStatement.setInt(1, idCategory);

                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            String name = resultSet.getString("NAME");

                            category.set(new ProductCategory(idCategory, name));
                        }
                    }
                    catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
        return category.get();
    }

    public static List<ProductCategory> get(Database database) throws SQLException {
        List<ProductCategory> categories = new ArrayList<>();
        database.executeQuery("SELECT * FROM PRODUCT_CATEGORY", resultSet -> {
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID_PRODUCT_CATEGORY");
                    String name = resultSet.getString("NAME");

                    categories.add(new ProductCategory(id, name));
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return categories;
    }

    public static void add(Database database, ProductCategory category) throws SQLException {
        database.prepareQuery("INSERT INTO PRODUCT_CATEGORY (ID_PRODUCT_CATEGORY, NAME) VALUES (?, ?)",
                preparedStatement -> {
                    try {
                        preparedStatement.setInt(1, category.getId());
                        preparedStatement.setString(2, category.getName());

                        preparedStatement.executeUpdate();
                    }
                    catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
