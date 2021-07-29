import greenfoot.*;
public class Schatz extends Actor
{
    public Schatz(int Wandgroesse){
        getImage().scale(Wandgroesse, Wandgroesse);        
    }
    public void kek() 
    {
        for(int i = 0; i < 12; i++){
            if(i >= 0 && i <= 5){
                setLocation(getX(), getY() + 1);
            }
            if(i <= 6 && i <= 11){
                setLocation(getX(), getY() - 1);   
            }
            if(i == 11){
                i = 0;
            }
        }

    }
    
    public void hover(){        
        //boolean onGround = (getY() == groundLevel);
        // if (!onGround){
        //     hoverHeight++;
        //     setLocation(getX(), getY() + hoverHeight);
        //     if (getY()>=groundLevel){
        //         setLocation(getX(), groundLevel);                
        //        }
        //}else{
        //      hoverHeight = -15;
        //      setLocation(getX(), getY() + hoverHeight);           
        //}
    }
}