// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Challenge1M extends World
{

    /**
     * Constructor for objects of class Challenge1M.
     */
    public Challenge1M()
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
        RooflessWallWithBanner rooflessWallWithBanner =  new  RooflessWallWithBanner();
        addObject(rooflessWallWithBanner, 110, 132);
        rooflessWallWithBanner.setLocation(59, 48);
        RooflessWallWithoutBanner rooflessWallWithoutBanner =  new  RooflessWallWithoutBanner();
        addObject(rooflessWallWithoutBanner, 110, 132);
        rooflessWallWithoutBanner.setLocation(179, 48);
        RooflessWallWithBanner rooflessWallWithBanner2 =  new  RooflessWallWithBanner();
        addObject(rooflessWallWithBanner2, 492, 470);
        rooflessWallWithBanner2.setLocation(179, 48);
    }
}
