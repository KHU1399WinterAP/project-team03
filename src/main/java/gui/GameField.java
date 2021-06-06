package gui;

import config.MusicConfig;
import utils.Background;
import utils.SoundAndMusic;
import animations.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameField {
    PlantsVsZombies plantsVsZombies;

    public GameField(PlantsVsZombies plantsVsZombies) {
        this.plantsVsZombies = plantsVsZombies;
    }

    ArrayList<Sun> sunList;
    ArrayList<Zombie> zombieList;
    ArrayList<Bullet> bulletList;
    ArrayList<IceBullet> iceBulletList;
    ArrayList<Card> cardList;


    Background background;
    Plants[][] plants = new Plants[6][9];
    Plants peashooter;
    Plants sunflower;
    Plants nut;
    Plants ice_peashooter;
    int sunlightValue = 50;


    int zombieDieNumber;
    int zombieNumber;
    int zombiesNumber;
    int zombieRandomNumber;

    SoundAndMusic BGM;

    void newGame(int zombieNumber, int zombieRandomNumber) {
        this.zombiesNumber = zombieNumber;
        this.zombieRandomNumber = zombieRandomNumber;
        zombieDieNumber = 0;
        sunList = new ArrayList<>();
        zombieList = new ArrayList<>();
        bulletList = new ArrayList<>();
        cardList = new ArrayList<>();
        iceBulletList = new ArrayList<>();


        cardList.add(new Card(0, "sunflower"));
        cardList.add(new Card(1, "peashooter"));
        cardList.add(new Card(2, "nut"));
        cardList.add(new Card(3, "iceshooter"));

        background = new Background();

        peashooter = new Plants();
        sunflower = new Plants();
        nut = new Plants();
        ice_peashooter = new Plants();

        plants = new Plants[6][9];

        sunlightValue = 50;
        BGM = new SoundAndMusic(MusicConfig.BGM);
        BGM.StartPlay_BGM();
    }

    void mouseclick(int x, int y) {
        //==========================nut====================
        for (int a = 0; a < cardList.size(); a++) {
            if (cardList.get(a).cardName.equals("nut") && cardList.get(a).canBuyOrNot == 1) {
                int ah = (y - 81) / 100;
                int al = (x - 34) / 80;

                Plants newnut = new Plants(2, al * 80, ah * 100);
                if (plants[ah][al] == null) {
                    plants[ah][al] = newnut;
                    sunlightValue -= 50;
                    cardList.get(a).canBuyOrNot = 0;
                    nut.clear();
                }
            }
            if (cardList.get(a).cardName.equals("nut") && cardList.get(a).if_pressed(x, y) && sunlightValue >= 50) {
                cardList.get(a).canBuyOrNot++;
                cardList.get(a).canBuyOrNot %= 2;
                if (nut == null) nut = new Plants(2, x, y, 3);
                else nut.nut_put();
            }
            //===================iceshooter===========================================
            if (cardList.get(a).cardName.equals("iceshooter") && cardList.get(a).canBuyOrNot == 1) {
                int ah = (y - 81) / 100;
                int al = (x - 34) / 80;

                Plants newice = new Plants(3, al * 80, ah * 100);
                if (plants[ah][al] == null) {
                    plants[ah][al] = newice;
                    sunlightValue -= 150;
                    cardList.get(a).canBuyOrNot = 0;
                    ice_peashooter.clear();
                }
            }
            if (cardList.get(a).cardName.equals("iceshooter") && cardList.get(a).if_pressed(x, y) && sunlightValue >= 150) {
                cardList.get(a).canBuyOrNot++;
                cardList.get(a).canBuyOrNot %= 2;
                if (ice_peashooter == null) ice_peashooter = new Plants(3, x, y, 3);
                else ice_peashooter.ice_put();
            }
            //=================sunflower=======================================
            if (cardList.get(a).cardName.equals("sunflower") && cardList.get(a).canBuyOrNot == 1) {
                int ah = (y - 81) / 100;
                int al = (x - 34) / 80;

                Plants newsun = new Plants(1, al * 80, ah * 100);
                if (plants[ah][al] == null) {
                    plants[ah][al] = newsun;
                    sunlightValue -= 25;
                    cardList.get(a).canBuyOrNot = 0;
                    sunflower.clear();
                }
            }
            if (cardList.get(a).cardName.equals("sunflower") && cardList.get(a).if_pressed(x, y) && sunlightValue >= 25) {
                cardList.get(a).canBuyOrNot++;
                cardList.get(a).canBuyOrNot %= 2;
                if (sunflower == null) sunflower = new Plants(1, x, y, 3);
                else sunflower.sun_put();
            }

            //=======================peashooter=========================
            if (cardList.get(a).cardName.equals("peashooter") && cardList.get(a).canBuyOrNot == 1) {
                int ah = (y - 81) / 100;
                int al = (x - 34) / 80;

                Plants newpes = new Plants(0, al * 80, ah * 100);
                if (plants[ah][al] == null) {
                    plants[ah][al] = newpes;
                    sunlightValue -= 100;
                    cardList.get(a).canBuyOrNot = 0;
                    peashooter.clear();
                }
            }
            if (cardList.get(a).cardName.equals("peashooter") && cardList.get(a).if_pressed(x, y) && sunlightValue >= 100) {
                cardList.get(a).canBuyOrNot++;
                cardList.get(a).canBuyOrNot %= 2;
                if (peashooter == null) peashooter = new Plants(0, x, y, 3);
                else peashooter.shooter_put();
            }
        }

        //========================================sunlight======================================
        for (int g = 0; g < sunList.size(); g++) {

            if (sunList.get(g).ifclicked(x, y)) {
                sunList.remove(g);
                sunlightValue += 25;
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
        background.runBackground(g);  //Background

        if (sunlightValue >= 25) {
            cardList.get(0).showinshop_canbuy(g);
        } else {
            cardList.get(0).showinshop_cannotbuy(g);
        }

        if (sunlightValue >= 100) {
            cardList.get(1).showinshop_canbuy(g);
        } else {
            cardList.get(1).showinshop_cannotbuy(g);
        }

        if (sunlightValue >= 50) {
            cardList.get(2).showinshop_canbuy(g);
        } else {
            cardList.get(2).showinshop_cannotbuy(g);
        }

        if (sunlightValue >= 150) {
            cardList.get(3).showinshop_canbuy(g);
        } else {
            cardList.get(3).showinshop_cannotbuy(g);
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
        for (int a = 0; a < zombieList.size(); a++) {
            zombieList.get(a).show(g);
        }
        //=================bullet==============================
        for (int a = 0; a < bulletList.size(); a++) {
            bulletList.get(a).image(g);
        }
        for (int a = 0; a < iceBulletList.size(); a++) {
            iceBulletList.get(a).image(g);
        }

        //================sunlight====================================
        for (int ge = 0; ge <= sunList.size() - 1; ge = ge + 1) {
            sunList.get(ge).paintComponent(g);
        }
        g.setFont(new Font("Serif Bold", 0, 15));
        g.drawString("" + sunlightValue, 40, 80);
    }

    public void timer() throws Exception {
        if (new Random().nextInt(2400) < zombieRandomNumber && zombiesNumber > 0) {
            int x = 800;
            int y = 100 * new Random().nextInt(6);
            Zombie newzombie = new NormalZombie(x, y);
            zombieList.add(newzombie);
            zombiesNumber--;
        }
        if (new Random().nextInt(2400) < zombieRandomNumber && zombiesNumber > 0) {
            int x = 800;
            int y = 100 * new Random().nextInt(6);
            Zombie newzombie = new RedZombie(x, y);
            zombieList.add(newzombie);
            zombiesNumber--;
        }
        if (new Random().nextInt(2400) < zombieRandomNumber && zombiesNumber > 0) {
            int x = 800;
            int y = 100 * new Random().nextInt(6);
            YellowZombie newzombie = new YellowZombie(x, y);
            zombieList.add(newzombie);
            zombiesNumber--;
        }
        if (new Random().nextInt(2400) < zombieRandomNumber && zombiesNumber > 0) {
            int x = 800;
            int y = 100 * new Random().nextInt(6);
            Zombie newzombie = new DarkZombie(x, y);
            zombieList.add(newzombie);
            zombiesNumber--;
        }

        for (int x = 0; x <= bulletList.size() - 1; x++) {
            bulletList.get(x).Action(zombieList);
        }
        for (int x = 0; x <= iceBulletList.size() - 1; x++) {
            iceBulletList.get(x).Action(zombieList);
        }

        for (int h = 0; h < 6; h++) {
            for (int l = 0; l < 9; l++) {
                if (plants[h][l] != null) {

                    plants[h][l].action(bulletList, iceBulletList, sunList);
                    ;
                    if (plants[h][l].state == 2)

                        plants[h][l] = null;
                }
            }
        }

        for (int x = 0; x <= zombieList.size() - 1; x++) {
            zombieList.get(x).action(plants);
            if (zombieList.get(x).getstate() == 4) {
                zombieDieNumber++;
                zombieList.remove(x);

            }

        }

        for (int x = 0; x <= zombieList.size() - 1; x++) {

            if (zombieList.get(x).getx() < -220) {


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
        if (zombieDieNumber == zombiesNumber) {
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
            sunList.add(sl);
        }
        for (int ge = 0; ge <= sunList.size() - 1; ge = ge + 1) {
            sunList.get(ge).drop();

            if (sunList.get(ge).state == 2) {
                sunList.remove(ge);
            }
        }

    }
}


