package Code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JFrame;

public class Playgame extends JFrame implements ActionListener{
    Home start = new Home();
    PlayState play = new PlayState();
    EndGame end = new EndGame();

    public Playgame() {
        this.setSize(1230,700);
        this.add(play);
        start.btstart.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start.btstart) {
            this.setLocationRelativeTo(null);
            this.remove(start);
            this.setSize(1230,700);
            this.add(play);
            play.requestFocusInWindow();
        }
    }





    public static void main(String args[]) {
        JFrame jf = new Playgame();
        jf.setSize(1230,700);
        jf.setTitle("My Game");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}

