package animations;

import config.ImageConfig;

import javax.swing.*;
import java.awt.*;

public class Card {
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
    }


    public void showinshop_cannotbuy(Graphics g) {
        Image canbuy_card = (new ImageIcon(ImageConfig.cardImage + cardName + "1.png")).getImage();

        g.drawImage(canbuy_card, 95 + 54 * cardNumber, 8, null);


    }

    public boolean if_pressed(int mbx, int mby) {
        if (new Rectangle(95 + 54 * cardNumber, 8, 50, 70).contains(mbx, mby)) {
            return true;
        }
        return false;
    }
}
