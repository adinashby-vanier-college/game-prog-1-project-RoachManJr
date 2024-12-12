import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheBloodArena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheBloodArena extends World
{

    /**
     * Constructor for objects of class TheBloodArena.
     * 
     */
    public TheBloodArena()
    {    
        super(1000, 800, 1); 
        prepare();
    }
    public void prepare(){
        Player player = new Player();
        addObject(player,500,780);
        
        
        RoofedClosedDoor roofedClosedDoor = new RoofedClosedDoor();
        addObject(roofedClosedDoor,500,58);
        RoofedWallWithBanner roofedWallWithBanner = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner,392,58);
        RoofedWallWithoutBanner roofedWallWithoutBanner = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner,272,58);
        RoofedWallWithoutBanner roofedWallWithoutBanner2 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner2,152,58);
        RoofedWallWithoutBanner roofedWallWithoutBanner3 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner3,32,58);
        RoofedWallWithoutBanner roofedWallWithoutBanner4 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner4,608,58);
        RoofedWallWithBanner roofedWallWithBanner2 = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner2,727,58);
        RoofedWallWithoutBanner roofedWallWithoutBanner5 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner5,847,58);
        RoofedWallWithoutBanner roofedWallWithoutBanner6 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner6,967,58);
        RoofWall roofWall = new RoofWall();
        addObject(roofWall,29,449);
        RoofWall roofWall2 = new RoofWall();
        addObject(roofWall2,969,400);
        RoofFloor roofFloor = new RoofFloor();
        addObject(roofFloor,252,780);
        RoofFloor roofFloor2 = new RoofFloor();
        addObject(roofFloor2,746,780);
        SafeEntrance safeEntrance = new SafeEntrance(150, 50);
        addObject(safeEntrance,498,784);
    }
}