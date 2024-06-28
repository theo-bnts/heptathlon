package fr.bnts.heptathlon.main_server.entities;

import java.io.Serializable;

public class ProductCategory implements Serializable {
    private int id;
    private String name;

    public ProductCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
