package animations;

import config.ImageConfig;
import config.MusicConfig;
import utils.SoundAndMusic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bullet {
    int x;
    int y;
    int state;

    public Bullet() {
    }

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        fly();
    }

    private void fly() {
        state = 1;
    }

    private boolean meeting(Zombie zombie) {

        if (new Rectangle(x, y, 30, 30).intersects(zombie.getx(), zombie.gety(), 80, 100)) {
            SoundAndMusic a = new SoundAndMusic(MusicConfig.bulletMusic);
            a.playSound(MusicConfig.bulletMusic);
            return true;
        }

        return false;
    }

    private void flyImage(Graphics g) {
        Image tu = (new ImageIcon(ImageConfig.bulletImage)).getImage();
        g.drawImage(tu, x + 58, y + 80, null);
    }

    private void flyAction(ArrayList<Zombie> ZombieList) {
        x += 5;
        for (int x = 0; x < ZombieList.size(); x++) {
            if (meeting(ZombieList.get(x))) {
                ZombieList.get(x).sethealth(10);
                clear();
            }
        }
        if (x >= 800) {
            clear();
        }
    }

    private void clear() {
        state = 2;
    }

    public void Action(ArrayList<Zombie> ZombieList) {
        if (state == 1) flyAction(ZombieList);
    }

    public void image(Graphics g) {
        if (state == 1) flyImage(g);
    }
}
