package gui;

import Config.MusicConfig;
import animations.*;
import utils.Background;
import utils.SoundAndMusic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import animations.Card;

public class GameField {
    PlantsVsZombies plantsVsZombies;

    public GameField(PlantsVsZombies plantsVsZombies) {
        this.plantsVsZombies = plantsVsZombies;
    }

    ArrayList<Sun> SunList;
    ArrayList<Zombie> ZombieList;
    ArrayList<Bullet> BulletList;
    ArrayList<IceBullet> IceBulletList;
    ArrayList<Card> CardList;


    Background background;
    Plants[][] plants = new Plants[6][9];
    Plants peashooter;
    Plants sunflower;
    Plants nut;
    Plants ice_peashooter;
    int sunlight_value = 50;


    int zombie_die_number;
    int Zombie_Number;
    int zombies_number;
    int zombie_random_number;

    SoundAndMusic BGM;

    void newGame(int zombie_number, int zombie_random_number) {
        this.zombies_number = zombie_number;
        this.zombie_random_number = zombie_random_number;
        Zombie_Number = zombie_number;
        zombie_die_number = 0;
        SunList = new ArrayList<Sun>();
        ZombieList = new ArrayList<Zombie>();
        BulletList = new ArrayList<Bullet>();
        CardList = new ArrayList<Card>();
        IceBulletList = new ArrayList<IceBullet>();


        CardList.add(new Card(0, "sunflower"));
        CardList.add(new Card(1, "peashooter"));
        CardList.add(new Card(2, "nut"));
        CardList.add(new Card(3, "iceshooter"));

        background = new Background();

        peashooter = new Plants();
        sunflower = new Plants();
        nut = new Plants();
        ice_peashooter = new Plants();

        plants = new Plants[6][9];

        sunlight_value = 50;
        BGM = new SoundAndMusic(MusicConfig.bgm);
        BGM.StartPlay_BGM();
    }

