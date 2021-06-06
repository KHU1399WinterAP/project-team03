package animations;

import utils.SoundAndMusic;

import java.awt.*;

public class Zombie {
    int a,b,_health,_page;
    int state;//1.move2.eat.3.die4.clear
    SoundAndMusic xxx;
    public SoundAndMusic a() {
        return xxx;
    }
    public Zombie() {

    }
    public Zombie(int x,int y) {
        this.b=y;
        this.a=x;
        move();

    }

    public boolean meetwithplant(Plants[][] plants){
        for (int h = 0; h < 6; h++)
        {
            for (int l = 0; l < 9; l++)
            {
                if(plants[h][l]!=null&&new Rectangle(a+34, b+81, 80, 100).intersects(plants[h][l].x+34, plants[h][l].y+81, 70,70))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public void move() {
    }
    public void move_show(Graphics g){
    }
    public void move_anime() {
    }
    public void move_action(Plants[][] plants) {
    }
    public void eat() {
    }
    public void eat_anime() {
    }
    public void eat_show(Graphics g) {
    }
    public void eat_action(Plants[][] plants) {
    }
    public void die() {
    }
    public void die_show(Graphics g) {
    }
    public void die_anime() {
    }
    public void clear() {
    }

    public void show(Graphics g) {
    }
    public void action(Plants[][] a) {
    }

    public int getx() {
        return a;
    }
    public int gety() {
        return b;
    }
    public void sethealth(int a) {

    }
    public int getstate() {
        return state;
    }
    public void ice() {

    }
}
