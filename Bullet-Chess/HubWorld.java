import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class HubWorld extends World
{

    /**
     * Constructor for objects of class HubWorld.
     */
    public HubWorld()
    {
        super(800, 800, 1);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,400,395);
    }
}