import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
public class resolutionIcon extends Actor
{   int iBreite = 1260;
    int iHoehe = 720;
    int factor;
    public resolutionIcon(){
        getImage().scale(iBreite / 18, iHoehe / 10);
        factor = 7;
        getScreensize();
    }
    public resolutionIcon(int factorf){
        getImage().scale(iBreite / 18, iHoehe / 10);
        factor = factorf;
        getScreensize();
    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){
            if(factor < 10){
                factor++;
            }else{
                factor = 7;
            }
            getScreensize();
            Greenfoot.setWorld(new Welcomescreen(iBreite, iHoehe, factor));
        }
    }

    public void getScreensize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Double fBreite = screenSize.getWidth() * factor / 10;
        Double fHoehe = screenSize.getHeight() * factor / 10;
        iBreite = makeUsable(fBreite.intValue(), 30);
        iHoehe = makeUsable(fHoehe.intValue(), 30);
    }
    
    public int makeUsable(int zahl, int divisor){        
        int ergebniss = zahl - (zahl % divisor);       
        return ergebniss;
    } 


    public double getfactor(){
        return factor;
    }
    
    public double giveScale(){
        return 1 * factor;
    }    
    
}
