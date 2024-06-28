package fr.bnts.heptathlon.client_front.screens;

import org.jdatepicker.JDateComponentFactory;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AdminGrossSalesScreen {
    private JPanel panel1;
    private JDatePicker datePicker1;
    private JDatePicker datePicker2;
    private JButton validateButton;
    private JLabel resultLabel;

    public AdminGrossSalesScreen() {
        JDateComponentFactory factory = new JDateComponentFactory();
        datePicker1 = factory.createJDatePicker();
        datePicker2 = factory.createJDatePicker();

        validateButton = new JButton("Valider");
        resultLabel = new JLabel("");

        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add((JComponent) datePicker1);
        panel1.add((JComponent) datePicker2);
        panel1.add(validateButton);
        panel1.add(resultLabel);

        validateButton.addActionListener(e -> {
            Calendar selectedCalendar1 = (Calendar) datePicker1.getModel().getValue();
            Calendar selectedCalendar2 = (Calendar) datePicker2.getModel().getValue();

            if (selectedCalendar1 != null && selectedCalendar2 != null) {
                Date selectedDate1 = selectedCalendar1.getTime();
                Date selectedDate2 = selectedCalendar2.getTime();

                long diffInMillies = Math.abs(selectedDate2.getTime() - selectedDate1.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                resultLabel.setText("Nombre de jours entre les deux dates : " + diff);
            } else {
                resultLabel.setText("Veuillez sélectionner les deux dates.");
            }
        });
    }

    public JPanel getPanel() {
        return panel1;
    }
}