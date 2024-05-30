package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.ProductCategory;
import fr.bnts.heptathlon.main_server.tools.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ProductCategoryDAO {
    public static List<ProductCategory> get() throws SQLException {
        List<ProductCategory> categories = new ArrayList<>();
        Database.executeQuery("SELECT * FROM PRODUCT_CATEGORY", resultSet -> {
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

    public static ProductCategory get(int idCategory) throws SQLException {
        AtomicReference<ProductCategory> category = new AtomicReference<>();
        Database.prepareQuery("SELECT NAME FROM PRODUCT WHERE ID_PRODUCT_CATEGORY = ?",
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
}
