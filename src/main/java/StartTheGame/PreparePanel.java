package StartTheGame;

import javax.swing.*;
import java.awt.*;

public class PreparePanel {
    PlantsVsZombies i;
    SoundAndMusic BGM=new SoundAndMusic("music/gaming.wav");
    public PreparePanel(PlantsVsZombies i) {
        this.i=i;
        BGM.StartPlay_BGM();
    }
    void PreparePanel(Graphics g) {
        Image tu = (new ImageIcon("Image/start2.jpg")).getImage();
        g.drawImage(tu, -200, 0, null);
    }
    public void mouseclick(int mx,int my) {
        if(new Rectangle(266,612,112,38).contains(mx, my)) {
            BGM.StopPlay_BGM();
            SoundAndMusic a=new SoundAndMusic("music/laugh.wav");
            a.playSound("music/laugh.wav");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
                e.printStackTrace();
            }

            i.pvz_pre=null;
            i.pvz_game=new GameField(i);
            i.pvz_game.newGame(10, 5);
            System.out.println("Easy");
        }

        if(new Rectangle(381,612,91,38).contains(mx, my)) {
            BGM.StopPlay_BGM();
            SoundAndMusic a=new SoundAndMusic("music/laugh.wav");
            a.playSound("music/laugh.wav");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
                e.printStackTrace();
            }
            i.pvz_pre=null;
            i.pvz_game=new GameField(i);
            i.pvz_game.newGame(20, 7);
            System.out.println("Normal");
        }

        if(new Rectangle(477,612,112,38).contains(mx, my)) {
            BGM.StopPlay_BGM();
            SoundAndMusic a=new SoundAndMusic("music/laugh.wav");
            a.playSound("music/laugh.wav");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO ×Ô¶¯Éú³ÉµÄ catch ¿é
                e.printStackTrace();
            }
            i.pvz_pre=null;
            i.pvz_game=new GameField(i);
            i.pvz_game.newGame(30, 10);
            System.out.println("Hard");
        }
        if(new Rectangle(785,0,50,50).contains(mx, my)) {
            System.exit(0);
        }
    }
}
