import greenfoot. *;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//super(1260, 720, 1);
public class Settings extends MyWorld {
    int iBreite;
    int iHoehe;
    int iSpieler;
    public Settings(int Breite, int Hoehe, int Spieler) {
        super(Breite, Hoehe, 1);
        iBreite = Breite;
        iHoehe = Hoehe;
        iSpieler = Spieler;
        setBackround();
        prepare();
    }
    
    public void setBackround(){
        GreenfootImage bg = new GreenfootImage("settingsscreen.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }

    public void act() {
        if (Greenfoot.isKeyDown("escape"))  {
            Greenfoot.delay(10);
            Greenfoot.setWorld(new Startscreen(iBreite, iHoehe, iSpieler));
        }
        showResolution();
    }
    
    public void showResolution(){
        showText("Spielauflösung " + iBreite + " x " + iHoehe, iBreite / 32  * 28, iHoehe / 18 * 3);
    }

    public void prepare() {
        addObject(new SettingsIcon(iBreite, iHoehe, iSpieler), iBreite / 16 * 1 , iHoehe / 9  *  1);
        addObject(new resolutionIcon(iBreite,iHoehe, iSpieler),iBreite / 32 * 28 , iHoehe / 18);
    }

}