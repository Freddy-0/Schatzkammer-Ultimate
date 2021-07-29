import greenfoot.  *;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Startscreen extends MyWorld {
    String Startbutton = "enter";
    String Settingsbutton = "escape";
    int iBreite;
    int iHoehe;
    boolean infinite = false;
    boolean spielerAngezeigt = false;
    int factor;
    int iSpieler;
    public Startscreen(int Breite, int Hoehe) {
        super(Breite, Hoehe, 1);
        iBreite = Breite;
        iHoehe = Hoehe;
        iSpieler = 2;
        prepare();
    }
    
    public Startscreen(int Breite, int Hoehe, int spielerzahl) {
        super(Breite, Hoehe, 1);
        iBreite = Breite;
        iHoehe = Hoehe;
        iSpieler = spielerzahl;
        prepare();
    }
    
    private void prepare() {
        setVariables();
        addObjects();
        spielerzahlAnzeigen();
    }
    private void addObjects(){
        addObject(new HintergrundP(iBreite, iHoehe), iBreite / 2, iHoehe / 2);
        addObject(new Schriftzug(iBreite, iHoehe), iBreite / 2, iHoehe / 2);
        addObject(new Startaufforderung(iBreite, iHoehe), iBreite / 2, iHoehe / 8   *   7);
        addObject(new SettingsIcon(iBreite, iHoehe, iSpieler), iBreite / 16 * 1 , iHoehe / 9   *   1);
    }    
    private void setVariables(){
        int Figurenhoehe = iHoehe   /   8   *   6;
        int FigurenBreite = iBreite   /   30;
    }

    public void act() {
        Starterfassung();
        Optionen();
    }
    
    private void Starterfassung() {
        if (Greenfoot.mouseClicked(Startaufforderung.class))  {
            Start();
        }
        if (Greenfoot.isKeyDown("enter"))  {
            Start();
        }
    }
    public void Optionen() {
        Settings();
        spielerzahl();
    }
    private void Settings() {
        if (Greenfoot.isKeyDown("escape"))  {
            Greenfoot.delay(10);
            Greenfoot.setWorld(new Settings(iBreite, iHoehe, iSpieler));
        }
    }
    private int spielerzahl() {
        if (Greenfoot.isKeyDown("1") && iSpieler != 1 )  {
            iSpieler = 1;
            spielerzahlAnzeigen();
        } else if (Greenfoot.isKeyDown("2") && iSpieler != 2 )  {
            iSpieler = 2;
            spielerzahlAnzeigen();
        } else if (Greenfoot.isKeyDown("3") && iSpieler != 3 )  {
            iSpieler = 3;
            spielerzahlAnzeigen();
        } else if (Greenfoot.isKeyDown("4") && iSpieler != 4 )  {
            iSpieler = 4;
            spielerzahlAnzeigen();
        }
        return iSpieler;
    }
    
    public int setzeSpieler(){
        if(iSpieler > 5 || iSpieler < 0){
            iSpieler = 2;
        }
        spielerzahlAnzeigen();
        return iSpieler;
    }

    private void spielerzahlAnzeigen() {
        if (iSpieler == 1)  {
            Spieler1(true);
            Spieler2(false);
            Spieler3(false);
            Spieler4(false);
        } else if (iSpieler == 2)  {
            Spieler1(true);
            Spieler2(true);
            Spieler3(false);
            Spieler4(false);
        } else if (iSpieler == 3)  {
            Spieler1(true);
            Spieler2(true);
            Spieler3(true);
            Spieler4(false);
        } else if (iSpieler == 4)  {
            Spieler1(true);
            Spieler2(true);
            Spieler3(true);
            Spieler4(true);
        }

    }

    public void Spieler1(boolean Aktiv) {
        if (Aktiv)  {
            addObject(new AbenteurerStartscreen(true , iBreite , iHoehe), iBreite / 32 * 8 , iHoehe / 18   *   13 );
        } else {
            addObject(new AbenteurerStartscreen(false, iBreite , iHoehe), iBreite / 32 * 8 , iHoehe / 18   *   13 );
        }

    }

    public void Spieler2(boolean Aktiv) {
        if (Aktiv)  {
            addObject(new WaechterStartscreen(true, iBreite , iHoehe), iBreite / 32 * 13 , iHoehe / 18   *   13 );
        } else {
            addObject(new WaechterStartscreen(false, iBreite , iHoehe), iBreite / 32 * 13 , iHoehe / 18   *   13 );
        }

    }

    public void Spieler3(boolean Aktiv) {
        if (Aktiv)  {
            addObject(new AbenteurerStartscreen(true, iBreite , iHoehe), iBreite / 32 * 18 , iHoehe / 18   *   13 );
        } else {
            addObject(new AbenteurerStartscreen(false, iBreite , iHoehe), iBreite / 32 * 18 , iHoehe / 18   *   13);
        }

    }

    public void Spieler4(boolean Aktiv) {
        if (Aktiv)  {
            addObject(new WaechterStartscreen(true, iBreite , iHoehe), iBreite / 32 * 23 , iHoehe / 18   *   13 );
        } else {
            addObject(new WaechterStartscreen(false, iBreite , iHoehe), iBreite / 32 * 23 , iHoehe / 18   *   13 );
        }

    }

    private void Start() {
        if (Greenfoot.isKeyDown(Startbutton) && iSpieler > 0)  {
            Greenfoot.setWorld(new Schatzkammer(iBreite, iHoehe, iSpieler));
        }

    }

}