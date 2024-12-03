import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Challenge3_P extends World
{

    /**
     * Constructor for objects of class Challenge3_P.
     */
    public Challenge3_P()
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
        addObject(roofedWallWithBanner, 476, 70);
        RoofedWallWithoutBanner roofedWallWithoutBanner =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner, 356, 70);
        RoofedWallWithBanner roofedWallWithBanner2 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner2, 116, 70);
        RoofedWallWithoutBanner roofedWallWithoutBanner2 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner2, 236, 70);
        RoofFloor roofFloor =  new  RoofFloor();
        addObject(roofFloor, 70, 530);
        RoofFloor roofFloor1 =  new  RoofFloor();
        addObject(roofFloor1, 500, 530);
        RoofWall roofWall = new RoofWall();
        addObject(roofWall,26,362);
        RoofWall roofWall1 = new RoofWall();
        addObject(roofWall1,544,362);
        SafeEntrance safeEntrance = new SafeEntrance(75, 50);
        addObject(safeEntrance,285,535);
        Player player = new Player();
        addObject(player,285,530);
        InfoPaperBoomerang infoPaperBoomerang = new InfoPaperBoomerang();
        addObject(infoPaperBoomerang,291,326);
    }
}
