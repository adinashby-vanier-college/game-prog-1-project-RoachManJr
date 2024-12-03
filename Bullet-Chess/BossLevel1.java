import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class BossLevel1 extends World
{
    private RoofedClosedDoor roofedClosedDoor;
    private Knight knight;
    private boolean doorOpened = false;
    
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
        knight = new Knight();
        addObject(knight, 500, 400);
        Player player = new Player();
        addObject(player, 500, 780);

        roofedClosedDoor = new RoofedClosedDoor();
        addObject(roofedClosedDoor, 500, 55);

        RoofedWallWithBanner roofedWallWithBanner = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner, 393, 55);
        RoofedWallWithoutBanner roofedWallWithoutBanner = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner, 608, 55);
        RoofedWallWithoutBanner roofedWallWithoutBanner2 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner2, 273, 55);
        RoofedWallWithoutBanner roofedWallWithoutBanner3 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner3, 153, 55);
        RoofedWallWithoutBanner roofedWallWithoutBanner4 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner4, 33, 55);
        RoofedWallWithBanner roofedWallWithBanner2 = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner2, 728, 55);
        RoofedWallWithoutBanner roofedWallWithoutBanner5 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner5, 848, 55);
        RoofedWallWithoutBanner roofedWallWithoutBanner6 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner6, 968, 55);
        RoofWall roofWall = new RoofWall();
        addObject(roofWall, 31, 348);
        RoofFloor roofFloor = new RoofFloor();
        addObject(roofFloor, 254, 778);
        RoofWall roofWall2 = new RoofWall();
        addObject(roofWall2, 969, 348);
        RoofFloor roofFloor2 = new RoofFloor();
        addObject(roofFloor2, 746, 778);
        SafeEntrance safeEntrance = new SafeEntrance(150, 50);
        addObject(safeEntrance, 500, 782);
    }
    public void act(){
        if (!doorOpened && knight != null && !getObjects(Knight.class).contains(knight)){
          removeObject(roofedClosedDoor);
          RoofedOpenedDoor roofedOpenedDoor = new RoofedOpenedDoor();
          addObject(roofedOpenedDoor, 500, 55);
          DoorTrigger2Hub doorTrigger2 = new DoorTrigger2Hub();
          addObject(doorTrigger2,500,130);
          doorOpened = true;
      }
    }
    public void transitionToHubWorld2(){
        HubWorld2 hubWorld2 = new HubWorld2();
        Greenfoot.setWorld(hubWorld2);
    }
}
