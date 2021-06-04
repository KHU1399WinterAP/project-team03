package animations;

<<<<<<< HEAD
import config.ImageConfig;
=======
import Config.ImageConfig;
>>>>>>> master

import javax.swing.*;
import java.awt.*;

public class Card {
<<<<<<< HEAD
    public int canBuyOrNot;
    int cardNumber;
    public String cardName;

    public Card(int number, String name) {
        this.cardName = name;
        this.cardNumber = number;
        canBuyOrNot = 0;
    }

    public void showinshop_canbuy(Graphics g) {
        Image canbuy_card = (new ImageIcon(ImageConfig.cardImage + cardName + "0.png")).getImage();

        g.drawImage(canbuy_card, 95 + 54 * cardNumber, 8, null);
=======
    public int canbuyornot;
    public int cardnumber;
    public String cardname;

    public Card(int number, String name) {
        this.cardname = name;
        this.cardnumber = number;
        canbuyornot = 0;
    }

    public void showinshop_canbuy(Graphics g) {
        Image canbuy_card = (new ImageIcon(ImageConfig.card + cardname + "0.png")).getImage();

        g.drawImage(canbuy_card, 95 + 54 * cardnumber, 8, null);
>>>>>>> master
    }


    public void showinshop_cannotbuy(Graphics g) {
<<<<<<< HEAD
        Image canbuy_card = (new ImageIcon(ImageConfig.cardImage + cardName + "1.png")).getImage();

        g.drawImage(canbuy_card, 95 + 54 * cardNumber, 8, null);
=======
        Image canbuy_card = (new ImageIcon(ImageConfig.card + cardname + "1.png")).getImage();

        g.drawImage(canbuy_card, 95 + 54 * cardnumber, 8, null);
>>>>>>> master


    }

    public boolean if_pressed(int mbx, int mby) {
<<<<<<< HEAD
        if (new Rectangle(95 + 54 * cardNumber, 8, 50, 70).contains(mbx, mby)) {
=======
        if (new Rectangle(95 + 54 * cardnumber, 8, 50, 70).contains(mbx, mby)) {
>>>>>>> master
            return true;
        }
        return false;
    }
}
