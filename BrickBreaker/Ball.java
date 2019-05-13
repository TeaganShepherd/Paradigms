import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends BrickBreaker{
    // Attributes 
    int ySpeed;
    int xSpeed;
    int xLoc;
    int yLoc;
    int size; 

    //Constructor
    public Ball(){
        ySpeed = 1;
        xSpeed = 1;
        xLoc = 500;
        yLoc = 500;
        size = 15;
    }

    public Ball(int ySp, int xSp, int xLo, int yLo, int sz){
        ySpeed = ySp;
        xSpeed = xSp;
        xLoc = xLo;
        yLoc = yLo;
        size = sz;
    }

    //Setters 
    public void setYSpeed(int ySp){
        ySpeed = ySp;
    }

    public void setXSpeed(int xSp){
        xSpeed = xSp;
    }

    public void setYLoc(int yLo){
        yLoc = yLo;
    }

    public void setXLoc(int xLo){
        xLoc = xLo;
    }

    public void setSize(int sz){
        size = sz;
    }

    //Getters
    public int getYSpeed(){
        return ySpeed;
    }

    public int getXSpeed(){
        return xSpeed;
    }

    public int getXLoc(){
        return xLoc;
    }

    public int getYLoc(){
        return yLoc;
    }

    public int getBallSize(){
        return size; 
    }

    public void paint(Graphics g){
        
        g.fillOval(xLoc, yLoc, size/2, size/2);

    }
}