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
    boolean offNegX = false;
    boolean offPosX = false;
    boolean offNegY = false;
    boolean offPosY = false;
    static boolean updateX = false;
    static boolean updateY = false;
    int negateX = 1;
    int negateY = 1;

    public CopCar(){
        
        super("Charger",5000,new Engine("v4",30,100),"cop-car.jpg");
        this.fillUp();
        xRatio = ran.nextInt(10) -5;
        yRatio= ran.nextInt(10) -5;
        updateX = false;
        updateY = false;
    }

    /*public void update(Graphics g){
        drive(20,xRatio,yRatio);
        //setX(getX() + xRatio);
        //setY(getY() + yRatio);
        super.update(g);
    }*/

    public void updateState(int w, int h){
        if(getX() <= 0){
            offNegX = true;
            offPosX = false;
            updateX= true;
        }
        /*else{
            offNegX = false;
        }*/
        if(getX() >= 940){
            offPosX = true;
            offNegX = false;
            updateX= true;
        }
        /*else{
            offPosX = false;
        }*/
        if(getY() <= 0){
            offNegY = true;
            offPosY = false;
            updateY = true;
        }
        /*else{
            offNegY = false;
        }*/
        if(getY() >= 640){
            offPosY = true;
            offNegY = false;
            updateY= true;
        }
        /*else{
            offPosY = false;
        }*/

        
        if(offNegX && updateX){
            negateX *= -1;
        }
        if(offPosX && updateX){
            negateX *=-1;
        }
        if(offNegY && updateY){
            negateY *= -1;

        }
        if(offPosY && updateY){
            negateY *= -1;
        }
        
        drive(2,xRatio * negateX,yRatio*negateY);
        /*offNegX = false;
        offPosX = false;
        offNegY = false;
        offPosY = false;*/
        updateX = false;
        updateY = false;
        

    }

    public void updateImage(Graphics g){
        super.updateImage(g);
        /*offNegX = false;
        offPosX = false;
        offNegY = false;
        offPosY = false;*/
    }
}