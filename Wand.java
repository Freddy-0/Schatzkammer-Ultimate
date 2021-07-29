import greenfoot.*;

public class Wand extends Actor{
   boolean schatzcheck = false;
   public Wand(int Wandgroesse){
        getImage().scale(Wandgroesse, Wandgroesse);
   }
   public void act(){
       if(!schatzcheck){
           World w = getWorld();
           Actor a = getOneIntersectingObject(Schatz.class);
           if(a != null){
               w.removeObject(a);            
            } 
            schatzcheck = true;
        }
    }
 
}
