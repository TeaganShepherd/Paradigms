import java.io.PrintWriter;
import java.lang.*;
import java.io.*;
//import Engine.java;
//import GasTank.java;
public class Car {

    /**Instance variables */
    private String description;
    private int xCoord, yCoord;
    private GasTank myTank;
    private Engine myEngine;
    double tempX = 0.0;
    double tempY =0.0;

    /** Constructors */
    public Car(){

    }
    public Car(String des, int maxFuel, Engine engine){
        //Checking description
        if(des.length() == 0){
            description = "Generic car";
        }
        else{
            description = des;
        }

        //Checking the engine 
        if (engine == null){
            myEngine = new Engine("",0,0);
        }
        else{
            myEngine = engine;
        }

        myTank = new GasTank(maxFuel);

        xCoord = 0;
        yCoord = 0;
    }

    /** Getters */

    public String getDescription(){
        return description + "(" + myEngine.getDescription() + ")," + myTank.getTank() + ",location: (" + xCoord + ","+ yCoord+ ")";
    }

	public int getX(){
        return xCoord;
    }

	public int getY(){
        return yCoord;
    }

	public double getFuelLevel(){
        return myTank.getLevel();
    }

	public int getMPG(){
       return myEngine.getMPG();
    }

    public int getMaxSpeed(){
        return myEngine.getMaxSpeed();
    }

    /** Fill up*/

    public void fillUp(){
        myTank.setLevel(myTank.getCapacity());
    }

    /** drive */

    public double drive(int distance, double xRatio, double yRatio){

        //Trying new approach via similar triangles....
        double hypotenuse = Math.abs(Math.sqrt(  Math.pow(xRatio,2) + Math.pow(yRatio,2)  ));
        double gasLeft = myTank.getLevel();
        boolean madeIt = true;
        double possibleDistance =distance;
        
        //System.out.println("xRatio:  " + xRatio + "   yRatio:  " + yRatio);
        //System.out.println("Hypotenuse:  " + hypotenuse);
        //This is the case where we have enough gas to travel as far as we want
        if(distance <= myTank.getLevel() * myEngine.getMPG()){
            //System.out.println("xCoord+=  " + (int)( (distance * xRatio) / hypotenuse)+.5);
            xCoord += (int)( (distance * xRatio) / hypotenuse);
            //System.out.println("yCoord+=  "+ (int) ((distance * yRatio) / hypotenuse)+.5);
            yCoord += (int) ((distance * yRatio) / hypotenuse);
            //System.out.println("myTank.getlvl:  " + myTank.getLevel() + "  Distance: " + distance + "   MyEngine.mpg: " + myEngine.getMPG());
            //System.out.println("100/30 "+100/(double)30);
            gasLeft = myTank.getLevel() - (((double)distance / (double)myEngine.getMPG() ))  ;
            //System.out.println("Setting gasLeft() " + gasLeft);
        }

        //The other option is we dont have enough gas so we dont make it all the way.
        else if(0 < myTank.getLevel() * myEngine.getMPG()){
            console.log("We are in the else if");
            possibleDistance = myTank.getLevel() * myEngine.getMPG();
            //System.out.println("xCoord+=  " + (int)( (possibleDistance * xRatio) / hypotenuse) );
            xCoord += (int) ((possibleDistance * xRatio) / hypotenuse );
            //System.out.println("yCoord+=  "+ (int) ((possibleDistance * yRatio) / hypotenuse));
            yCoord += (int) ((possibleDistance * yRatio) / hypotenuse );
            gasLeft = 0.0;
            madeIt = false;
        }

        else {
            possibleDistance = 0;
            gasLeft = 0.0;
            madeIt = false;
        }

        myTank.setLevel(gasLeft);
        if(!madeIt){
            System.out.println("Ran out of gas after driving " + possibleDistance +" miles.");
            return possibleDistance;
        }
        //xCoord = (int)tempX;
        //yCoord = (int)tempY;
        //System.out.println("|||||||| xCoord: " + tempX + " ||||| yCoord" + tempY);
        return distance;
        

        //My first approach was essentially repeated addition, I got somewhat close, but ended up losing 
        //accuracy
        /*
        double distanceTraveled = 0.0;
        while( distanceTraveled <= myTank.getLevel() * myEngine.getMPG() && distanceTraveled <= distance && myTank.getLevel() >0){
            //System.out.println("Distance Traveled:   " + distanceTraveled + "| Distance:   " + distance);
            double distanceAdded;
            if(!(distanceTraveled + (Math.abs(yRatio) + Math.abs(xRatio)) >= distance)){
                //System.out.println("Entered if...");
                xCoord += xRatio;
                yCoord += yRatio;
                distanceAdded = Math.sqrt(   Math.pow(yRatio,2) + Math.pow(xRatio,2)   );
                distanceTraveled += distanceAdded;
                //System.out.println("xCoord:  "   + xCoord + "  yCoord: " + yCoord + " Distance Travelled: " + distanceTraveled);
            }
            else{
                //System.out.println("Entered else...");
                distanceAdded = distance - distanceTraveled;
                double xRatLeft, yRatLeft;
                xRatLeft = xRatio/(xRatio + yRatio);
                yRatLeft = yRatio/(xRatio + yRatio);
                xCoord += xRatLeft * distanceAdded;
                yCoord += yRatLeft * distanceAdded;
                distanceTraveled = distance + .0000001;
                System.out.println("xCoord:  "   + xCoord + "  yCoord: " + yCoord + " Distance Travelled: " + distanceTraveled);
            }

            //myTank.setLevel(  myTank.getLevel()  - (distanceAdded / myEngine.getMPG()   )   );
            
        } 
        
        if(distanceTraveled < distance){
            System.out.println("Ran out of gas after driving " + distanceTraveled +" miles.");
            myTank.setLevel(0);
            return distanceTraveled;
        }

        
        else{
            double gasLeft = myTank.getLevel() - (distanceTraveled / (double)myEngine.getMPG()  );
            myTank.setLevel(gasLeft);
            return distanceTraveled;
        }

        /*if(myTank.getLevel() == 0){
            System.out.println("Ran out of gas after driving " + distanceTraveled +" miles.");
        }
        return distanceTraveled;*/
        
    }

    
}