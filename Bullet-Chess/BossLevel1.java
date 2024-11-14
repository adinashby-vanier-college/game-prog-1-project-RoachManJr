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
        super(1000, 700, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Rook rook =  new  Rook();
        addObject(rook, 500, 100);
        Bishop bishop = new Bishop();
        addObject(bishop,500,300);
        Player player = new Player();
        addObject(player,501,638);
    }
    public void transitionToHubWorld(){
        HubWorld hubWorld = new HubWorld();
        Greenfoot.setWorld(hubWorld);
    }
}