    void mouseclick(int x, int y) {
        //==========================nut====================
        for (int a = 0; a < CardList.size(); a++) {
            if (CardList.get(a).cardname.equals("nut") && CardList.get(a).canbuyornot == 1) {
                int ah = (y - 81) / 100;
                int al = (x - 34) / 80;

                Plants newnut = new Plants(2, al * 80, ah * 100);
                if (plants[ah][al] == null) {
                    plants[ah][al] = newnut;
                    sunlight_value -= 50;
                    CardList.get(a).canbuyornot = 0;
                    nut.clear();
                }
            }
            if (CardList.get(a).cardname.equals("nut") && CardList.get(a).if_pressed(x, y) && sunlight_value >= 50) {
                CardList.get(a).canbuyornot++;
                CardList.get(a).canbuyornot %= 2;
                if (nut == null) nut = new Plants(2, x, y, 3);
                else nut.nut_put();
            }
            //===================iceshooter===========================================
            if (CardList.get(a).cardname.equals("iceshooter") && CardList.get(a).canbuyornot == 1) {
                int ah = (y - 81) / 100;
                int al = (x - 34) / 80;

                Plants newice = new Plants(3, al * 80, ah * 100);
                if (plants[ah][al] == null) {
                    plants[ah][al] = newice;
                    sunlight_value -= 150;
                    CardList.get(a).canbuyornot = 0;
                    ice_peashooter.clear();
                }
            }
            if (CardList.get(a).cardname.equals("iceshooter") && CardList.get(a).if_pressed(x, y) && sunlight_value >= 150) {
                CardList.get(a).canbuyornot++;
                CardList.get(a).canbuyornot %= 2;
                if (ice_peashooter == null) ice_peashooter = new Plants(3, x, y, 3);
                else ice_peashooter.ice_put();
            }
            //=================sunflower=======================================
            if (CardList.get(a).cardname.equals("sunflower") && CardList.get(a).canbuyornot == 1) {
                int ah = (y - 81) / 100;
                int al = (x - 34) / 80;

                Plants newsun = new Plants(1, al * 80, ah * 100);
                if (plants[ah][al] == null) {
                    plants[ah][al] = newsun;
                    sunlight_value -= 25;
                    CardList.get(a).canbuyornot = 0;
                    sunflower.clear();
                }
            }
            if (CardList.get(a).cardname.equals("sunflower") && CardList.get(a).if_pressed(x, y) && sunlight_value >= 25) {
                CardList.get(a).canbuyornot++;
                CardList.get(a).canbuyornot %= 2;
                if (sunflower == null) sunflower = new Plants(1, x, y, 3);
                else sunflower.sun_put();
            }

            //=======================peashooter=========================
            if (CardList.get(a).cardname.equals("peashooter") && CardList.get(a).canbuyornot == 1) {
                int ah = (y - 81) / 100;
                int al = (x - 34) / 80;

                Plants newpes = new Plants(0, al * 80, ah * 100);
                if (plants[ah][al] == null) {
                    plants[ah][al] = newpes;
                    sunlight_value -= 100;
                    CardList.get(a).canbuyornot = 0;
                    peashooter.clear();
                }
            }
            if (CardList.get(a).cardname.equals("peashooter") && CardList.get(a).if_pressed(x, y) && sunlight_value >= 100) {
                CardList.get(a).canbuyornot++;
                CardList.get(a).canbuyornot %= 2;
                if (peashooter == null) peashooter = new Plants(0, x, y, 3);
                else peashooter.shooter_put();
            }
        }

        //========================================sunlight======================================
        for (int g = 0; g < SunList.size(); g++) {

            if (SunList.get(g).ifclicked(x, y)) {
                SunList.remove(g);
                sunlight_value += 25;
            }
        }
        if (new Rectangle(785, 0, 50, 50).contains(x, y)) {
            System.exit(0);
        }


        if (new Rectangle(710, 0, 50, 50).contains(x, y)) {
            plantsVsZombies.runstate = 1;

        }

        if (new Rectangle(625, 0, 50, 50).contains(x, y)) {
            plantsVsZombies.runstate = 0;

        }
    }

    public void mouse_move(int mx, int my) {
        if (peashooter != null && peashooter.state == 3) {
            peashooter.x = mx;
            peashooter.y = my;
        }
        if (ice_peashooter != null && ice_peashooter.state == 3) {
            ice_peashooter.x = mx;
            ice_peashooter.y = my;
        }
        if (nut != null && nut.state == 3) {
            nut.x = mx;
            nut.y = my;
        }
        if (sunflower != null && sunflower.state == 3) {
            sunflower.x = mx;
            sunflower.y = my;
        }
    }

    public void gamepanel(Graphics g) {
        background.runbackground(g);  //Background

        if (sunlight_value >= 25) {
            CardList.get(0).showinshop_canbuy(g);
        } else {
            CardList.get(0).showinshop_cannotbuy(g);
        }

        if (sunlight_value >= 100) {
            CardList.get(1).showinshop_canbuy(g);
        } else {
            CardList.get(1).showinshop_cannotbuy(g);
        }

        if (sunlight_value >= 50) {
            CardList.get(2).showinshop_canbuy(g);
        } else {
            CardList.get(2).showinshop_cannotbuy(g);
        }

        if (sunlight_value >= 150) {
            CardList.get(3).showinshop_canbuy(g);
        } else {
            CardList.get(3).showinshop_cannotbuy(g);
        }

        for (int h = 0; h < 6; h++) {
            for (int l = 0; l < 9; l++) {
                if (plants[h][l] != null) {
                    plants[h][l].show(g);
                }
            }
        }

        if (peashooter != null) peashooter.shopter_put_show(g);
        ;
        if (sunflower != null) sunflower.sun_put_show(g);
        if (nut != null) nut.nut_put_show(g);
        if (ice_peashooter != null) ice_peashooter.ice_put_show(g);
        //=================zombie==============================
        for (int a = 0; a < ZombieList.size(); a++) {
            ZombieList.get(a).show(g);
        }
        //=================bullet==============================
        for (int a = 0; a < BulletList.size(); a++) {
            BulletList.get(a).image(g);
        }
        for (int a = 0; a < IceBulletList.size(); a++) {
            IceBulletList.get(a).image(g);
        }

        //================sunlight====================================
        for (int ge = 0; ge <= SunList.size() - 1; ge = ge + 1) {
            SunList.get(ge).paintComponent(g);
        }
        g.setFont(new Font("Serif Bold", 0, 15));
        g.drawString("" + sunlight_value, 40, 80);
    }

