package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.Invoice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InvoiceFileDAO {
    public static void send(Invoice invoice, byte[] file) throws IOException {
        Path fileFullPath = Paths.get("../main-server/src/main/resources" +
                        "/" + invoice.getId() + ".txt");
        Files.write(fileFullPath, file);
    }
}
