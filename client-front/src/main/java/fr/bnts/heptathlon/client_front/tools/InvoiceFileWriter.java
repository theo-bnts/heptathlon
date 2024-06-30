package fr.bnts.heptathlon.client_front.tools;

import fr.bnts.heptathlon.main_server.dao.InvoiceFileDAO;
import fr.bnts.heptathlon.main_server.dao.InvoiceProductDAO;
import fr.bnts.heptathlon.main_server.database.DatabaseConnector;
import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.entities.InvoiceProduct;
import fr.bnts.heptathlon.main_server.rmi.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public abstract class InvoiceFileWriter {
    public static void write(Service service, String packageName,
                             Invoice invoice) throws SQLException, IOException {
        StringBuilder content = new StringBuilder();
        content
                .append("Invoice ID: ")
                .append(invoice.getId())
                .append("\n");

        content
                .append("Published date: ")
                .append(invoice.getPublishedDate())
                .append("\n");

        content
                .append("Total price: ")
                .append(invoice.getPrice())
                .append("€")
                .append("\n");

        content
                .append("Payment method: ")
                .append(invoice.getPaymentMethod())
                .append("\n");

        content
                .append("Details: ")
                .append("\n");

        List<InvoiceProduct> invoiceProducts = service.getInvoiceProducts(invoice);

        for (InvoiceProduct invoiceProduct : invoiceProducts) {
            content
                    .append(invoiceProduct.getQuantity())
                    .append(" x ")
                    .append(invoiceProduct.getProduct().getName())
                    .append("\t= ")
                    .append(invoiceProduct.getProduct().getPrice() * invoiceProduct.getQuantity())
                    .append("€\n");
        }

        byte[] file = content.toString().getBytes();

        InvoiceFileDAO.write(packageName, invoice, file);
    }
}
