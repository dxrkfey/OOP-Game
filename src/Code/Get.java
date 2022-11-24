package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Get {
    public ImageIcon[] get = new ImageIcon[3];
    int x = 20;
    int y = 100;
    int w = 50;
    int h = 50;
    int count = 1;

    Get(){
        for(int i=1;i< get.length;i++){
            get[i] = new ImageIcon(this.getClass().getResource("../image/get"+i+".png"));
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 45, 45));
    }

}
