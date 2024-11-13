import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Challenge2M extends World
{

    /**
     * Constructor for objects of class Challenge2M.
     */
    public Challenge2M()
    {
        super(940, 940, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        RoofedWallWithBanner roofedWallWithBanner =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner, 123, 70);
        RoofedWallWithoutBanner roofedWallWithoutBanner =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner, 243, 70);
        RoofedWallWithBanner roofedWallWithBanner2 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner2, 363, 70);
        RoofedClosedDoor roofedClosedDoor =  new  RoofedClosedDoor();
        addObject(roofedClosedDoor, 470, 72);
        RoofedWallWithBanner roofedWallWithBanner3 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner3, 578, 70);
        RoofedWallWithoutBanner roofedWallWithoutBanner2 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner2, 698, 70);
        RoofedWallWithBanner roofedWallWithBanner4 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner4, 818, 70);
        
        RoofedWallWithoutBanner roofedWallWithoutBanner10 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner10, 410, 730);
        RoofedWallWithoutBanner roofedWallWithoutBanner20 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner20, 530, 730);
        RoofedWallWithBanner roofedWallWithBanner10 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner10, 410, 310);
        RoofedWallWithoutBanner roofedWallWithoutBanner3 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner3, 530, 310);
        RoofedWallWithBanner roofedWallWithBanner20 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner20, 203, 548);
        RoofedWallWithoutBanner roofedWallWithoutBanner4 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner4, 736, 548);
        Roof roof =  new  Roof();
        addObject(roof, 175, 451);
        Roof roof2 =  new  Roof();
        addObject(roof2, 231, 451);
        Roof roof3 =  new  Roof();
        addObject(roof3, 708, 451);
        Roof roof4 =  new  Roof();
        addObject(roof4, 764, 451);
        
        RoofWall roofWall9 =  new  RoofWall();
        addObject(roofWall9, 909, 461);
        RoofWall roofWall10 =  new  RoofWall();
        addObject(roofWall10, 32, 461);
        RoofFloor roofFloor1 =  new  RoofFloor();
        addObject(roofFloor1, 255, 901);
        RoofFloor roofFloor2 =  new  RoofFloor();
        addObject(roofFloor2, 686, 901);
    }
}
