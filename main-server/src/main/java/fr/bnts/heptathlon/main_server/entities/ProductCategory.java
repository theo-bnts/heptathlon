package fr.bnts.heptathlon.main_server.entities;

import java.io.Serial;
import java.io.Serializable;

public class ProductCategory implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
}
