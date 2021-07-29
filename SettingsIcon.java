import greenfoot.*;
public class SettingsIcon extends Actor
{   
    int iBreite;
    int iHoehe;
    int iSpieler;
    public SettingsIcon(int Breite, int Hoehe, int Spieler){
        getImage().scale(Breite / 32 * 2, Hoehe / 18 * 2);
        iBreite = Breite;
        iHoehe = Hoehe;
        iSpieler = Spieler;
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            if(getWorld() instanceof Startscreen){
                Greenfoot.setWorld(new Settings(iBreite,iHoehe,iSpieler));
            }else if (getWorld() instanceof Settings){
                Greenfoot.setWorld(new Startscreen(iBreite,iHoehe,iSpieler));
            }
        }
    }    
}
