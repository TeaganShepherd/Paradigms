import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.*;


public class Assignment3{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)throws Exception{
        
        
        boolean quit = false;
        String carDescription = "";
        int fuelTankCapacity = -1;
        String engineDescription = "";
        int MPG = -1;
        int maxSpeed = -1;
        int counter = 0;

        int numberLegs = -1;
        List<Integer> legDistances = new ArrayList<Integer>();
        List<Double> xRatios = new ArrayList<Double>();
        List<Double> yRatios = new ArrayList<Double>();
        //List<Integer> xCoords = new ArrayList<Integer>();
        //List<Integer> yCoords = new ArrayList<Integer>();
        List<Car> cars = new ArrayList<Car>();
        //List<DrawPanel> panels = new ArrayList<DrawPanel>();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(600,600);
        
        while(!quit){
            carDescription = getCarDescription();
            fuelTankCapacity = getFuelTankCapacity();
            engineDescription = getEngineDescription();
            MPG = getMPG();
            maxSpeed = getMaxSpeed();
            Car newCar = new Car(carDescription, fuelTankCapacity, new Engine(engineDescription,MPG,maxSpeed) );
            cars.add(newCar );
            JOptionPane.showMessageDialog(null, cars.get(counter).getDescription());

            numberLegs = getNumberLegs();
                for(int i = 0; i < numberLegs; i++){
                    legDistances.add( getLegDistance(i +1)  );
                    xRatios.add( getXRatio(i+1) );
                    yRatios.add( getYRatio(i+1) );
                }
            
            for(int i = 0; i < cars.size(); i++){
                cars.get(i).fillUp();
            }       
            
            DrivePanel panel = new DrivePanel(numberLegs, cars.get(counter), legDistances, xRatios, yRatios);
            application.add(panel);
                
                

                

            application.setVisible(true);
            counter++;

            quit = true;


        }


        input.close();

    }


    static String getCarDescription(){
        String desc = JOptionPane.showInputDialog(null, "Enter the car's description:");
        
        return desc;
    }

    static int getFuelTankCapacity()throws Exception{
        int cap = -1;
        try {
            while(cap <=0){
                String tmp = JOptionPane.showInputDialog(null, "Enter the fuel tank capacity:");
                cap = Integer.parseInt( tmp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data inputted. Exiting");
            System.exit(0);
        }
        
        return cap;
    }

    static String getEngineDescription()throws Exception{
        String desc = JOptionPane.showInputDialog(null, "Enter the engine's description:");
        return desc;
    }

    static int getMPG(){
        int mpg = -1;
        try {
            while(mpg <=0){
                String tmp =JOptionPane.showInputDialog(null, "Enter the MPG:");
                mpg = Integer.parseInt( tmp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data inputted. Exiting");
            System.exit(0);
        }
        
        return mpg;
    }

    static int getMaxSpeed(){
        int maxSp = -1;
        try {
            while(maxSp <=0){
                String tmp = JOptionPane.showInputDialog(null, "Enter the Max Speed:");
                maxSp = Integer.parseInt(tmp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data inputted. Exiting");
            System.exit(0);
        }
       
        return maxSp;
    }

    

    static int getNumberLegs(){
        int legs = -1;
        try {
            while (legs <= 0){
                String tmp = JOptionPane.showInputDialog(null, "Enter the number of legs:");
                legs = Integer.parseInt( tmp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data inputted. Exiting");
            System.exit(0);
        }
        
        return legs;
    }

    static int getLegDistance(int num){
        int distance = -1;
        try {
            while(distance <= 0){
                String tmp = JOptionPane.showInputDialog(null, "Enter distance for leg " + num + ":");
                distance = Integer.parseInt( tmp );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data inputted. Exiting");
            System.exit(0);
        }
    
        return distance;
    }

    static double getXRatio(int num){
        double xRat = 0.0;
        try {
            String tmp = JOptionPane.showInputDialog(null, "Enter x ratio for leg " + num + ":");
            xRat = Double.parseDouble( tmp );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data inputted. Exiting");
            System.exit(0);
        }
        
        return xRat;
    }

    static double getYRatio(int num){
        double yRat =0.0;
        try {
            String tmp = JOptionPane.showInputDialog(null, "Enter y ratio for leg " + num + ":");
            yRat = Double.parseDouble( tmp );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data inputted. Exiting");
            System.exit(0);
        }
        
        return yRat;
    }

    

    
}