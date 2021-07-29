import greenfoot. *;
public class Welcomescreen extends MyWorld {
    private GreenfootSound music = new GreenfootSound("Musik.mp3");
    String Startbutton = "enter";
    int iBreite;
    int iHoehe;    
    
    public Welcomescreen(int Breite, int Hoehe){
        super(Breite, Hoehe,1);
        iBreite = Breite;
        iHoehe = Hoehe;
        addObjects();
        showResolution();
    }
    
    public Welcomescreen(){
        super(840,480, 1);
        iBreite = 840;
        iHoehe = 480;
        showResolution();
        addObjects();
    }
    
    public void act() {
        Starterfassung();    
        showResolution();
    }
    
    public void addObjects() {
        GreenfootImage bg = new GreenfootImage("Startbildschirm Hintergrund.jpg");
        bg.scale(iBreite, iHoehe);
        setBackground(bg);
        addObject(new Schriftzug(iBreite, iHoehe), iBreite / 2, iHoehe / 2);
        addObject(new Startaufforderung(iBreite, iHoehe), iBreite / 2, iHoehe / 8  *  7);
        addObject(new resolutionIcon(iBreite,iHoehe), iBreite / 7 * 6, iHoehe / 18);
    }

    public void showResolution(){
        showText("Spielauflösung " + iBreite + " x " + iHoehe, iBreite / 32  * 28, iHoehe / 18 * 3);
    }
    

    private void Starterfassung() {
        if (Greenfoot.mouseClicked(Startaufforderung.class))  {
            Start();
        }

        if (Greenfoot.isKeyDown("enter"))  {
            music.stop();
            Start();
        }
    }

    public double returniHoehe(){
        return iHoehe;
    }
    
    private void Start() {
        if (Greenfoot.isKeyDown(Startbutton))  {
            Greenfoot.setWorld(new Startscreen(iBreite, iHoehe));
        }
    }

}