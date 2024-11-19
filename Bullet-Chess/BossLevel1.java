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
        addObject(knight, 500, 400);
        Player player = new Player();
        addObject(player,500,780);
        RoofedClosedDoor roofedClosedDoor = new RoofedClosedDoor();
        addObject(roofedClosedDoor,500,55);
        RoofedWallWithBanner roofedWallWithBanner = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner,393,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner,608,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner2 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner2,273,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner3 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner3,153,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner4 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner4,33,55);
        RoofedWallWithBanner roofedWallWithBanner2 = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner2,728,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner5 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner5,848,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner6 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner6,968,55);
        RoofWall roofWall = new RoofWall();
        addObject(roofWall,31,348);
        RoofFloor roofFloor = new RoofFloor();
        addObject(roofFloor,254,778);
        RoofWall roofWall2 = new RoofWall();
        addObject(roofWall2,969,348);
        RoofFloor roofFloor2 = new RoofFloor();
        addObject(roofFloor2,746,778);
    }

    public void transitionToHubWorld(){
        HubWorld hubWorld = new HubWorld();
        Greenfoot.setWorld(hubWorld);
    }
}
