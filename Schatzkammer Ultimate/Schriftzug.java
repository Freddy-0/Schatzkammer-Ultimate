import greenfoot.*;
public class Schriftzug extends Actor
{
    public Schriftzug(int Breite, int Hoehe){
        getImage().scale(Breite / 64 * 52, Hoehe / 72 * 7 );
    }
    
    public void act() 
    {
        
    }    
}
