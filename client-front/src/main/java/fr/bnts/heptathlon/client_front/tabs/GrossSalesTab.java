package fr.bnts.heptathlon.client_front.tabs;

import fr.bnts.heptathlon.main_server.entities.Invoice;
import fr.bnts.heptathlon.main_server.rmi.Service;
import org.jdatepicker.JDateComponentFactory;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GrossSalesTab {
    private final JPanel panel1;
    private final JDatePicker datePicker1;
    private final JDatePicker datePicker2;
    private final JButton validateButton;
    private final JLabel resultLabel;
    private List<Invoice> invoices;
    private Service clientServerService;

    public GrossSalesTab(Service clientServerService) throws SQLException, RemoteException {
        this.clientServerService = clientServerService;

        this.refreshData();

        JDateComponentFactory factory = new JDateComponentFactory();

        this.datePicker1 = factory.createJDatePicker();
        Date aMonthAgo = dateFromAMonthAgo();
        this.datePicker1.getModel().setDate(
                aMonthAgo.getYear() + 1900,
                aMonthAgo.getMonth(),
                aMonthAgo.getDate()
        );

        this.datePicker2 = factory.createJDatePicker();

        this.validateButton = new JButton("Valider");
        this.resultLabel = new JLabel("");

        this.panel1 = new JPanel();
        this.panel1.setLayout(new FlowLayout());
        this.panel1.add((JComponent) this.datePicker1);
        this.panel1.add((JComponent) this.datePicker2);
        this.panel1.add(this.validateButton);
        this.panel1.add(this.resultLabel);

        this.addEventListeners();
    }

    public void refreshData() throws SQLException, RemoteException {
        this.invoices = this.clientServerService.getInvoices();
    }

    private Date dateFromAMonthAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    private void addEventListeners() {
        this.validateButton.addActionListener(e -> {
            this.handleValidateButton();
        });
    }

    private void handleValidateButton() {
        Calendar selectedCalendar1 =
                (Calendar) this.datePicker1.getModel().getValue();
        Calendar selectedCalendar2 =
                (Calendar) this.datePicker2.getModel().getValue();

        Date selectedDate1 = selectedCalendar1.getTime();
        Date selectedDate2 = selectedCalendar2.getTime();

        LocalDateTime localDateTime1 = this.convertToLocalDateTime(selectedDate1)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
        LocalDateTime localDateTime2 = this.convertToLocalDateTime(selectedDate2)
                .withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);

        List<Invoice> filteredInvoices = this.filterInvoicesByDate(localDateTime1, localDateTime2);

        calculateTotalPrice(filteredInvoices);
    }

    private LocalDateTime convertToLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    private List<Invoice> filterInvoicesByDate(LocalDateTime date1,
                                               LocalDateTime date2) {
        return this.invoices.stream()
                .filter(invoice ->
                        !invoice.getPublishedDate().isBefore(date1) &&
                                !invoice.getPublishedDate().isAfter(date2))
                .toList();
    }

    private void calculateTotalPrice(List<Invoice> invoices) {
        double totalPrice = invoices.stream()
                .mapToDouble(Invoice::getPrice)
                .sum();

        this.resultLabel.setText("Total: " + totalPrice + "€");
    }

    public JPanel getPanel() {
        return panel1;
    }
}