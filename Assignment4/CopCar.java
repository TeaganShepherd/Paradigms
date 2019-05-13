import java.io.PrintWriter;
import java.lang.*;
import java.io.*;
import java.awt.Graphics;
import java.util.*;
public class CopCar extends Car{
    static Random ran = new Random();
    static private int xRatio;
    //xRatio = ran.nextInt(10) -5;
    static private int yRatio; 
    //yRatio= ran.nextInt(10) -5;

    public CopCar(){
        
        super("Charger",30,new Engine("v4",30,100),"cop-car.jpg");
        this.fillUp();
        xRatio = ran.nextInt(10) -5;
        yRatio= ran.nextInt(10) -5;
    }

    public void update(Graphics g){
        drive(20,xRatio,yRatio);
        //setX(getX() + xRatio);
        //setY(getY() + yRatio);
        super.update(g);
    }
}