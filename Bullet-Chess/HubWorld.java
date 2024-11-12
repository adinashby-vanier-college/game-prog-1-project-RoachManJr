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
        DoorTrigger1 doorTrigger12 = new DoorTrigger1();
        addObject(doorTrigger12,321,104);
        RooflessWallWithoutBanner rooflessWallWithoutBanner = new RooflessWallWithoutBanner();
        addObject(rooflessWallWithoutBanner,787,48);
        RoofedWallWithBanner roofedWallWithBanner = new RoofedWallWithBanner();
        addObject(roofedWallWithBanner,655,57);
        roofedWallWithBanner.setLocation(587,246);
        removeObject(roofedWallWithBanner);
        RooflessWallWithBanner rooflessWallWithBanner = new RooflessWallWithBanner();
        addObject(rooflessWallWithBanner,667,48);
        RooflessWallWithoutBanner rooflessWallWithoutBanner2 = new RooflessWallWithoutBanner();
        addObject(rooflessWallWithoutBanner2,547,48);
        RooflessOpenedDoor rooflessOpenedDoor = new RooflessOpenedDoor();
        addObject(rooflessOpenedDoor,486,48);
        RooflessWallWithoutBanner rooflessWallWithoutBanner3 = new RooflessWallWithoutBanner();
        addObject(rooflessWallWithoutBanner3,378,48);
        RooflessOpenedDoor rooflessOpenedDoor2 = new RooflessOpenedDoor();
        addObject(rooflessOpenedDoor2,319,48);
        RooflessWallWithBanner rooflessWallWithBanner2 = new RooflessWallWithBanner();
        addObject(rooflessWallWithBanner2,211,48);
        RooflessWallWithoutBanner rooflessWallWithoutBanner4 = new RooflessWallWithoutBanner();
        addObject(rooflessWallWithoutBanner4,11,48);
        RooflessWallWithoutBanner rooflessWallWithoutBanner5 = new RooflessWallWithoutBanner();
        addObject(rooflessWallWithoutBanner5,91,48);
        rooflessOpenedDoor2.setLocation(317,91);
        DoorTrigger1 doorTrigger1 = new DoorTrigger1();
        addObject(doorTrigger1,317,91);
        removeObject(doorTrigger1);
        rooflessOpenedDoor2.setLocation(317,89);
        rooflessOpenedDoor2.setLocation(318,47);
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
        if (getObjects(Player.class).isEmpty()) {
            respawnPlayer();
        }
    }
    
    private void respawnPlayer() {
        if (currentCheckpoint != null) {
            // Create a new player instance and add it at the checkpoint's location
            player = new Player();
            addObject(player, currentCheckpoint.getX(), currentCheckpoint.getY());
        } else {
            // If no checkpoint is set, respawn the player at the initial starting point
            player = new Player();
            addObject(player, 400, 100);
        }
    }
}