    public void timer() throws Exception {
        if (new Random().nextInt(2400) < zombie_random_number && zombies_number > 0) {
            int x = 800;
            int y = 100 * new Random().nextInt(6);
            Zombie newzombie = new NormalZombie(x, y);
            ZombieList.add(newzombie);
            zombies_number--;
        }
        if (new Random().nextInt(2400) < zombie_random_number && zombies_number > 0) {
            int x = 800;
            int y = 100 * new Random().nextInt(6);
            Zombie newzombie = new RedZombie(x, y);
            ZombieList.add(newzombie);
            zombies_number--;
        }
        if (new Random().nextInt(2400) < zombie_random_number && zombies_number > 0) {
            int x = 800;
            int y = 100 * new Random().nextInt(6);
            YellowZombie newzombie = new YellowZombie(x, y);
            ZombieList.add(newzombie);
            zombies_number--;
        }
        if (new Random().nextInt(2400) < zombie_random_number && zombies_number > 0) {
            int x = 800;
            int y = 100 * new Random().nextInt(6);
            Zombie newzombie = new DarkZombie(x, y);
            ZombieList.add(newzombie);
            zombies_number--;
        }

        for (int x = 0; x <= BulletList.size() - 1; x++) {
            BulletList.get(x).Action(ZombieList);
        }
        for (int x = 0; x <= IceBulletList.size() - 1; x++) {
            IceBulletList.get(x).Action(ZombieList);
        }

        for (int h = 0; h < 6; h++) {
            for (int l = 0; l < 9; l++) {
                if (plants[h][l] != null) {

                    plants[h][l].action(BulletList, IceBulletList, SunList);
                    ;
                    if (plants[h][l].state == 2)

                        plants[h][l] = null;
                }
            }
        }

        for (int x = 0; x <= ZombieList.size() - 1; x++) {
            ZombieList.get(x).action(plants);
            if (ZombieList.get(x).getstate() == 4) {
                zombie_die_number++;
                ZombieList.remove(x);

            }

        }

        for (int x = 0; x <= ZombieList.size() - 1; x++) {

            if (ZombieList.get(x).getx() < -220) {


                BGM.StopPlay_BGM();
                Thread.sleep(200);

                SoundAndMusic a = new SoundAndMusic(MusicConfig.laugh);
                a.playSound(MusicConfig.laugh);

                plantsVsZombies.pvz_game = null;
                plantsVsZombies.pvz_die = new DieField();
                plantsVsZombies.panel.setVisible(false);
                plantsVsZombies.pvz_die.setVisible(true);

            }
        }
        if (zombie_die_number == Zombie_Number) {
            BGM.StopPlay_BGM();

            SoundAndMusic a = new SoundAndMusic(MusicConfig.win);
            a.playSound(MusicConfig.win);
            Thread.sleep(1000);

            plantsVsZombies.pvz_game = null;
            plantsVsZombies.pvz_win = new WinField();
            plantsVsZombies.panel.setVisible(false);
            plantsVsZombies.pvz_win.setVisible(true);
        }

        if (new Random().nextInt(600) < 7) {
            Sun sl = new Sun();
            SunList.add(sl);
        }
        for (int ge = 0; ge <= SunList.size() - 1; ge = ge + 1) {
            SunList.get(ge).drop();

            if (SunList.get(ge).state == 2) {
                SunList.remove(ge);
            }
        }

    }
}


