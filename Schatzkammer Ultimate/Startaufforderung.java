import greenfoot.*;
public class Startaufforderung extends Actor
{   
    int iBreite;
    int iHoehe;
    int iSpieler = 2;
    public Startaufforderung(int Breite, int Hoehe){
        getImage().scale(Breite / 16 * 10, Hoehe / 36 * 3 );       
        iBreite = Breite;
        iHoehe = Hoehe;
    }
    public Startaufforderung(int Breite, int Hoehe, int Spieler){
        getImage().scale(Breite / 16 * 10, Hoehe / 36 * 3 );       
        iBreite = Breite;
        iHoehe = Hoehe;
        iSpieler = Spieler;
    }
    
    public void act() 
    {
        Starten();
    }
    
    public void Starten(){
        if(Greenfoot.mouseClicked(this)){
            if(getWorld() instanceof Startscreen){
                 Greenfoot.setWorld(new Schatzkammer(iSpieler, iBreite, iHoehe));
            }else if (getWorld() instanceof Welcomescreen){
                 Greenfoot.setWorld(new Startscreen(iBreite, iHoehe, 2));
            }
        }
    }
 } 

