package animations;

import config.ImageConfig;
import config.MusicConfig;
import utils.SoundAndMusic;

import javax.swing.*;
import java.awt.*;

public class DarkZombie extends Zombie {
    int x, y, health, page;
    int state;//1.move2.eat.3.die4.clear
    SoundAndMusic a = new SoundAndMusic(MusicConfig.zombieEat);

    public DarkZombie(int x, int y) {
        this.y = y;
        this.x = x;
        move();
        health = 200;
    }

    public SoundAndMusic a() {
        return a;
    }

    public boolean meetwithplant(Plants[][] plants) {
        for (int h = 0; h < 6; h++) {
            for (int l = 0; l < 9; l++) {
                if (plants[h][l] != null && new Rectangle(x + 34, y + 81, 80, 100).intersects(plants[h][l].x - 10, plants[h][l].y + 81, 70, 70)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void move() {
        state = 1;
    }

    public void move_show(Graphics g) {
        g.drawImage((new ImageIcon(ImageConfig.darkZombieFrame + page + ".png")).getImage(), x, y, null);

    }

    public void move_anime() {
        if (page == 17) page = 0;
        else {
            page++;
        }
    }

    public void move_action(Plants[][] plants) {
        x -= 1;
        if (meetwithplant(plants)) {
            eat();
        }
        if (health <= 0) {
            die();

        }
    }

    public void eat() {
        state = 2;
        page = 0;
    }

    public void eat_anime() {
        if (page == 17) {
            page = 0;
            a.playSound(MusicConfig.zombieEat);
        } else {
            page++;
        }
    }

    public void eat_show(Graphics g) {
        g.drawImage((new ImageIcon(ImageConfig.darkZombieEatFrame + page + ".png")).getImage(), x, y, null);

    }

    public void eat_action(Plants[][] plants) {
        for (int h = 0; h < 6; h++) {
            for (int l = 0; l < 9; l++) {
                if (plants[h][l] != null && new Rectangle(x + 34, y + 81, 80, 100).intersects(plants[h][l].x - 10, plants[h][l].y + 81, 70, 70)) {
                    plants[h][l].health -= 2;
                }
            }
        }
        if (!meetwithplant(plants)) {

            move();
        }
        if (health <= 0) {
            die();

        }
    }

    public void die() {
        state = 3;
        page = 0;

    }

    public void die_show(Graphics g) {

        g.drawImage((new ImageIcon(ImageConfig.darkZombieDieFrame + page + ".png")).getImage(), x, y, null);
        g.drawImage((new ImageIcon(ImageConfig.darkZombieHeadFrame + page + ".png")).getImage(), x, y, null);

    }

    public void die_anime() {
        if (page == 11) {
            clear();
        } else {
            page++;
        }
    }

    public void clear() {
        state = 4;
    }


    //===========================ice===============================
    int ice = 0, iice = 0, iiice = 0, iiiice = 0;

    public void imove() {
        state = 10;

    }

    public void imove_show(Graphics g) {
        g.drawImage((new ImageIcon(ImageConfig.darkZombieFrame + page + ".png")).getImage(), x, y, null);
    }

    public void imove_anime() {
        if (page == 17) {
            page = 0;
        } else {
            page++;
            if (ice == 0) {
                ice++;
                ice %= 2;
            } else {
                ice++;
                ice %= 2;
            }
        }
    }

    public void imove_action(Plants[][] plants) {
        if (iice == 0) {
            x -= 1;
            iice++;
            iice %= 2;
        } else {
            x -= 0.5;
            iice++;
            iice %= 2;
        }
        if (meetwithplant(plants)) {
            ieat();
        }
        if (health <= 0) {
            die();
        }
    }

    public void ieat() {
        state = 20;
        page = 0;


    }

    public void ieat_anime() {
        if (page == 17) {
            page = 0;
            a.playSound(MusicConfig.zombieEat);
        } else {
            if (iiice == 0) {

                iiice++;
                iiice %= 2;
                page++;
            } else {
                iiice++;
                iiice %= 2;
            }
        }
    }

    public void ieat_show(Graphics g) {
        g.drawImage((new ImageIcon(ImageConfig.darkZombieEatFrame + page + ".png")).getImage(), x, y, null);
    }
    public void ieat_action(Plants[][] plants) {
        for (int h = 0; h < 6; h++) {
            for (int l = 0; l < 9; l++) {
                if (plants[h][l] != null && new Rectangle(x + 34, y + 81, 80, 100).intersects(plants[h][l].x - 10, plants[h][l].y + 81, 70, 70)) {
                    if (iiiice == 0) {
                        plants[h][l].health--;
                        iiiice++;
                        iiiice %= 2;
                    } else {
                        iiiice++;
                        iiiice %= 2;
                    }
                }
            }
            if (!meetwithplant(plants)) {

                imove();
            }
            if (health <= 0) {
                die();

            }

        }
    }

    public void show(Graphics g) {
        switch (state) {
            case 1:
                move_show(g);
            case 2:
                eat_show(g);
            case 3:
                die_show(g);
            case 10:
                imove_show(g);
            case 20:
                ieat_show(g);
        }
    }

    public void action(Plants[][] a) {
        switch (state) {
            case 1:
                move_anime();
                move_action(a);
            case 2:
                eat_anime();
                eat_action(a);
            case 3:
                die_anime();
            case 10:
                imove_anime();
                imove_action(a);
            case 20:
                ieat_anime();
                ieat_action(a);
        }
    }


    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public void sethealth(int a) {
        health -= a;
    }

    public int getstate() {
        return state;
    }

    public void ice() {
        if (state == 1) state = 10;
        if (state == 2) state = 20;
    }
}