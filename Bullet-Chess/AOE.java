import lang.stride.*;
import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AOE extends Player {
    private int distanceTraveled = 0;
    private int splitDistance = 200; // Distance after which it splits (for the main projectile)
    private int maxTravelDistance = 200; // Maximum distance before the split projectiles disappear
    private int speed = 5;
    private boolean hasSplit = false; // Tracks if the projectile has already split
    private int distanceBeforeDisappearing = 0; // Distance traveled by split projectiles

    // Default 'act' method called by Greenfoot
    public void act() {
        update();  // Call the renamed 'update' method inside the act method
    }

    // This method is now responsible for handling the movement and split logic
    public void update() {  
        handleMovement();
    }

    private void handleMovement() {
        move(speed);  // Move the projectile
        
        Assets assets = (Assets) getOneIntersectingObject(Assets.class); // check for walls
        if (!hasSplit) {
            distanceTraveled += speed;

            // Check if the original AOE projectile should split
            if (distanceTraveled >= splitDistance || assets != null) {
                split();  // Split the projectile into 5 new ones
                getWorld().removeObject(this); // Remove the original AOE projectile after splitting
            }
        } else {
            distanceBeforeDisappearing += speed;

            // If the split projectile travels the defined distance, remove it
            if (distanceBeforeDisappearing >= maxTravelDistance || assets != null) {
                getWorld().removeObject(this);
            }
        }
    }

    private void split() {
        if (hasSplit) return; // Prevent further splitting
        hasSplit = true;

        World world = getWorld();
        for (int i = 0; i < 5; i++) {
            double angle = i * 72; // 5 projectiles spread in a circular pattern (72° apart)
            AOE newAOE = new AOE();
            world.addObject(newAOE, getX(), getY());
            newAOE.setRotation((int) angle);
            newAOE.markAsFinal(); // Mark new projectiles as non-splitting
        }
    }

    public void markAsFinal() {
        hasSplit = true; // Prevent the new projectiles from splitting again
    }
}
