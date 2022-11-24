package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

class Home extends JPanel{
    public ImageIcon bg = new ImageIcon(this.getClass().getResource("../image/Home.jpg"));
    public ImageIcon Start = new ImageIcon(this.getClass().getResource("../image/start.png"));
    public JButton btstart = new JButton(Start);
    Home(){
        this.setSize(1230,700);
        btstart.setBounds(100,200,70,40);
        btstart.setOpaque(false);
        btstart.setContentAreaFilled(false);
        btstart.setBorderPainted(false);
        add(btstart);
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(bg.getImage(),0,0,1230,700,this);
    }
}
