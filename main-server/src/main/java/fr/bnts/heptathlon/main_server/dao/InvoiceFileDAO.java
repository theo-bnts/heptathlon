package fr.bnts.heptathlon.main_server.dao;

import fr.bnts.heptathlon.main_server.entities.Invoice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InvoiceFileDAO {
    public static String getFullPath(String packageName, Invoice invoice) {
        return "../" + packageName + "/src/main/resources" +
                "/" + invoice.getId() + ".txt";
    }

    public static byte[] read(String packageName, Invoice invoice) throws IOException {
        Path fileFullPath = Paths.get(getFullPath(packageName, invoice));
        return Files.readAllBytes(fileFullPath);
    }

    public static void write(String packageName, Invoice invoice, byte[] file) throws IOException {
        Path fileFullPath = Paths.get(getFullPath(packageName, invoice));
        Files.write(fileFullPath, file);
    }
}
