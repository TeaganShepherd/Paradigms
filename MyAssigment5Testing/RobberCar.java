import java.io.PrintWriter;
import java.lang.*;
import java.io.*;
import java.awt.Graphics;
import java.util.*;
public class RobberCar extends Car{
    public boolean isCap = false;
    Random ran = new Random();
    private int xRatio;// = ran.nextInt(10) -5;
    private int yRatio;// = ran.nextInt(10) -5;
    public static int capCount = 0;
    public static int escapeCount = 0;
    public boolean hasEscaped = false;

    public RobberCar(){
        super("Robber",5000,new Engine("v8",20,200),"red-car.jpg");
        this.fillUp();
        setX(300);
        setY(300);
        xRatio = ran.nextInt(10) -5;
        yRatio= ran.nextInt(10) -5;
    }

    /*public void update(Graphics g){
        
        
        //setX(getX() + xRatio);
        //setY(getY() + yRatio);
        
    }*/

    public void updateState(int w, int h){
        if(!hasEscaped){
            if(this.getX() <= -60 || this.getX()>= 1060 || this.getY() <= -60 || this.getY() >= 760){
                hasEscaped = true;
                escapeCount++;
                System.out.println("A robber escaped");
            }

        }

        if(!isCap){
            drive(40,xRatio,yRatio);
        }
    }

    public void updateImage(Graphics g){
        super.updateImage(g);
    }
    public void captured(){
        if(!isCap){
            super.setImage("jail.jpg");
            isCap = true;
            capCount++;
        }

    }

    public boolean isCaptured(){
        return isCap;
    }
    public boolean hasEscaped(){
        return hasEscaped;
    }
    public static int getCapCount(){
        return capCount;
    }

    public static int getEscapeCount(){
        return escapeCount;
    }
    public static void resetCaught(){
        capCount = 0;
    }
    public static void resetEscaped(){
        escapeCount = 0;
    }
}