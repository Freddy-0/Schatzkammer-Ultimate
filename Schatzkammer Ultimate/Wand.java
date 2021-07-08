import greenfoot.*;

public class Wand extends Actor{
   
   public Wand(int Wandgroesse){
        getImage().scale(Wandgroesse, Wandgroesse);
   }
   public void act(){
        World w = getWorld();
        Actor a = getOneIntersectingObject(Schatz.class);   
        Actor b = getOneIntersectingObject(Wand.class); 
        if(a != null){
            w.removeObject(a);            
        }              
        if(b != null){
            w.removeObject(b);            
        }
    }
 
}
