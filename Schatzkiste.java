import greenfoot.*;
public class Schatzkiste extends Actor
{   
    public Schatzkiste(int Wandgroesse, int Status){
        if(Status == 1){
            setImage("Kiste_1.png");
            getImage().scale(Wandgroesse, Wandgroesse);
        }else if(Status == 2){
            setImage("Kiste_2.png");
            getImage().scale(Wandgroesse, Wandgroesse);
        }else if(Status == 3){
            setImage("Kiste_3.png");
            getImage().scale(Wandgroesse, Wandgroesse);
        }
    }
    public void act() 
    {
        
    }    
}
