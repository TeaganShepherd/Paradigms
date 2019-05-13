import javax.swing.JButton;
import javax.swing.JFrame;

public class Paddle extends BrickBreaker{
    //Attributes
    int xLoc;
    int yLoc;
    final int WIDTH = 90;
    final int HEIGHT = 45;

    //Constructors
    public Paddle() {
        int xLoc = 485;
        int yLoc = 965;
    }

    public Paddle(int xLo, int yLo){
        xLoc = xLo;
        yLoc = yLo;
    }

    //Setters
    public void setXLoc(int xLo){
        xLoc = xLo;
    }

    public void setYLoc(int yLo){
        yLoc = yLo;
    }

    //Getters
    public int getXLoc(){
        return xLoc;
    }
    
    public int getYLoc(){
        return yLoc;
    }
}