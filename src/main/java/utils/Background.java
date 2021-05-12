package utils;

import config.ImageConfig;

import javax.swing.*;
import java.awt.*;

public class Background {
    public void runBackground(Graphics g) {
        g.drawImage((new ImageIcon(ImageConfig.backgroundImage)).getImage(), -220, 0, null);
        g.drawImage((new ImageIcon(ImageConfig.shoppingImage)).getImage(), 10, 0, null);
    }
}
