package fr.bnts.heptathlon.client_front.screens;

import javax.swing.*;
import fr.bnts.heptathlon.client_front.common.ButtonUtils;

public class AdminHomeScreen {
    private JPanel panel1;
    private JButton consulterLesStocksButton;
    private JButton calculerChiffreDAffairesButton;
    private JButton listerArticlesButton;
    private JButton listerFacturesButton;

    public AdminHomeScreen() {
        ButtonUtils.setHomeButtonFont(consulterLesStocksButton);
        ButtonUtils.setHomeButtonFont(calculerChiffreDAffairesButton);
        ButtonUtils.setHomeButtonFont(listerArticlesButton);
        ButtonUtils.setHomeButtonFont(listerFacturesButton);

        calculerChiffreDAffairesButton.addActionListener(e -> {
            AdminGrossSalesScreen adminGrossSalesScreen = new AdminGrossSalesScreen();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
            frame.setContentPane(adminGrossSalesScreen.getPanel());
            frame.revalidate();
        });
    }

    public JPanel getPanel() {
        return panel1;
    }
}