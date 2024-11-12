import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Checkpoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checkpoint extends Actor
{
   private boolean isActivated = false;
    static int checkpointX = -1;
    static int checkpointY = -1;
    private int checkpoint = 0;
    /**
     * 
     */
    public Checkpoint(int c)
    {
        /* Set the initial image for the checkpoint (e.g., a flag or marker)*/
        setImage("ball.png");
        checkpoint = c;
    }

    /**
     * 
     */
    public void act()
    {
        checkPlayerCollision();
    }

    /**
     * 
     */
    private void checkPlayerCollision()
    {
        /* Check if the player is touching the checkpoint*/
        if (isTouching(Player.class) &&  ! isActivated) {
            activateCheckpoint();
        }
    }

    /**
     * 
     */
    private void activateCheckpoint()
    {
        /* Change the image to show that the checkpoint is activated*/
        setImage("blue-draught.png");
        isActivated = true;
        
        Checkpoint.setCheckpoint(getX(), getY());
        /* Optionally, notify the world or the player that the checkpoint is activated*/
        Greenfoot.playSound("ding-101492.wav");
    }

    /**
     * 
     */
    public boolean isCheckpointActivated()
    {
        return isActivated;
    }
    // Getters for checkpoint data
    public static int getCheckpointX() {
        return Checkpoint.checkpointX;
    }

    public static int getCheckpointY() {
        return Checkpoint.checkpointY;
    }

    // Setters for checkpoint data (called when the player touches a checkpoint)
    public static void setCheckpoint(int x, int y) {
        Checkpoint.checkpointX = x;
        Checkpoint.checkpointY = y;
    }
}
