import greenfoot.*;
public class AbenteurerStartscreen extends Actor
{
    public AbenteurerStartscreen(boolean Aktiv, int Breite, int Hoehe){
        if(Aktiv){
            setImage("Abenteurer Gross.png");
            getImage().scale(Breite / 12, Hoehe / 7);
        }else{
            setImage("Abenteurer Gross SW.png");
            getImage().scale(Breite / 12, Hoehe / 7);
        }
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            //Startscreen.setzeSpieler(3);
        }
    }    
}
