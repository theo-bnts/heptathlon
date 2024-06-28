package fr.bnts.heptathlon.main_server.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Invoice implements Serializable {
    private String id;
    private LocalDateTime publishedDate;
    private float price;
    private String paymentMethod;

    public Invoice(String id, LocalDateTime publishedDate, float price,
                   String paymentMethod) {
        this.id = id;
        this.publishedDate = publishedDate;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public float getPrice() {
        return price;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", publishedDate=" + publishedDate +
                ", price=" + price +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
