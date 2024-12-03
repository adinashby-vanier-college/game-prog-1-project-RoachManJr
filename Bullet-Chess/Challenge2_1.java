import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Challenge2_1 extends World
{
    /**
     * Constructor for objects of class Challenge2_1.
     */
    public Challenge2_1()
    {
        super(570, 800, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        RoofedWallWithBanner roofedWallWithBanner =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner, 510, 70);
        RoofedWallWithoutBanner roofedWallWithoutBanner =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner, 390, 70);
        RoofedOpenedDoor roofedOpenedDoor =  new  RoofedOpenedDoor();
        addObject(roofedOpenedDoor, 282, 70);
        RoofedWallWithBanner roofedWallWithBanner2 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner2, 175, 70);
        RoofedWallWithoutBanner roofedWallWithoutBanner2 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner2, 55, 70);
        RoofFloor roofFloor =  new  RoofFloor();
        addObject(roofFloor, 70, 780);
        RoofFloor roofFloor1 =  new  RoofFloor();
        addObject(roofFloor1, 500, 780);
        RoofWall roofWall = new RoofWall();
        addObject(roofWall,26,362);
        RoofWall roofWall1 = new RoofWall();
        addObject(roofWall1,544,362);
        SafeEntrance safeEntrance = new SafeEntrance(75, 50);
        addObject(safeEntrance,283,784);
        Player player = new Player();
        addObject(player,284,780);

        RoofedWallWithBanner roofedWallWithBanner3 = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner3,117,642);
        RoofedWallWithoutBanner roofedWallWithoutBanner3 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner3,453,642);
        RoofedWallWithoutBanner roofedWallWithoutBanner4 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner4,237,642);
        MiniRook_2_1_Bottom miniRook = new MiniRook_2_1_Bottom();
        addObject(miniRook,78,547);
        RoofedWallWithoutBanner roofedWallWithoutBanner5 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner5,117,452);
        RoofedWallWithoutBanner roofedWallWithoutBanner6 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner6,453,452);
        RoofedWallWithBanner roofedWallWithBanner4 = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner4,333,452);
        
        MiniRook_2_1_Middle miniRook2 = new MiniRook_2_1_Middle();
        addObject(miniRook2,492,357);
        RoofedWallWithoutBanner roofedWallWithoutBanner7 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner7,117,261);
        RoofedWallWithBanner roofedWallWithBanner5 = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner5,237,261);
        RoofedWallWithoutBanner roofedWallWithoutBanner8 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner8,357,261);
        MiniRook_2_1_Top miniRook3 = new MiniRook_2_1_Top();
        addObject(miniRook3,78,165);
        
        DoorTrigger2ChallengeM trigger = new DoorTrigger2ChallengeM();
        addObject(trigger, 282, 145);
    }
}
