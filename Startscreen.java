import greenfoot.  *;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Startscreen extends MyWorld {
    private GreenfootSound music = new GreenfootSound("Musik.mp3");
    String Startbutton = "enter";
    String Settingsbutton = "escape";
    int Breite;
    int Hoehe;
    int Spielerzahl;
    boolean infinite = false;
    boolean spielerAngezeigt = false;
    public Startscreen(int rBreite, int rHoehe, int Spieler) {
        super(rBreite, rHoehe, 1);
        Breite = rBreite;
        Hoehe = rHoehe;
        Spielerzahl = Spieler;
        prepare();
        music.stop();
    }
    
    private void prepare() {
        setVariables();
        addObjects();
        spielerzahlAnzeigen();
    }
    private void addObjects(){
        addObject(new HintergrundP(Breite, Hoehe), Breite / 2, Hoehe / 2);
        addObject(new Schriftzug(Breite, Hoehe), Breite / 2, Hoehe / 2);
        addObject(new Startaufforderung(Breite, Hoehe, Spielerzahl), Breite / 2, Hoehe / 8   *   7);
        addObject(new SettingsIcon(Breite, Hoehe), Breite / 16 * 1 , Hoehe / 9   *   1);
    }    
    private void setVariables(){
        int Figurenhoehe = Hoehe   /   8   *   6;
        int Figurenbreite = Breite   /   30;
    }

    public void act() {
        Musik();
        Starterfassung();
        Optionen();
    }
    public void Musik() {
        Greenfoot.delay(2);
        music.setVolume(5);
        music.playLoop();
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
    public void Optionen() {
        Settings();
        spielerzahl();
    }
    private void Settings() {
        if (Greenfoot.isKeyDown("escape"))  {
            music.stop();
            Greenfoot.delay(5);
            Greenfoot.setWorld(new Settings(Breite, Hoehe, Spielerzahl));
        }
    }
    private int spielerzahl() {
        if (Greenfoot.isKeyDown("1") && Spielerzahl != 1 )  {
            Spielerzahl = 1;
            spielerzahlAnzeigen();
        } else if (Greenfoot.isKeyDown("2") && Spielerzahl != 2 )  {
            Spielerzahl = 2;
            spielerzahlAnzeigen();
        } else if (Greenfoot.isKeyDown("3") && Spielerzahl != 3 )  {
            Spielerzahl = 3;
            spielerzahlAnzeigen();
        } else if (Greenfoot.isKeyDown("4") && Spielerzahl != 4 )  {
            Spielerzahl = 4;
            spielerzahlAnzeigen();
        }
        return Spielerzahl;
    }
    
    public int setzeSpieler(int Spieler){
        if(Spielerzahl < 5 && Spielerzahl > 0){
            Spielerzahl = Spieler;
        }else{
            Spielerzahl = 2;
        }
        spielerzahlAnzeigen();
        return Spielerzahl;
    }

    private void spielerzahlAnzeigen() {
        if (Spielerzahl == 1)  {
            Spieler1(true);
            Spieler2(false);
            Spieler3(false);
            Spieler4(false);
        } else if (Spielerzahl == 2)  {
            Spieler1(true);
            Spieler2(true);
            Spieler3(false);
            Spieler4(false);
        } else if (Spielerzahl == 3)  {
            Spieler1(true);
            Spieler2(true);
            Spieler3(true);
            Spieler4(false);
        } else if (Spielerzahl == 4)  {
            Spieler1(true);
            Spieler2(true);
            Spieler3(true);
            Spieler4(true);
        }

    }

    public void Spieler1(boolean Aktiv) {
        if (Aktiv)  {
            addObject(new AbenteurerStartscreen(true , Breite , Hoehe), Breite / 32 * 8 , Hoehe / 18   *   13 );
        } else {
            addObject(new AbenteurerStartscreen(false, Breite , Hoehe), Breite / 32 * 8 , Hoehe / 18   *   13 );
        }

    }

    public void Spieler2(boolean Aktiv) {
        if (Aktiv)  {
            addObject(new WaechterStartscreen(true, Breite , Hoehe), Breite / 32 * 13 , Hoehe / 18   *   13 );
        } else {
            addObject(new WaechterStartscreen(false, Breite , Hoehe), Breite / 32 * 13 , Hoehe / 18   *   13 );
        }

    }

    public void Spieler3(boolean Aktiv) {
        if (Aktiv)  {
            addObject(new AbenteurerStartscreen(true, Breite , Hoehe), Breite / 32 * 18 , Hoehe / 18   *   13 );
        } else {
            addObject(new AbenteurerStartscreen(false, Breite , Hoehe), Breite / 32 * 18 , Hoehe / 18   *   13);
        }

    }

    public void Spieler4(boolean Aktiv) {
        if (Aktiv)  {
            addObject(new WaechterStartscreen(true, Breite , Hoehe), Breite / 32 * 23 , Hoehe / 18   *   13 );
        } else {
            addObject(new WaechterStartscreen(false, Breite , Hoehe), Breite / 32 * 23 , Hoehe / 18   *   13 );
        }

    }

    private void Start() {
        if (Greenfoot.isKeyDown(Startbutton) && Spielerzahl > 0)  {
            music.stop();
            Greenfoot.setWorld(new Schatzkammer(Spielerzahl, Breite, Hoehe));
        }

    }

}