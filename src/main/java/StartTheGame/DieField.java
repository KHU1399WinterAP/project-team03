package StartTheGame;

import javax.swing.*;
import java.awt.*;

public class DieField {
    PlantsVsZombies i;
    public DieField(PlantsVsZombies i) {
        this.i=i;
    }
    void diefield(Graphics g) {
        Image tu = (new ImageIcon("Image/Background/die.png")).getImage();
        g.drawImage(tu, -220, 0, null);
    }
    public void mouseclick(int mx,int my) {
        if(new Rectangle(0,0,1000,1000).contains(mx, my)) {
            i.pvz_die=null;
            i.pvz_pre=new PreparePanel(i);

        }

    }
}
