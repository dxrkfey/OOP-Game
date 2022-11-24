package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class PlayState extends JPanel{
    int dst;
    int d = 30000;
    int d2 = 0;
    boolean hitDrop = false;
    boolean hitGet = false;
    public ImageIcon bg1 = new ImageIcon(this.getClass().getResource("../image/bg.jpg"));
    public ImageIcon bg2 = new ImageIcon(this.getClass().getResource("../image/blackbg.jpg"));
    public ArrayList<Get> Have = new ArrayList<Get>();
    public ArrayList<Drop> Dont = new  ArrayList<Drop>();
    Student me = new Student();
    Drop drop = new Drop();
    Get get = new Get();
    PlayState(){
        this.setFocusable(true);
        this.setLayout(null);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int a = e.getKeyCode();
                if (e.getKeyCode() == KeyEvent.VK_SPACE|e.getKeyCode() == KeyEvent.VK_W|e.getKeyCode() == KeyEvent.VK_UP) {
                    if(me.y>195){
                        me.y -= 150;
                        me.jump=true;
                        jump.start();
                    }
                    me.down = false;
                    System.out.println(me.y);
                } /*else if (e.getKeyCode()==KeyEvent.VK_D|e.getKeyCode()==KeyEvent.VK_RIGHT) {
                    me.x +=50;
                    me.count++;
                    repaint();
                }*/else if (e.getKeyCode()==KeyEvent.VK_S|e.getKeyCode()==KeyEvent.VK_DOWN) {
                    if(me.y!=345){
                        me.y += 150;
                    }else{
                        me.down = true;
                        Slide.start();
                    }
                }
            }
        });
        time.start();
        repaint();
        runner.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(drop.drop[2].getImage(), get.x,get.y,get.w,get.h,this);
        if(d2==0){
            g.drawImage(bg1.getImage(), 0, 0, 1230, 700, this);
            g.setColor(Color.BLACK);
            g.setFont(new Font("TH Chakra Petch",Font.CENTER_BASELINE,50));
            g.drawString("Time " + d, 400, 100);
        }else{
            g.drawImage(bg2.getImage(), 0, 0, 1230, 700, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("TH Chakra Petch",Font.CENTER_BASELINE,50));
            g.drawString("Time " + d2, 380, 100);
        }
        g.drawImage(get.get[1].getImage(), get.x,get.y,get.w,get.h,this);
        g.drawImage(drop.drop[2].getImage(), get.x,get.y,get.w,get.h,this);

        if(d>0){

        }

        if(me.down==true){
            g.drawImage(me.stslide.getImage(), me.x, 565,280, 100, this);
        }if (me.jump==true) {
            g.drawImage(me.stjump.getImage(), me.x, me.y,300, 80, this);
        } else if(me.count==1){
            g.drawImage(me.strun[me.count].getImage(), me.x, me.y, me.w, me.h, this);
        }else if(me.count<me.strun.length&&me.count>1){
            if(me.count==2){
                me.w = 150;
                g.drawImage(me.strun[me.count].getImage(), me.x, me.y, me.w, me.h, this);
                me.w=110;
            } if (me.count==3|me.count==5) {
                me.w = 150;
                g.drawImage(me.strun[me.count].getImage(), me.x, me.y, me.w, me.h, this);
                me.w=110;
            } if (me.count==4) {
                me.w = 160;
                g.drawImage(me.strun[me.count].getImage(), me.x, me.y, me.w, me.h, this);
                me.w=110;
            }
            me.count++;
        }else {
            me.count=1;
            g.drawImage(me.strun[me.count].getImage(), me.x, me.y, me.w, me.h, this);
        }

    }
    Thread time = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    if(d!=0){
                        d-=1000;
                    }else {
                        if(d2==0){
                            d2=30000;
                        }else{
                            d2-=1000;
                        }
                    }
                    System.out.println(d);
                    time.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    Thread runner = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    me.count++;
                    runner.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    Thread Slide = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    if(me.down==true){
                        me.down=false;
                    }
                    me.x = 330;
                    me.y = 110;
                    Slide.sleep(800);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    Thread jump = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    if(me.jump==true){
                        me.down=false;
                    }
                    jump.sleep(800);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    Thread UpGrade = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    get.x-=5;
                    if(get.x<-50){
                        get.x=950;
                        get.y=430;
                    }
                    UpGrade.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });
    Thread DownGrade = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    drop.count++;
                    repaint();
                    Thread.sleep(50);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}
