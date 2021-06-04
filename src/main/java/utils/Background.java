package utils;

<<<<<<< HEAD
import config.ImageConfig;
=======
import Config.ImageConfig;
>>>>>>> master

import javax.swing.*;
import java.awt.*;

public class Background {
<<<<<<< HEAD
    public void runBackground(Graphics g) {
        g.drawImage((new ImageIcon(ImageConfig.backgroundImage)).getImage(), -220, 0, null);
        g.drawImage((new ImageIcon(ImageConfig.shoppingImage)).getImage(), 10, 0, null);
=======
    public void runbackground(Graphics g)
    {

        g.drawImage((new ImageIcon(ImageConfig.background)).getImage(), -220, 0, null);

        g.drawImage((new ImageIcon(ImageConfig.backgroundShopping)).getImage(), 10, 0, null);
>>>>>>> master
    }
}
