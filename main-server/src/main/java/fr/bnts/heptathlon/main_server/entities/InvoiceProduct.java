package fr.bnts.heptathlon.main_server.entities;

import java.io.Serializable;

public class InvoiceProduct implements Serializable {
    private String id;
    private String checkoutId;
    private float price;
    private int quantity;
    private Product product;
    private Invoice invoice;

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

    public Invoice getInvoice() {
        return invoice;
    }

    public InvoiceProduct(String id, String checkoutId, float price,
                          int quantity, Product product, Invoice invoice) {
        this.id = id;
        this.checkoutId = checkoutId;
        this.price = price;
        this.quantity = quantity;
        this.product = product;
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "InvoiceProduct{" +
                "id=" + id +
                ", checkoutId=" + checkoutId +
                ", price=" + price +
                ", quantity=" + quantity +
                ", product=" + product +
                ", invoice=" + invoice +
                '}';
    }
}
