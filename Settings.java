import greenfoot. *;
import java.awt.*;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//super(1260, 720, 1);
public class Settings extends MyWorld {
    resolutionIcon f = new resolutionIcon();
    int Spielerzahl;
    int iBreite;
    int iHoehe;
    Double dBreite;
    Double dHoehe;
    double dfBreite;
    double dfHoehe;
    double factor = f.getfactor();
    public Settings(int rBreite, int rHoehe, int Spieler) {
        super(rBreite, rHoehe, 1);
        iBreite = rBreite;
        iHoehe = rHoehe;
        prepare();
        Spielerzahl = Spieler;
        getScreensize();
    }

    public void act() {
        
        if (Greenfoot.isKeyDown("escape"))  {
            Greenfoot.setWorld(new Startscreen(iBreite, iHoehe, Spielerzahl));
        }
        showResolution();
    }
    
    public void showResolution(){
        showText("Bildschirmauflösung " + dBreite + " x " + dHoehe, iBreite / 32 * 28, iHoehe / 18 * 2 );
        showText("Spielauflösung " + iBreite + " x " + iHoehe, iBreite / 32  * 28, iHoehe / 18 * 3);
    }

    public void prepare() {
        addObject(new SettingsP(iBreite, iHoehe), iBreite / 2 , iHoehe / 2);
        addObject(new SettingsIcon(iBreite, iHoehe), iBreite / 16 * 1 , iHoehe / 9  *  1);
        addObject(new resolutionIcon(),iBreite / 32 * 28 , iHoehe / 18);
    }
    
    public double getFactor(){
        double factorf = f.getfactor();
        return factorf;
    } 
    
    public void getScreensize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        dBreite = screenSize.getWidth();
        dHoehe = screenSize.getHeight();
        dfBreite = screenSize.getWidth() * factor;
        dfHoehe = screenSize.getHeight() * factor; 
        iBreite = dBreite.intValue();
        iHoehe = dHoehe.intValue();
    }

}