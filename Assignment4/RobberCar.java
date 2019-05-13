import java.io.PrintWriter;
import java.lang.*;
import java.io.*;
import java.awt.Graphics;
import java.util.*;
public class RobberCar extends Car{
    Random ran = new Random();
    private int xRatio;// = ran.nextInt(10) -5;
    private int yRatio;// = ran.nextInt(10) -5;

    public RobberCar(){
        super("Robber",20,new Engine("v8",20,200),"red-car.jpg");
        this.fillUp();
        xRatio = ran.nextInt(10) -5;
        yRatio= ran.nextInt(10) -5;
    }

    public void update(Graphics g){
        
        drive(40,xRatio,yRatio);
        //setX(getX() + xRatio);
        //setY(getY() + yRatio);
        super.update(g);
    }
}