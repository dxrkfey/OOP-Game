package Code;
import javax.swing.ImageIcon;
import java.awt.geom.Rectangle2D;

public class Student{
    public ImageIcon[] strun = new ImageIcon[6];
    //public ImageIcon strun = new ImageIcon(this.getClass().getResource("../image/"+1+".png"));
    //public ImageIcon[] stjump = new ImageIcon[3];
    public ImageIcon stjump = new ImageIcon(this.getClass().getResource("../image/jump"+2+".png"));
    public ImageIcon stslide = new ImageIcon(this.getClass().getResource("../image/slide.png"));
    public int y = 345;
    public int x = 70;
    //jump 330 200
    //run 300 110
    public int h=300;
    public int w=110;
    public int count = 1;
    public boolean down = false;
    public boolean jump = false;
    Student() {
        for(int i=1;i<strun.length;i++){
            strun[i] = new ImageIcon(this.getClass().getResource("../image/"+i+".png"));
        }
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 45, 45));
    }
}

