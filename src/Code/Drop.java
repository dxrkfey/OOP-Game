package Code;

import javax.swing.*;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;


public class Drop {

    public ImageIcon[] drop = new ImageIcon[4];
    Image img;
    int x = 50;
    int y = 300;
    int w;
    int h;
    int count = 1;

    Drop() {
        for(int i=1;i<drop.length;i++){
            drop[i] = new ImageIcon(this.getClass().getResource("../image/drop"+i+".png"));
        }
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        public void run() {
            while (true) {
                x += 2;
                if (x <= -30) {
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try {
                    runner.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });


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
