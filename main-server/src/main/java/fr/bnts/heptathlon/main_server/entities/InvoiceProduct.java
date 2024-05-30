package fr.bnts.heptathlon.main_server.entities;

public class InvoiceProduct {
    private int id;
    private int checkoutId;
    private float price;
    private int quantity;
    private Product product;

    public int getId() {
        return id;
    }

    public int getCheckoutId() {
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

    public InvoiceProduct(int id, int checkoutId, float price, int quantity, Product product) {
        this.id = id;
        this.checkoutId = checkoutId;
        this.price = price;
        this.quantity = quantity;
        this.product = product;
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
