import javax.swing.JButton;
import javax.swing.JFrame;

public class Bricks extends BrickBreaker{

    //Attributes to a brick
    boolean isBroken = false;
    int location = -1;
    final int LENGTH = 60;
    final int WIDTH = 30;
    //Default Constructor
    public Bricks() {
        isBroken = true;
        location = 0;
    }
    //Constructor
    public Bricks(int loc){
        location = loc;
        isBroken = false;
    }

    //Setters
    public void setStatus(boolean status){
        isBroken = status;
    }

    public void setLocation(int loc){
        location = loc;
    }
    //Getters

    public boolean getStatus(){
        return isBroken;
    }

    public int getWidth(){
        return WIDTH;
    }
    
    public int getHeight(){
        return HEIGHT;
    }

    public int getLoc(){
        return location;
    }
}