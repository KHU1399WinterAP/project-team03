package animations;

import javax.swing.*;
import java.awt.*;

public class Card {
    public int canbuyornot;
    public int cardnumber;
    public String cardname;
    public Card(int number,String name) {
        this.cardname=name;
        this.cardnumber=number;
        canbuyornot=0;
    }
    public void showinshop_canbuy(Graphics g) {
        Image canbuy_card=(new ImageIcon("Image/card/"+cardname+"0.png")).getImage();

        g.drawImage(canbuy_card,95+54*cardnumber,8,null);
    }


    public void showinshop_cannotbuy(Graphics g) {
        Image canbuy_card=(new ImageIcon("Image/card/"+cardname+"1.png")).getImage();

        g.drawImage(canbuy_card,95+54*cardnumber,8,null);


    }

    public boolean if_pressed(int mbx,int mby) {
        if (new Rectangle(95+54*cardnumber,8,50,70).contains(mbx,mby)) {
            return true;
        }
        return false;
    }
}
