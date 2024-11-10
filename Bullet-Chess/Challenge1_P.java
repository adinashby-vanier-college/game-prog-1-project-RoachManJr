// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Challenge1_P extends World
{

    /**
     * Constructor for objects of class Challenge1_P.
     */
    public Challenge1_P()
    {
        super(500, 500, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        RooflessWallWithBanner rooflessWallWithBanner =  new RooflessWallWithBanner();
        addObject(rooflessWallWithBanner, 440, 48);
        RooflessWallWithoutBanner rooflessWallWithoutBanner =  new RooflessWallWithoutBanner();
        addObject(rooflessWallWithoutBanner, 320, 48);
        RooflessWallWithBanner rooflessWallWithBanner2 =  new RooflessWallWithBanner();
        addObject(rooflessWallWithBanner2, 170, 48);
        RooflessWallWithoutBanner rooflessWallWithoutBanner2 =  new RooflessWallWithoutBanner();
        addObject(rooflessWallWithoutBanner2, 50, 48);
        RooflessOpenedDoor rooflessOpenedDoor =  new RooflessOpenedDoor();
        addObject(rooflessOpenedDoor, 252, 48);
    }
}
