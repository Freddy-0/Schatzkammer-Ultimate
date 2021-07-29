import greenfoot.*;
public class Waechter extends Person
{   
    String up;
    String down;
    String left;
    String right;
    public Waechter(String U, String D, String L, String R,int Spielergroessef){
        Person(Spielergroessef);
        getImage().scale(Spielergroesse, Spielergroesse);
        up = U;
        down = D;
        left = L;
        right = R;
    }
    public void act() 
    {
        if(Greenfoot.isKeyDown(up)){
            move("u");
        }
        if(Greenfoot.isKeyDown(left)){
            move("l");
        }
        if(Greenfoot.isKeyDown(down)){
            move("d");
        }
        if(Greenfoot.isKeyDown(right)){
            move("r");
        }  
        fangeAbenteurer();        
    }
        
}
