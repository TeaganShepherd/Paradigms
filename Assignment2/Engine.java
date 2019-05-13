import java.io.PrintWriter;
import java.io.*;

public class Engine{
    
    /** Instance variables */
    private String engineSize;
    private int milesPerGallon;
    private int maxSpeed;

    /** Constructors  */

    //Default
    public Engine(){
        engineSize = "Generic engine";
        milesPerGallon = 0;
        maxSpeed = 0;
    }
    //Constructor 
    public Engine(String name, int mpg, int maxSp){
        //Checking the name of the engine
        if(name.length() == 0){
            engineSize = "Generic engine";
        }
        else{
            engineSize = name;
        }

        //Cheking the inputted MPG to be > 0

        if(mpg < 0){
            milesPerGallon = 0;
        }
        else{
            milesPerGallon = mpg;
        }
        //Checking the inputted maxSpeed to be > 0

        if(maxSp < 0){
            maxSpeed = 0;
        }
        else{
            maxSpeed = maxSp;
        }


    }

    /** Getters */
    public String getDescription(){
        return engineSize + "(MPG: " +  getMPG() + ",Max speed: " + getMaxSpeed();
    }

    public int getMPG(){
        return milesPerGallon;
    }

    public int getMaxSpeed(){
        return maxSpeed;
    }



}