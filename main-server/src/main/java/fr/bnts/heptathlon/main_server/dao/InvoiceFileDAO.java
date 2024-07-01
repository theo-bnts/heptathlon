package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.Invoice;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InvoiceFileDAO implements Serializable {
    private final String ressourcesPath;

    public InvoiceFileDAO(String ressourcesPath) {
        this.ressourcesPath = ressourcesPath;
    }

    public Path getFullPath(Invoice invoice) {
        return Paths.get(this.ressourcesPath + invoice.getId() + ".txt");
    }

    public byte[] read(Invoice invoice) throws IOException {
        return Files.readAllBytes(this.getFullPath(invoice));
    }

    public void write(Invoice invoice, byte[] file) throws IOException {
        Files.write(this.getFullPath(invoice), file);
    }
}
