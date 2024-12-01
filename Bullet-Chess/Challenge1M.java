import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Challenge1M extends World
{

    /**
     * Constructor for objects of class Challenge3M.
     */
    public Challenge1M()
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
        RoofWall roofWall9 =  new  RoofWall();
        addObject(roofWall9, 909, 461);
        RoofWall roofWall10 =  new  RoofWall();
        addObject(roofWall10, 32, 461);
        RoofFloor roofFloor1 =  new  RoofFloor();
        addObject(roofFloor1, 255, 901);
        RoofFloor roofFloor2 =  new  RoofFloor();
        addObject(roofFloor2, 686, 901);
        RoofedWallWithBanner roofedWallWithBanner5 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner5, 597, 330);
        RoofedWallWithoutBanner roofedWallWithoutBanner3 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner3, 689, 378);
        Roof roof1 =  new  Roof();
        addObject(roof1, 223, 283);
        Roof roof2 =  new  Roof();
        addObject(roof2, 279, 283);
        Roof roof3 =  new  Roof();
        addObject(roof3, 661, 283);
        Roof roof4 =  new  Roof();
        addObject(roof4, 717, 283);
        RoofedWallWithoutBanner roofedWallWithoutBanner8 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner8, 343, 330);
        RoofedWallWithBanner roofedWallWithBanner6 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner6, 251, 700);
        RoofedWallWithoutBanner roofedWallWithoutBanner4 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner4, 343, 700);
        RoofedWallWithoutBanner roofedWallWithoutBanner5 =  new  RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner5, 597, 700);
        RoofedWallWithBanner roofedWallWithBanner7 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner7, 689, 700);
        RoofedWallWithBanner roofedWallWithBanner100 =  new  RoofedWallWithBanner();
        addObject(roofedWallWithBanner100, 251, 378);
        Roof roof5 =  new  Roof();
        addObject(roof5, 223, 603);
        Roof roof6 =  new  Roof();
        addObject(roof6, 286, 603);
        Roof roof7 =  new  Roof();
        addObject(roof7, 653, 603);
        Roof roof8 =  new  Roof();
        addObject(roof8, 717, 603);
        SafeEntrance safeEntrance = new SafeEntrance(75, 50);
        addObject(safeEntrance,470,905);
        Player player = new Player();
        addObject(player,470,900);
        MiniKnight_UL miniKnightF = new MiniKnight_UL();
        addObject(miniKnightF,119,218);
        MiniKnight_UR miniKnightF2 = new MiniKnight_UR();
        addObject(miniKnightF2,824,218);
        MiniKnight_BR miniKnightF3 = new MiniKnight_BR();
        addObject(miniKnightF3,824,817);
        MiniKnight_BL miniKnightF4 = new MiniKnight_BL();
        addObject(miniKnightF4,119,817);
        MiniKnightMiddle miniKnightBH = new MiniKnightMiddle();
        addObject(miniKnightBH,471,511);
    }
}
