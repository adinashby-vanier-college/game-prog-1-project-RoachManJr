import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Challenge3M extends World
{

    /**
     * Constructor for objects of class Challenge1M.
     */
    public Challenge3M()
    {
        super(940, 920, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
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
        addObject(roofedClosedDoor, 470, 70);
        RoofedWallWithBanner roofedWallWithBanner3 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner3, 578, 70);
        RoofedWallWithoutBanner roofedWallWithoutBanner2 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner2, 698, 70);
        RoofedWallWithBanner roofedWallWithBanner4 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner4, 818, 70);
        Roof roof =  new Roof();
        addObject(roof, 287, 283);
        Roof roof2 =  new Roof();
        addObject(roof2, 223, 283);
        RoofedWallWithBanner roofedWallWithBanner5 =  new RoofedWallWithBanner();
        addObject(roofedWallWithBanner5, 597, 330);
        RoofedWallWithoutBanner roofedWallWithoutBanner3 =  new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner3, 689, 378);
        Roof roof3 =  new Roof();
        addObject(roof3, 661, 283);
        Roof roof4 =  new Roof();
        addObject(roof4, 717, 283);
        RoofedWallWithoutBanner roofedWallWithoutBanner8 =  new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner8, 343, 330);
        RoofedWallWithBanner roofedWallWithBanner6 =  new RoofedWallWithBanner();
        addObject(roofedWallWithBanner6, 470, 700);
        RoofedWallWithoutBanner roofedWallWithoutBanner4 =  new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner4, 350, 700);
        RoofedWallWithoutBanner roofedWallWithoutBanner5 =  new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner5, 590, 700);
        RoofedWallWithBanner roofedWallWithBanner40 =  new RoofedWallWithBanner();
        addObject(roofedWallWithBanner40, 251, 378);
        RoofWall roofWall9 =  new  RoofWall();
        addObject(roofWall9, 909, 461);
        RoofWall roofWall10 =  new  RoofWall();
        addObject(roofWall10, 32, 461);
        RoofFloor roofFloor1 =  new  RoofFloor();
        addObject(roofFloor1, 255, 901);
        RoofFloor roofFloor2 =  new  RoofFloor();
        addObject(roofFloor2, 686, 901);
        SafeEntrance safeEntrance = new SafeEntrance(75, 50);
        addObject(safeEntrance,470,905);
        Player player = new Player();
        addObject(player,470,902);
        MiniRook_2M_UL miniRook = new MiniRook_2M_UL();
        addObject(miniRook,102,190);
        MiniRook_2M_LR miniRook2 = new MiniRook_2M_LR();
        addObject(miniRook2,830,840);
        MiniKnightBH miniKnightBH = new MiniKnightBH();
        addObject(miniKnightBH,471,511);
    }
}
