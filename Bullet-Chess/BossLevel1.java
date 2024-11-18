import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class BossLevel1 extends World
{

    /**
     * Constructor for objects of class BossLevel1.
     */
    public BossLevel1()
    {
        super(1000, 800, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Knight knight =  new  Knight();
        addObject(knight, 495, 382);
    }
    public void transitionToHubWorld(){
        HubWorld hubWorld = new HubWorld();
        Greenfoot.setWorld(hubWorld);
    }
}
