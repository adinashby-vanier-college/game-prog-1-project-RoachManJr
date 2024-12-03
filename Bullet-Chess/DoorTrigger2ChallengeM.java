import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class DoorTrigger2ChallengeM here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorTrigger2ChallengeM extends Actor
{
       private boolean playerInPortal = false;
    
    /**
     * Act - do whatever the DoorTrigger wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void PortalTrigger() {
    
    }

    public void act() {
        invis();
        checkForPlayer();
    }
    
        private void checkForPlayer() {
        // Check if the player is touching the portal
        if (isTouching(Player.class)) {
            // Only start the fade effect if the player hasn't triggered it already
            if (!playerInPortal) {
                playerInPortal = true;

                // Add the fade effect to the world
                FadeTransitionChallenge2M fade = new FadeTransitionChallenge2M();
                getWorld().addObject(fade, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                
                // Delay a moment before transitioning
                Greenfoot.delay(30); // Optional delay before transition
            }
        }
    }
    
    private void invis(){
        setImage(new GreenfootImage(1, 1));
    }
}
