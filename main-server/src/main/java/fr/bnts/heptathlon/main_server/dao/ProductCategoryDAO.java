package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.ProductCategory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDAO {
    public static List<ProductCategory> getProductCategories() {
        List<ProductCategory> categories = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/main_server", "main_server", "main_server");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT_CATEGORY");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID_PRODUCT_CATEGORY");
                String name = resultSet.getString("NAME");
                categories.add(new ProductCategory(id, name));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
