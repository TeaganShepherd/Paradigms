import java.awt.Graphics;
import java.io.IOException;
import java.util.List;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Iterator;


class Model
{
  static int count =0;
    private static List<Sprite> sprites = new ArrayList<Sprite>();

    Model() throws IOException {
      synchronized(sprites){
        sprites.add(new Bank());
        count++;
      }

    }

    Model(String name) throws IOException {
      synchronized(sprites){
        sprites.add(new Sprite(name));
      }
    }

    Model(int x, int y) {
      //System.out.println("sprites size: " + sprites.size()); 
      synchronized(sprites){
          if(count %2 !=0){
            sprites.add(new RobberCar());
          }
          else{
            sprites.add(new CopCar());
            sprites.get(sprites.size() - 1).setX(x);
            sprites.get(sprites.size() - 1).setY(y);
          }
          //sprites.get(sprites.size() - 1).setX(x);
          //sprites.get(sprites.size() - 1).setY(y);
          count++;
      }
    }
    public  void fillUp(){
      synchronized(sprites){
        int length = sprites.size();
          for(int i = 0; i < length ; i++){
            //System.out.println("sprites size: " + sprites.size());
            //System.out.println("Updating: " + i);
            Car b = new Car();
            b = (Car)sprites.get(i);
            b.fillUp();
            //sprites.get(i).fillUp();
          }
        }
    }

    public void updateScene(int w, int h){
      synchronized(sprites){
        //int count = 1;
          int length = sprites.size();
          Iterator<Sprite> iter1 = sprites.iterator();
          iter1.next();
          while(iter1.hasNext()){
            Car tmp = new Car();
            tmp = (Car)iter1.next();
            tmp.updateState(w,h);

            if (length >= 2){
            Iterator<Sprite> iter2 = sprites.iterator();
            iter2.next(); iter2.next();
            
                while(iter2.hasNext()){
                  Car tmp2 = new Car();
                  tmp2 = (Car)iter2.next();
                  if(tmp instanceof RobberCar &&  tmp2 instanceof CopCar && tmp.overlaps(tmp2) ){
                    RobberCar a = new RobberCar();
                    a = (RobberCar)tmp;
                    a.captured();

                  }
                }
            }
            count ++;


          }
      }
      
      /*for(int i = 1; i < sprites.size() ; i++){
        Car b = new Car();
        b = (Car)sprites.get(i);
        b.updateState(w,h);
        //sprites.get(i).fillUp();
        for(int k = 2; k< sprites.size() ; k++){
            if(sprites.get(i) instanceof RobberCar && sprites.get(k)instanceof CopCar && sprites.get(i).overlaps(sprites.get(k))){
              //System.out.print(sprites.get(i) instanceof RobberCar);
              //System.out.println("Gotcha!");
              RobberCar a = new RobberCar();
              a = (RobberCar)sprites.get(i);
              a.captured();
            }
        }
      }*/
      synchronized(sprites){
          Iterator<Sprite> iter = sprites.iterator();
          while(iter.hasNext()){
            Sprite s = iter.next();
            //System.out.println("Here1");
            if(s instanceof RobberCar ){
              //System.out.println("Here2");
              RobberCar a = new RobberCar();
              a = (RobberCar)s;
              if(a.hasEscaped()){
                //System.out.println("Here3");
                System.out.println("I'm free!");
                iter.remove();
              }
            }
          }
      }
    }
    public void update(Graphics g) {
      synchronized(sprites){
        int length = sprites.size();
          for(int i = 0; i < length ; i++){
            //System.out.println("sprites size: " + sprites.size());
            //System.out.println("Updating: " + i);
            sprites.get(i).updateImage(g);
          }
      }
		
    }

    public void initialize(){
      synchronized(sprites){
          ArrayList<Sprite> tmp = new ArrayList<Sprite>();
          count = 0;
          sprites = tmp;
          sprites.add(new Bank());
          count++;
          RobberCar.resetCaught();
          RobberCar.resetEscaped();
      }
      
    }
}
