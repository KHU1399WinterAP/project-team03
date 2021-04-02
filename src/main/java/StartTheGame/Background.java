package StartTheGame;

import javax.swing.*;
import java.awt.*;

public class Background {
    public void runbackground(Graphics g)
    {

        g.drawImage((new ImageIcon("Image/Background/background.png")).getImage(), -220, 0, null);

        g.drawImage((new ImageIcon("Image/Background/shopping.png")).getImage(), 10, 0, null);
    }
}
