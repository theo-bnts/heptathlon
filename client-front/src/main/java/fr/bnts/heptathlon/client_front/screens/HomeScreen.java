package fr.bnts.heptathlon.client_front.screens;

import fr.bnts.heptathlon.client_front.commons.Buttons;

import javax.swing.*;

public class HomeScreen {
    private JButton ecranCaisseButton;
    private JButton ecranAdministrateurButton;

    private JPanel panel1;

    public HomeScreen() {
        Buttons.setHomeButtonFont(ecranCaisseButton);
        Buttons.setHomeButtonFont(ecranAdministrateurButton);
    }

    public JPanel getPanel() {
        return panel1;
    }

    public JButton getEcranAdministrateurButton() {
        return ecranAdministrateurButton;
    }

    public JButton getEcranCaisseButton() {
        return ecranCaisseButton;
    }
}
