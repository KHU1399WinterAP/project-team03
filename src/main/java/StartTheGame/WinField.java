package StartTheGame;

import javax.swing.*;
import java.awt.*;

public class WinField {
    PlantsVsZombies i;
    public WinField( PlantsVsZombies i) {
        this.i=i;
    }
    void winfield(Graphics g) {
        Image tu = (new ImageIcon("Image/Background/win.png")).getImage();
        g.drawImage(tu, 0, 0, null);
    }
    public void mouseclick(int mx,int my) {
        if(new Rectangle(0,0,1000,1000).contains(mx, my)) {
            i.pvz_win=null;
            i.pvz_pre=new PreparePanel(i);

        }

    }
}
