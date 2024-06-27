package fr.bnts.heptathlon.client_front.screens;

import javax.swing.*;
import fr.bnts.heptathlon.client_front.common.ButtonUtils;

public class HomeScreen {
    private JButton ecranCaisseButton;
    private JButton ecranAdministrateurButton;

    private JPanel panel1;

    public HomeScreen() {
        ButtonUtils.setHomeButtonFont(ecranCaisseButton);
        ButtonUtils.setHomeButtonFont(ecranAdministrateurButton);
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
