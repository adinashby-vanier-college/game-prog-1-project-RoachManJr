import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class HubWorld extends World
{
    private Checkpoint currentCheckpoint;
    private Player player;
    /**
     * Constructor for objects of class HubWorld.
     */
    public HubWorld()
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
        Player player = new Player();
        addObject(player,400,395);
        DoorTrigger1 doorTrigger1 = new DoorTrigger1();
        addObject(doorTrigger1,310,150);
        Checkpoint checkpoint = new Checkpoint(0);
        addObject(checkpoint,395,263);
        checkpoint.setLocation(392,257);
        DoorTrigger1Challenge doorTrigger1Challenge = new DoorTrigger1Challenge();
        addObject(doorTrigger1Challenge,484,148);
        checkpoint.setLocation(397,247);
        
        RoofedWallWithoutBanner roofedWallWithoutBanner = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner,376,71);
        RoofedOpenedDoor roofedOpenedDoor = new RoofedOpenedDoor();
        addObject(roofedOpenedDoor,312,72);
        RoofedOpenedDoor roofedOpenedDoor2 = new RoofedOpenedDoor();
        addObject(roofedOpenedDoor2,483,72);
        RoofedWallWithBanner roofedWallWithBanner = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner,591,71);
        RoofedWallWithBanner roofedWallWithBanner2 = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner2,206,71);
        RoofedWallWithoutBanner roofedWallWithoutBanner2 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner2,711,71);
        RoofedWallWithoutBanner roofedWallWithoutBanner3 = new RoofedWallWithoutBanner();
        addObject(roofedWallWithoutBanner3,86,71);
        RoofWall roofWall = new RoofWall();
        addObject(roofWall,31,382);
        RoofWall roofWall2 = new RoofWall();
        addObject(roofWall2,770,413);
        RoofFloor roofFloor = new RoofFloor();
        addObject(roofFloor,254,778);
        RoofFloor roofFloor2 = new RoofFloor();
        addObject(roofFloor2,547,778);
    }
    
    public void setCheckpoint(Checkpoint checkpoint)
    {
        currentCheckpoint = checkpoint;
    }

    public Checkpoint getCurrentCheckpoint()
    {
        return currentCheckpoint;
    }
    
     public void act() {
        // Check if the player has been removed and needs to be respawned
        if (getObjects(Player.class).isEmpty()) 
        {   if (currentCheckpoint != null) 
            {
            // Create a new player instance and add it at the checkpoint's location
            player = new Player();
            addObject(player, currentCheckpoint.getX(), currentCheckpoint.getY());
            } 
            else 
            {
            // If no checkpoint is set, respawn the player at the initial starting point
            player = new Player();
            addObject(player, 400, 100);
            }
        }
    }
    
    /*private void respawnPlayer() {
        if (currentCheckpoint != null) {
            // Create a new player instance and add it at the checkpoint's location
            player = new Player();
            addObject(player, currentCheckpoint.getX(), currentCheckpoint.getY());
        } else {
            // If no checkpoint is set, respawn the player at the initial starting point
            player = new Player();
            addObject(player, 400, 100);
        }
    }*/
}