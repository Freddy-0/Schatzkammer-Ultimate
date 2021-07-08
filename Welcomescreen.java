import greenfoot. *;
import java.awt. *;
public class Welcomescreen extends MyWorld {
    private GreenfootSound music = new GreenfootSound("Musik.mp3");
    String Startbutton = "enter";
    int aiBreite = 1260; 
    int aiHoehe = 720;
    int iBreite;
    int iHoehe;
    Double dBreite;
    Double dHoehe;
    Double dfHoehe;
    Double dfBreite;
    int factor;
    resolutionIcon f = new resolutionIcon();
    
    public Welcomescreen(int Breitef, int Hoehef, int factorf){
        super(Breitef, Hoehef,1);
        iBreite = Breitef;
        iHoehe = Hoehef;
        factor = factorf;
        getScreensize();
        addObjects();
        showResolution();
    }
    
    public Welcomescreen() {
        super(1260, 720, 1);
        factor = 7;
        iBreite = 720;
        iHoehe = 1260;
        showResolution();
        addObjectsn();
    }
    

    public void act() {
        Starterfassung();    
        showResolution();
    }

    public void addObjectsn() {
        GreenfootImage bg = new GreenfootImage("Startbildschirm Hintergrund.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        addObject(new Schriftzug(aiBreite, aiHoehe), aiBreite / 2, aiHoehe / 2);
        addObject(new Startaufforderung(aiBreite, aiHoehe), aiBreite / 2, aiHoehe / 8  *  7);
        addObject(new resolutionIcon(7), aiBreite / 7 * 6, aiHoehe / 18);
    }
    
    public void addObjects() {
        GreenfootImage bg = new GreenfootImage("Startbildschirm Hintergrund.jpg");
        bg.scale(aiBreite, aiHoehe);
        setBackground(bg);
        addObject(new Schriftzug(aiBreite, aiHoehe), aiBreite / 2, aiHoehe / 2);
        addObject(new Startaufforderung(aiBreite, aiHoehe), aiBreite / 2, aiHoehe / 8  *  7);
        addObject(new resolutionIcon(factor), aiBreite / 7 * 6, aiHoehe / 18);
    }
    
    public void getScreensize() {        
        double factor = f.giveScale();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        dBreite = screenSize.getWidth();
        dHoehe = screenSize.getHeight();
        dfBreite = screenSize.getWidth() * factor / 10;
        dfHoehe = screenSize.getHeight()* factor / 10;
        aiHoehe = getHeight();
        aiBreite = getWidth();
    }

    public int makeUsable(int zahl, int divisor){        
        int ergebniss = zahl - (zahl % divisor);       
        return ergebniss;
    } 

    public void showResolution(){  
        getScreensize();
        showText("Bildschirmauflösung " + dBreite.intValue() + " x " + dHoehe.intValue(), aiBreite / 32 * 28, aiHoehe / 18 * 2 );
        showText("Spielauflösung " + iBreite + " x " + iHoehe, aiBreite / 32  * 28, aiHoehe / 18 * 3);
        if(factor == 10){
            showText("Skalierungsfaktor:  " + factor / 10 + ".0", aiBreite / 32  * 28, aiHoehe / 18 * 4);
        }else{
            showText("Skalierungsfaktor:  " + "0." + factor , aiBreite / 32  * 28, aiHoehe / 18 * 4);
        }
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
            getScreensize();
            Greenfoot.setWorld(new Startscreen(iBreite, iHoehe, 2));
        }

    }

}