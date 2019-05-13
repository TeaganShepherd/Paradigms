import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.PrintWriter;
// import Ball.java;
// import Bricks.java;
// import Paddle.java;

public class BrickBreaker extends JFrame{
    Ball testingBall;
    public BrickBreaker(){
        this.setTitle("Bricks");
        this.setSize(1000,1000);
        this.setVisible(true);
        testingBall = new Ball();
        
        
    }

    public void paint(Graphics g){
        g.setColor(Color.RED);
        testingBall.paint(g);
        

    }

    public static void main(String[] args) {
        new BrickBreaker();
        
    }
}