package Code;

import javax.swing.*;
import java.awt.*;

public class EndGame extends JPanel {
    String grade = "F";
    private ImageIcon ag = new ImageIcon(this.getClass().getResource("../image/again.png"));
    JButton again = new JButton(ag);

    EndGame(){
        this.setSize(1230,700);
        again.setBounds(100,200,70,40);
        again.setOpaque(false);
        again.setContentAreaFilled(false);
        again.setBorderPainted(false);
        add(again);
    }

    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TH Chakra Petch",Font.CENTER_BASELINE,100));
        g.drawString("YOUR GRADE IS",700,600);
        g.drawString(grade,700,500);
    }
}
