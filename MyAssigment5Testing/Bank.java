import java.io.PrintWriter;
import java.lang.*;
import java.io.*;
import java.awt.Graphics;

public class Bank  extends Sprite{

    public Bank(){
        super("bank.png");
        System.out.println("HERE");
        setX(300);
        setY(300);
    }

    public void updateImage(Graphics g){
        super.updateImage(g);
    }

}