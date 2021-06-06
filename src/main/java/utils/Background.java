package utils;

import config.ImageConfig;

import javax.swing.*;
import java.awt.*;

public class Background {
    public void runbackground(Graphics g)
    {

        g.drawImage((new ImageIcon(ImageConfig.background)).getImage(), -220, 0, null);

        g.drawImage((new ImageIcon(ImageConfig.backgroundShopping)).getImage(), 10, 0, null);
    }
}