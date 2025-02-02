package fr.bnts.heptathlon.main_server.entities;

import java.io.Serializable;

public class InvoiceProduct implements Serializable {
    private final String id;
    private final String checkoutId;
    private final float price;
    private final int quantity;
    private final Product product;

    public InvoiceProduct(String id, String checkoutId, float price,
                          int quantity, Product product) {
        this.id = id;
        this.checkoutId = checkoutId;
        this.price = price;
        this.quantity = quantity;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "InvoiceProduct{" +
                "id=" + id +
                ", checkoutId=" + checkoutId +
                ", price=" + price +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
