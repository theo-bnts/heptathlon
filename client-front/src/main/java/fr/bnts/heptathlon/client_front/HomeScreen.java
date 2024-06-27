package fr.bnts.heptathlon.client_front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen {
    private JButton ecranCaisseButton;
    private JPanel panel1;
    private JButton ecranAdministrateurButton;
    private JFrame parentFrame;

    public HomeScreen(JFrame frame) {
        this.parentFrame = frame;

        ecranAdministrateurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminScreen adminScreen = new AdminScreen(parentFrame);
                parentFrame.setContentPane(adminScreen.getPanel());
                parentFrame.revalidate();
                parentFrame.pack();
            }
        });
    }

    public JPanel getPanel() {
        return panel1;
    }
}
