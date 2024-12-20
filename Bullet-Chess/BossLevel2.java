import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class BossLevel2 extends World
{
    private RoofedClosedDoor roofedClosedDoor;
    private Rook rook;
    private Bishop bishop;
    private boolean doorOpened = false;
    /**
     * Constructor for objects of class BossLevel2.
     */
    public BossLevel2()
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
        rook =  new  Rook();
        addObject(rook, 500, 200);
        bishop = new Bishop();
        addObject(bishop,500,300);
        Player player = new Player();
        addObject(player,500,680);
        RoofedClosedDoor roofedClosedDoor = new RoofedClosedDoor();
        addObject(roofedClosedDoor,500,55);
        RoofedWallWithBanner roofedWallWithBanner = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner,392,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner,608,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner2 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner2,272,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner3 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner3,152,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner4 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner4,32,55);
        RoofedWallWithBanner roofedWallWithBanner5 = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner5,728,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner5 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner5,848,55);
        RoofedWallWithoutBanner roofedWallWithoutBanner6 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner6,968,55);
        RoofWall roofWall = new RoofWall();
        addObject(roofWall,31,414);
        RoofWall roofWall2 = new RoofWall();
        addObject(roofWall2,972,250);
        RoofFloor roofFloor = new RoofFloor();
        addObject(roofFloor,254,678);
        RoofFloor roofFloor2 = new RoofFloor();
        addObject(roofFloor2,749,679);
        SafeEntrance safeEntrance = new SafeEntrance(200, 45);
        addObject(safeEntrance,505,680);
    }
        public void act(){
        if (!doorOpened && rook != null && bishop != null && !getObjects(Rook.class).contains(rook) && !getObjects(Bishop.class).contains(bishop)){
          removeObject(roofedClosedDoor);
          RoofedOpenedDoor roofedOpenedDoor = new RoofedOpenedDoor();
          addObject(roofedOpenedDoor, 500, 55);
          DoorTrigger3Hub doorTrigger3 = new DoorTrigger3Hub();
          addObject(doorTrigger3,500,130);
          doorOpened = true;
      }
    }
    public void transitionToHubWorld3(){
        HubWorld3 hubWorld3 = new HubWorld3();
        Greenfoot.setWorld(hubWorld3);
    }
}
