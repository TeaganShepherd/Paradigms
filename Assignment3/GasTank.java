import java.io.PrintWriter;

public class GasTank{
    
    /** Instance variables */
    private int maxCapacity;
    private double currentLevel;



    /** Constructors */

    //Default 
    public GasTank(){
        maxCapacity = 0;
        currentLevel = 0;
    }
    //Constructor that sets max capacity by taking an int
    public GasTank(int maxCap){
        if(maxCap > 0){
            maxCapacity = maxCap;
        }
        else{
            maxCapacity = 0;
        }
        currentLevel = 0;
        
    }

    /** Getters */

    public int getCapacity(){
        return maxCapacity;
    }

    public double getLevel(){
        return currentLevel;
    }

    public String getTank(){
        return "fuel: " + getLevel() + "/"+ getCapacity();
    }

    /** Setters */
    public void setLevel(double lvlIn){
        double levelIn = Math.round(lvlIn*100)/100d;
        if(levelIn >= 0 && levelIn <= maxCapacity){
            currentLevel = levelIn;
        }
        else if (maxCapacity <= levelIn){
            currentLevel = maxCapacity;
        }
        else{
            //Do nothing
        }
    
    }    

}