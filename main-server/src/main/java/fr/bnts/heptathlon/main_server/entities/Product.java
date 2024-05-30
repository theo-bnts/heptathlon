package fr.bnts.heptathlon.main_server.entities;

import java.io.Serializable;

public class Product implements Serializable {
    private String reference;
    private String name;
    private float price;
    private int quantity;
    private ProductCategory category;

    public String getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public Product(String reference, String name, float price, int quantity,
                   ProductCategory category) {
        this.reference = reference;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "reference='" + reference + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';
    }
}
