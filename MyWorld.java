
import greenfoot.*;
import java.util.List;
import java.lang.Class;

public abstract class MyWorld extends World {
    
    public MyWorld(int weltbreiteInZelleinheiten, int welthoeheInZelleinheiten, int zelleinheitInPixeln){    
        super(weltbreiteInZelleinheiten, welthoeheInZelleinheiten, zelleinheitInPixeln);
    }
    
    public int count(Class cls){
        return getObjects(cls).size();
    }
    
    public int count(int x, int y, Class cls) {
        return getObjectsAt(x, y, cls).size();        
    }  
}
