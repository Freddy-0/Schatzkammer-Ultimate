
import greenfoot.*;

public abstract class Person extends Actor {
    int Spielergroesse = 30;
    int gesammelteSchaetze = 0;
    int Offset = Spielergroesse / 2 -2;     
    int Speed = 4;
    int Richtungsoffset = Speed + 1;
    private GreenfootSound coinSound = new GreenfootSound("Coins sound.mp3");
    
    public void move(char richtung){          
        if(richtung == 'u' && MU()){
           setLocation(getX(), getY() - Speed);
        }        
        if(richtung == 'd' && MD()){
           setLocation(getX(), getY() + Speed);
        }
        if (richtung == 'r' && MR()){
            setLocation(getX() + Speed, getY());
        }
        if(richtung == 'l' && ML()){
           setLocation(getX() - Speed, getY());
        }
    }
    public boolean MU(){
        if(getOneObjectAtOffset(0 , - Offset - Richtungsoffset, Wand.class) == null 
            && getOneObjectAtOffset(Offset - Richtungsoffset , - Offset - Richtungsoffset, Wand.class) == null 
            && getOneObjectAtOffset(-Offset + Richtungsoffset , - Offset - Richtungsoffset, Wand.class) == null){
            return true;
        }else{
            return false;
        }        
    }
    public boolean MD(){
        if(getOneObjectAtOffset(0 , Offset + Richtungsoffset, Wand.class) == null 
            && getOneObjectAtOffset(Offset - Richtungsoffset , Offset + Richtungsoffset, Wand.class) == null 
            && getOneObjectAtOffset(-Offset + Richtungsoffset , + Offset + Richtungsoffset, Wand.class) == null){
            return true;
        }else{
            return false;
        }        
    }
    public boolean MR(){
        if(getOneObjectAtOffset(Offset + Richtungsoffset, 0 , Wand.class) == null
            && getOneObjectAtOffset(Offset + Richtungsoffset, - Offset + Richtungsoffset , Wand.class) == null
            && getOneObjectAtOffset(Offset + Richtungsoffset, + Offset - Richtungsoffset , Wand.class) == null){
            return true;
        }else{
            return false;
        }        
    }
    public boolean ML(){
        if(getOneObjectAtOffset(- Offset - Richtungsoffset, 0 , Wand.class) == null
            && getOneObjectAtOffset(- Offset - Richtungsoffset, - Offset + Richtungsoffset , Wand.class) == null
            && getOneObjectAtOffset(- Offset - Richtungsoffset, + Offset - Richtungsoffset , Wand.class) == null){
            return true;
        }else{
            return false;
        }        
    }
    public void fangeAbenteurer(){
        World w = getWorld();
        Actor a = getOneIntersectingObject(Abenteurer.class);  
        if(a != null){
            w.removeObject(a);            
        }
    }
    public void sammeleSchatz(){
        World w = getWorld();
        Actor b = getOneIntersectingObject(Schatz.class);        
        if(b != null){
            w.removeObject(b);
            gesammelteSchaetze ++;
            coinSound.setVolume(15);
            coinSound.play();
        } 
        /*w.showText("Anzahl gesammelte Schätze: " + gesammelteSchaetze, 200, 17);*/
    }
}
