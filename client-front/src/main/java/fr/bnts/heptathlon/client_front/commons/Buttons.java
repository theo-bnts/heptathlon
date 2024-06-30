package fr.bnts.heptathlon.client_front.commons;

import javax.swing.*;
import java.awt.*;

public class Buttons {
    private static final Font HOME_BUTTON_FONT = new Font("Arial", Font.PLAIN, 18);

    public static void setHomeButtonFont(JButton button) {
        button.setFont(HOME_BUTTON_FONT);
    }
}
