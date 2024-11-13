import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Challenge2_P extends World
{

    /**
     * Constructor for objects of class Challenge2_P.
     */
    public Challenge2_P()
    {
        super(570, 550, 1);
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
        addObject(roofFloor, 70, 530);
        RoofFloor roofFloor1 =  new  RoofFloor();
        addObject(roofFloor1, 500, 530);
        RoofWall roofWall = new RoofWall();
        addObject(roofWall,26,362);
        RoofWall roofWall1 = new RoofWall();
        addObject(roofWall1,544,362);
    }
}
