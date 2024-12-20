import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Challenge2M extends World
{
    private RoofedClosedDoor roofedClosedDoor;
    private MiniRook_2M_UL rookLeft;
    private MiniBishop_2M_D bishDown;
    private MiniRook_2M_LR rookRight;
    private MiniBishop_2M_U bishUp;
    private boolean doorOpened = false;
    /**
     * Constructor for objects of class Challenge2M.
     */
    public Challenge2M()
    {
        super(940, 920, 1);
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
        addObject(roofedClosedDoor, 470, 70);
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
        SafeEntrance safeEntrance = new SafeEntrance(75, 50);
        addObject(safeEntrance,470,905);
        Player player = new Player();
        addObject(player,470,902);
        
        rookLeft = new MiniRook_2M_UL();
        addObject(rookLeft,102,190);
        bishDown = new MiniBishop_2M_D();
        addObject(bishDown,472, 407);
        rookRight = new MiniRook_2M_LR();
        addObject(rookRight,830,840);
        bishUp = new MiniBishop_2M_U();
        addObject(bishUp,472, 636);
    }
        public void act(){
        if (!doorOpened && rookLeft != null && rookRight != null && bishUp != null && bishDown != null && !getObjects(MiniRook_2M_UL.class).contains(rookLeft) && !getObjects(MiniRook_2M_LR.class).contains(rookRight) && !getObjects(MiniBishop_2M_D.class).contains(bishDown) && !getObjects(MiniBishop_2M_U.class).contains(bishUp)){
          removeObject(roofedClosedDoor);
          RoofedOpenedDoor roofedOpenedDoor = new RoofedOpenedDoor();
          addObject(roofedOpenedDoor, 470, 70);
          DoorTrigger2ChallengeP trigger = new DoorTrigger2ChallengeP();
          addObject(trigger,470,145);
          doorOpened = true;
      }
    }
}
