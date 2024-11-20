import lang.stride.*;
import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TripleShotProjectile extends Player {
    private int speed = 5;
    private int distanceTraveled = 0; // Tracks the distance traveled
    private int maxDistance = 300; // Max distance before disappearing (change this value as needed)

    public void act() {
        move(speed); // Move the projectile in the current direction
        distanceTraveled += speed; // Increase the traveled distance
        
        Assets assets = (Assets) getOneIntersectingObject(Assets.class); // checks if it hits a wall
        // If the projectile has traveled more than the max distance, remove it
        if (distanceTraveled >= maxDistance || assets != null) {
            getWorld().removeObject(this);
        }
    }
}
