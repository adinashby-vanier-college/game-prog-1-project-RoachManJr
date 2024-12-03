import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Challenge3M extends World
{
    private RoofedClosedDoor roofedClosedDoor;
    private MiniRook_3M_UL rookLeft;
    private MiniRook_3M_LR rookRight;
    private MiniBishop_3M bishMid;
    private MiniKnight_3M_Middle knightMid;
    private MiniKnight_3M_L knightLeft;
    private MiniKnight_3M_R knightRight;
    private boolean doorOpened = false;
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
        
        rookLeft = new MiniRook_3M_UL();
        addObject(rookLeft,102,190);
        rookRight = new MiniRook_3M_LR();
        addObject(rookRight,830,840);
        knightMid = new MiniKnight_3M_Middle();
        addObject(knightMid,471,511);
        knightLeft = new MiniKnight_3M_L();
        addObject(knightLeft,181,693);
        knightRight = new MiniKnight_3M_R();
        addObject(knightRight,761,693);
        bishMid = new MiniBishop_3M();
        addObject(bishMid,472,605);
    }
    public void act(){
        if (!doorOpened && rookLeft != null && rookRight != null && knightMid != null && knightLeft != null && knightRight != null && bishMid != null && !getObjects(MiniRook_3M_UL.class).contains(rookLeft) && !getObjects(MiniRook_3M_LR.class).contains(rookRight) && !getObjects(MiniBishop_3M.class).contains(bishMid) && !getObjects(MiniKnight_3M_Middle.class).contains(knightMid) && !getObjects(MiniKnight_3M_L.class).contains(knightLeft) && !getObjects(MiniKnight_3M_R.class).contains(knightRight)){
          removeObject(roofedClosedDoor);
          RoofedOpenedDoor roofedOpenedDoor = new RoofedOpenedDoor();
          addObject(roofedOpenedDoor, 470, 70);
          DoorTrigger3ChallengeP trigger = new DoorTrigger3ChallengeP();
          addObject(trigger,470,145);
          doorOpened = true;
      }
    }
}
