import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class resolutionIcon extends Actor
{   int iBreite;
    int iHoehe;
    int iSpieler;
    public resolutionIcon(int Breite, int Hoehe){
        iBreite = Breite;
        iHoehe = Hoehe;
        getImage().scale(iBreite / 18, iHoehe / 10);
    }
    
    public resolutionIcon(int Breite, int Hoehe, int Spieler){
        iBreite = Breite;
        iHoehe = Hoehe;
        iSpieler = Spieler;
        getImage().scale(iBreite / 18, iHoehe / 10);
    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){
            choseScreenSize();
            if(getWorld() instanceof Welcomescreen){
                 Greenfoot.setWorld(new Welcomescreen(iBreite, iHoehe));
            }else if (getWorld() instanceof Settings){
                 Greenfoot.setWorld(new Settings(iBreite, iHoehe, iSpieler));
            }
        }
    }
    
    
    public void choseScreenSize(){
        if(iBreite == 2550){
            iBreite = 840;
            iHoehe = 480;
        }else if(iBreite == 840){
            iBreite = 1260;
            iHoehe = 720;
        }else if(iBreite == 1260){
            iBreite = 1920;
            iHoehe = 1080;
        }else if(iBreite == 1920){
            iBreite = 2550;
            iHoehe = 1440;
        }
    }
    
    public int makeUsable(int zahl, int divisor){        
        int ergebniss = zahl - (zahl % divisor);       
        return ergebniss;
    }  

}
