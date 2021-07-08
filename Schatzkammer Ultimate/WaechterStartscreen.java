import greenfoot.*;
public class WaechterStartscreen extends Actor
{
    public WaechterStartscreen(boolean Aktiv, int Breite, int Hoehe){
        if(Aktiv){
            setImage("Waechter Gross.png");
            getImage().scale(Breite / 12, Hoehe / 7);
        }else{
            setImage("Waechter Gross SW.png");
            getImage().scale(Breite / 12, Hoehe / 7);
        }
    }
    public void act() 
    {
       
    }    
}
