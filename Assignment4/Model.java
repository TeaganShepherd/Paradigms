import java.awt.Graphics;
import java.io.IOException;
import java.util.List;
import java.util.*;
import java.lang.*;
import java.io.*;


class Model
{
  static int count =0;
    private static List<Sprite> sprites = new ArrayList<Sprite>();

    Model() throws IOException {
    sprites.add(new CopCar());
    count++;

    }

    Model(String name) throws IOException {
      sprites.add(new Sprite(name));
    }

    Model(int x, int y) {
      //System.out.println("sprites size: " + sprites.size()); 
      if(count %2 !=0){
        sprites.add(new RobberCar());
      }
      else{
        sprites.add(new CopCar());
      }
      sprites.get(sprites.size() - 1).setX(x);
      sprites.get(sprites.size() - 1).setY(y);
      count++;
    }
    public static void fillUp(){
      for(int i = 0; i < sprites.size() ; i++){
        //System.out.println("sprites size: " + sprites.size());
        //System.out.println("Updating: " + i);
        Car b = new Car();
        b = (Car)sprites.get(i);
        b.fillUp();
        //sprites.get(i).fillUp();
      }
    }
    public void update(Graphics g) {

      for(int i = 0; i < sprites.size() ; i++){
        //System.out.println("sprites size: " + sprites.size());
        //System.out.println("Updating: " + i);
        sprites.get(i).update(g);
      }
		
    }
}
