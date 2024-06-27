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
                // Créer et afficher l'écran administrateur
                AdminScreen adminScreen = new AdminScreen(parentFrame);
                parentFrame.setContentPane(adminScreen.getPanel());
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        // Vous pouvez ajouter d'autres écouteurs pour d'autres boutons ici
    }

    public JPanel getPanel() {
        return panel1;
    }
}
