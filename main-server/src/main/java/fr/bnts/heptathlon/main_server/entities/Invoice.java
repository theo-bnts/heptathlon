package fr.bnts.heptathlon.main_server.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Invoice implements Serializable {
    private int id;
    private LocalDateTime publishedDate;
    private float price;
    private String paymentMethod;
}
