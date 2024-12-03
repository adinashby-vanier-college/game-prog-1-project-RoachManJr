import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class HubWorld2 extends World
{
    private Player player;
    /**
     * Constructor for objects of class HubWorld2.
     */
    public HubWorld2()
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


        RoofedWallWithoutBanner roofedWallWithoutBanner = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner,376,71);
        RoofedOpenedDoor roofedOpenedDoor = new RoofedOpenedDoor();
        addObject(roofedOpenedDoor,312,72);
        RoofedOpenedDoor roofedOpenedDoor2 = new RoofedOpenedDoor();
        addObject(roofedOpenedDoor2,483,72);
        RoofedWallWithBanner roofedWallWithBanner = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner,591,71);
        RoofedWallWithBanner roofedWallWithBanner2 = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner2,206,71);
        RoofedWallWithoutBanner roofedWallWithoutBanner2 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner2,711,71);
        RoofedWallWithoutBanner roofedWallWithoutBanner3 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner3,86,71);
        RoofWall roofWall = new RoofWall();
        addObject(roofWall,31,382);
        RoofWall roofWall2 = new RoofWall();
        addObject(roofWall2,770,413);
        RoofFloor roofFloor = new RoofFloor();
        addObject(roofFloor,254,778);
        RoofFloor roofFloor2 = new RoofFloor();
        addObject(roofFloor2,547,778);
        
        DoorTrigger2 trig = new DoorTrigger2();
        addObject(trig,312,145);
        DoorTrigger2Challenge trigChal = new DoorTrigger2Challenge();
        addObject(trigChal,483,145);

    }

     public void act() {

    }
}
