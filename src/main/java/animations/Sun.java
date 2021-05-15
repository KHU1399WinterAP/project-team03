package animations;

import utils.SoundAndMusic;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Sun {
    int x;
    int y;
    int endY;
    int timer = 0;
    public int state;//1)show2)remove



    public Sun(int x,int y) {
        state=1;
        this.y=y;
        this.x=x;
    }

    public Sun() {
        state=1;
        y=-80;
        x=80*new Random().nextInt(9);
        endY=100*new Random().nextInt(5);
    }


    public void paintComponent(Graphics g) {

        g.drawImage((new ImageIcon("Image/sun.png")).getImage(),34+x,81+y,null);
    }

    public void drop() {
        if(y<endY)
        {
            y+=3;
        }
        else
        {
            timer++;
            if(timer>70)
            {
                state=2;
            }
        }

    }

    public boolean ifclicked(int x, int y){
        if(new Rectangle(34+this.x,81+ this.y, 78, 78).contains(x, y))
        {
            SoundAndMusic a=new SoundAndMusic("music/sun.wav");
            a.playSound("music/sun.wav");
            return true;
        }
        return false;
    }
}
