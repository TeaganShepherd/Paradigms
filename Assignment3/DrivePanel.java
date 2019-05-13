import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.*;
import java.util.List;
public class DrivePanel extends JPanel{

    int oldX = 0;
    int oldY = 600;
    int xCoord = -1;
    int yCoord = -1;
    int numberLegs = -1;
    Car car = new Car();
    List<Integer> legDistances = new ArrayList<Integer>();
    List<Double> xRatios = new ArrayList<Double>();
    List<Double> yRatios = new ArrayList<Double>();
    static List<Integer> xCoords = new ArrayList<Integer>();
    static List<Integer> yCoords = new ArrayList<Integer>();
    boolean thru = false;
    public DrivePanel(int numLegs, Car coche, List<Integer> legDist, List<Double> xRat,List<Double> yRat){
        numberLegs = numLegs;
        car = coche;
        legDistances = legDist;
        xRatios = xRat;
        yRatios = yRat;
        
    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);       
            if(!thru){
                xCoords.add(0);
                yCoords.add(0);
                for(int i = 0; i < numberLegs; i++){
                    car.drive(legDistances.get(i), xRatios.get(i), yRatios.get(i));
                    xCoords.add(car.getX());
                    yCoords.add(car.getY()); 
                }
                thru = true;
            }

            for (int i = 0; i < xCoords.size() -1; i++){
                g.drawLine( xCoords.get(i), this.getHeight() + (yCoords.get(i) * -1), xCoords.get(i+1), this.getHeight() +  (yCoords.get(i+1)* -1)  );
                g.drawString("(" + xCoords.get(i+1) + "," + yCoords.get(i+1) + ")",xCoords.get(i+1)+ 10, this.getHeight() + (yCoords.get(i+1)* -1 ));
            }

        
        
       
        

    }
    

}