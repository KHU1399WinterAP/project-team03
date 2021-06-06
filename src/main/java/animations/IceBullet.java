package animations;

import config.ImageConfig;
import config.MusicConfig;
import utils.SoundAndMusic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class IceBullet {
    int x;
    int y;
    int state;//1fly 2disappear

    public IceBullet() {
    }
    public IceBullet(int x,int y) {
        this.x=x;this.y=y;
        fly();
    }
    private void fly() {
        state=1;
    }

    private boolean a(Zombie zombie) {

        if(new Rectangle(x, y, 30, 30).intersects(zombie.getx(), zombie.gety(), 80, 100)) {
            SoundAndMusic a=new SoundAndMusic(MusicConfig.peng);
            a.playSound(MusicConfig.peng);
            return true;}
        return false;
    }

    private void flyimage(Graphics g) {
        Image tu = (new ImageIcon(ImageConfig.iceBullet)).getImage();
        g.drawImage(tu, x+58, y+80, null);
    }

    private void flyaction(ArrayList<Zombie> ZombieList) {
        x+=5;
        for(int x=0;x<ZombieList.size();x++) {
            if(a(ZombieList.get(x))) {
                ZombieList.get(x).sethealth(5);//health-=5
                ZombieList.get(x).ice();
                clear();

            }
        }
        if (x>=800) {
            clear();
        }
    }
    private void clear() {
        state=2;
    }
    public void Action(ArrayList<Zombie> ZombieList) {
        if(state==1) flyaction(ZombieList);
    }
    public void image(Graphics g){
        if(state==1) flyimage(g);
    }
}