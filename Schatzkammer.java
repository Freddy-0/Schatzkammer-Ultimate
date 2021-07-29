import greenfoot. *;
import java.util.Random;
public class Schatzkammer extends MyWorld {
    int iBreite;
    int iHoehe;
    int Wandgroesse;
    int Spielergroesse;    
    int Schatzanzahl;    
    int Spielerzahl;
    public Schatzkammer(int Breite, int Hoehe, int Spieler){
        super(Breite, Hoehe, 1);
        iBreite = Breite;
        iHoehe = Hoehe;
        Spielerzahl = Spieler;
        prepare();
    }

    public void prepare() {
        setVariables();
        setBackround();
        setzeSchaetze();
        setzeAusenwaende();
        setzeHindernisse();
        setzeSpieler(Spielerzahl);
    }
    
    public void setVariables(){
        Wandgroesse = iHoehe / 30;
        Spielergroesse = iHoehe / 30;
        Schatzanzahl = iBreite  /  40;
    }
    
    public void setBackround(){
        GreenfootImage bg = new GreenfootImage("Sandboden.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }

    public void act() {
        spielEndet();
        schatzkisteAktualisieren();
    }

    public void setzeAusenwaende() {
        /*Oben*/
        for (int i = Wandgroesse  /  2  +  Wandgroesse ; i <= iBreite  -  Wandgroesse ; i = i  +  Wandgroesse){           
            addObject(new Wand(Wandgroesse), i, Wandgroesse  /  2);
        }
        /*Unten*/
        for (int i = Wandgroesse  /  2  +  Wandgroesse ; i <= iBreite  -  Wandgroesse;i = i  +  Wandgroesse){
            addObject(new Wand(Wandgroesse), i, iHoehe  -  Wandgroesse  /  2 );
        }
        /*Links*/
        for (int i = Wandgroesse  /  2 ; i  <= iHoehe ; i = i  +  Wandgroesse){
            addObject(new Wand(Wandgroesse), Wandgroesse  /  2, i);
        }
        /*Rechts*/
        for (int i = Wandgroesse / 2 ; i <= iHoehe ; i = i  +  Wandgroesse){
            addObject(new Wand(Wandgroesse), iBreite  -  Wandgroesse  /  2, i);
        }
        
    }

    /*Setzt die schätze zwischen den ausenwänden an zuffällige stelen*/
    public void setzeSchaetze() {
        Random random = new Random();
        for(int i = 0;i < (Schatzanzahl);i++)
            addObject(new Schatz(Wandgroesse), random.nextInt((iBreite  -  2  *  Wandgroesse) / Wandgroesse ) * Wandgroesse + Wandgroesse + Wandgroesse / 2, random.nextInt((iHoehe  -  2  *  Wandgroesse) / Wandgroesse) * Wandgroesse + Wandgroesse + Wandgroesse / 2);
    }

    /*Setzt die Hindernisse zwischen die ausenwände an zufälligenn stellen*/
    public void setzeHindernisse() {
        Random random = new Random();
        for ( int i = 0;
        i < (iBreite  /  20  *  1.5);
        i++)            
            addObject(new Wand(Wandgroesse), random.nextInt((iBreite  -  2  *  Wandgroesse) / Wandgroesse ) * Wandgroesse + Wandgroesse + Wandgroesse / 2, random.nextInt((iHoehe  -  2  *  Wandgroesse) / Wandgroesse) * Wandgroesse + Wandgroesse + Wandgroesse / 2);
    }

    /*Erstellung der Spieler 1 - 4*/
    public void setzeSpieler(int Tag) {
        if (Tag == 1)  {
            addObject(new Abenteurer("w","s","a","d",Spielergroesse), Spielergroesse / 2 + Wandgroesse - 1, iHoehe - Spielergroesse / 2  -  Wandgroesse  +  1);
            addObject(new Waechter("up","down","left","right",Spielergroesse), iBreite  -  Spielergroesse / 2 - Wandgroesse + 1, Spielergroesse / 2  +  Wandgroesse  -  1 );
        } else if (Tag == 2)  {
            addObject(new Waechter("up","down","left","right",Spielergroesse), iBreite  -  Spielergroesse / 2 - Wandgroesse + 1, Spielergroesse / 2  +  Wandgroesse  -  1 );
            addObject(new Abenteurer("w","s","a","d",Spielergroesse), Spielergroesse / 2 + Wandgroesse - 1, iHoehe - Spielergroesse / 2  -  Wandgroesse  +  1);
        } else if (Tag == 3)  {
            addObject(new Abenteurer("w","s","a","d",Spielergroesse), Spielergroesse / 2 + Wandgroesse - 1, iHoehe - Spielergroesse / 2  -  Wandgroesse  +  1);
            addObject(new Waechter("up","down","left","right",Spielergroesse), iBreite  -  Spielergroesse / 2 - Wandgroesse + 1, Spielergroesse / 2  +  Wandgroesse  -  1 );
            addObject(new Abenteurer("8","5","4","6",Spielergroesse), Spielergroesse / 2 + Wandgroesse - 1 , Spielergroesse / 2  +  Wandgroesse  -  1);
        } else if (Tag == 4)  {
            addObject(new Abenteurer("w","s","a","d",Spielergroesse), Spielergroesse / 2 + Wandgroesse - 1, iHoehe - Spielergroesse / 2  -  Wandgroesse  +  1);
            addObject(new Waechter("up","down","left","right",Spielergroesse), iBreite  -  Spielergroesse / 2 - Wandgroesse + 1, Spielergroesse / 2  +  Wandgroesse  -  1 );
            addObject(new Abenteurer("8","5","4","6",Spielergroesse), Spielergroesse / 2 + Wandgroesse - 1 , Spielergroesse / 2  +  Wandgroesse  -  1);
            addObject(new Waechter("i","k","j","l",Spielergroesse), iBreite  -  Spielergroesse / 2 - Wandgroesse + 1 , iHoehe - Spielergroesse / 2  -  Wandgroesse  +  1);
        }

    }

    /*verschiedene möglichkeiten wie das spiel beendet wird*/
    public void spielEndet() {
        if(Greenfoot.isKeyDown("escape"))  {
            Greenfoot.setWorld(new Startscreen(iBreite, iHoehe, Spielerzahl));
        }

        if(count(Schatz.class) <= 2)  {
            addObject(new AbenteurerWin(), iBreite / 2 , iHoehe / 2);
            Greenfoot.delay(80);
            Greenfoot.setWorld(new Startscreen(iBreite, iHoehe, Spielerzahl));
        }

        if(count(Abenteurer.class) == 0)  {
            addObject(new WaechterWin(), iBreite / 2 , iHoehe / 2 );
            Greenfoot.delay(80);
            Greenfoot.setWorld(new Startscreen(iBreite, iHoehe, Spielerzahl));
        }

    }

    public void schatzkisteAktualisieren() {
        int Schätze = count(Schatz.class);
        if (Schätze <= Schatzanzahl && count(Schatzkiste.class) < 1)  {
            addObject(new Schatzkiste(Wandgroesse,1), Wandgroesse / 2, Wandgroesse / 2);
        }

        if (Schätze < Schatzanzahl  /  2 && count(Schatzkiste.class) < 2)  {
            addObject(new Schatzkiste(Wandgroesse,2), Wandgroesse / 2, Wandgroesse / 2);
        }

        if (Schätze < 4 && count(Schatzkiste.class) < 3)  {
            addObject(new Schatzkiste(Wandgroesse,3), Wandgroesse / 2, Wandgroesse / 2);
        }

    }

}