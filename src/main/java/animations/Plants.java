package animations;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Plants {
    public int x;
    public int y;
    public int page;
    public int health;
    public int timer;
    public int type;
    public int state;

    public Plants() {
    }

    public Plants(int x, int y) {
        health = 170;
        this.x = x;
        this.y = y;
        shooter_move();
    }

    public Plants(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        if (type == 0) shooter_move();
        if (type == 1) sun_move();
        if (type == 2) nut_health();
        if (type == 3) ice_move();

    }

    public Plants(int type, int x, int y, int state) {
        this.type = type;
        this.state = state;
        this.x = x;
        this.y = y;
        if (type == 0) shooter_put();
        if (type == 1) sun_put();
        if (type == 2) nut_put();
        if (type == 3) ice_put();

    }

    public void clear() {
        state = 2;
    }

    public void shooter_timer() {
        timer++;
    }

    public boolean shooter_timer_over() {
        return timer > 17;
    }

    public void shooter_move() {
        health = 170;
        state = 1;
    }

    public void shooter_move_show(Graphics g) {
        g.drawImage((new ImageIcon("Image/peashooter/Frame" + page + ".png")).getImage(), 34 + x, 81 + y, null);
    }

    public void shooter_move_anime(ArrayList<Bullet> BulletList) {
        if (page == 12) page = 0;
        else page++;
        if (health <= 0) clear();
        shooter_timer();
        if (shooter_timer_over()) {
            Bullet newbullet = new Bullet(x, y);
            BulletList.add(newbullet);
            timer = 0;
        }

    }
    public void shooter_put() {
        state=3;
    }
    public void shopter_put_show(Graphics  g) {
        if(state==3)
        {
            Image tu = (new ImageIcon("Image/peashooter/Frame0.png")).getImage();
            g.drawImage(tu,x, y, null);
            Image tu1 = (new ImageIcon("Image/plantput/pea.png")).getImage();
            g.drawImage(tu1,34+((x-34)/80)*80, 81+((y-81)/100)*100, null);
        }
    }
    public void ice_move() {
        health=170;
        state=1;
    }
    public void ice_move_show(Graphics g) {
        g.drawImage((new ImageIcon("Image/icepeashooter/Frame"+page+".png")).getImage(),34 +x, 81+y, null);
    }
    public void ice_move_anime(ArrayList<IceBullet> IceBulletList) {
        if(page==14) page=0;
        else page++;
        if (health<=0) clear();
        shooter_timer();
        if(shooter_timer_over()) {
            IceBullet newbullet=new IceBullet(x,y);
            IceBulletList.add(newbullet);
            timer=0;
        }

    }
    public void ice_put() {
        state=3;
    }
    public void ice_put_show(Graphics  g) {
        if(state==3)
        {
            Image tu = (new ImageIcon("Image/icepeashooter/Frame0.png")).getImage();
            g.drawImage(tu,x, y, null);
            Image tu1 = (new ImageIcon("Image/plantput/ice.png")).getImage();
            g.drawImage(tu1,34+((x-34)/80)*80, 81+((y-81)/100)*100, null);
        }
    }
    public void sun_move() {
        health=170;
        state=1;
    }
    public void sun_move_show(Graphics g) {
        g.drawImage((new ImageIcon("Image/sunflower/Frame"+page+".png")).getImage(),34 +x, 81+y, null);
    }
    public void sun_move_anime(ArrayList<Sun> SunList) {
        if(page==17) page=0;
        else page++;
        if (health<=0) clear();
        sun_timer();
        if(sun_timer_over()) {
            Sun newsun=new Sun(x,y);
            SunList.add(newsun);
            timer=0;
        }

    }
    public void sun_put() {
        state=3;
    }
    public void sun_put_show(Graphics  g) {
        if(state==3)
        {
            Image tu = (new ImageIcon("Image/sunflower/Frame0.png")).getImage();
            g.drawImage(tu,x, y, null);
            Image tu1 = (new ImageIcon("Image/plantput/sun.png")).getImage();
            g.drawImage(tu1,34+((x-34)/80)*80, 81+((y-81)/100)*100, null);
        }
    }
    public void sun_timer() {
        timer++;
    }
    public boolean sun_timer_over() {
        return timer>83;
    }
    public void nut_health() {
        state=1;
        health=340;
    }
    private void nut_health_show(Graphics g)
    {

        g.drawImage((new ImageIcon("Image/nut1/Frame"+page+".png")).getImage(),34 +x, 81+y, null);
    }

    private void nut_health_move()
    {
        if(page==15)
        {
            page=0;
        }
        else
        {
            page++;
        }

        if( health<=200 )
        {
            nut_hurt();
        }
    }
    private void nut_hurt() {
        state=4;
        page=0;
    }
    private void nut_hurt_show(Graphics g)
    {

        g.drawImage((new ImageIcon("Image/nut2/Frame"+page+".png")).getImage(),34 +x, 81+y, null);
    }

    private void nut_hurt_move()
    {
        if(page==10)
        {
            page=0;
        }
        else
        {
            page++;
        }

        if( health<=100 )
        {
            nut_badhurt();
        }
    }

    private void nut_badhurt() {
        state=5;
        page=0;
    }
    private void nut_badhurt_show(Graphics g)
    {

        g.drawImage((new ImageIcon("Image/nut3/Frame"+page+".png")).getImage(),34 +x, 81+y, null);
    }

    private void nut_badhurt_move()
    {
        if(page==14)
        {
            page=0;
        }
        else
        {
            page++;
        }

        if( health<=0 )
        {
            clear();
        }
    }
    public void nut_put() {
        state=3;
    }
    public void nut_put_show(Graphics  g) {
        if(state==3)
        {
            Image tu = (new ImageIcon("Image/nut1/Frame0.png")).getImage();
            g.drawImage(tu,x, y, null);
            Image tu1 = (new ImageIcon("Image/plantput/nut.png")).getImage();
            g.drawImage(tu1,34+((x-34)/80)*80, 81+((y-81)/100)*100, null);
        }
    }

    void nut_show(Graphics g)
    {
        if(state==1)
        {
            nut_health_show(g);
        }
        if(state==4)
        {
            nut_hurt_show(g);
        }
        if(state==5)
        {
            nut_badhurt_show(g);
        }
    }

    public void nut_action()
    {
        if(state==1)
        {
            nut_health_move();
        }
        if(state==4)
        {
            nut_hurt_move();
        }
        if(state==5)
        {
            nut_badhurt_move();
        }

    }

    public void put_disappear() {
        state=2;
    }
    public void put() {
        state=3;
    }
    public void show(Graphics g)
    {
        if(type==0)
        {
            shooter_move_show(g);
        }
        if(type==1)
        {
            sun_move_show(g);
        }
        if(type==2)
        {
            nut_show(g);
        }
        if(type==3)
        {
            ice_move_show(g);
        }
    }

    public void action(ArrayList<Bullet> BulletList,ArrayList<IceBullet> IceBulletList,ArrayList<Sun> SunList)
    {
        if(type==0)
        {
            shooter_move_anime(BulletList);
        }
        if(type==1)
        {
            sun_move_anime(SunList);
        }
        if(type==2)
        {
            nut_action();
        }
        if(type==3)
        {
            ice_move_anime(IceBulletList);
        }
    }

}
