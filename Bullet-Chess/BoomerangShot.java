import lang.stride.*;
import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BoomerangShot extends Player {
    private int distanceTraveled = 0;
    private int splitDistance = 200; // Distance after which it splits (for the main projectile)
    private int maxTravelDistance = 200; // Maximum distance before the split projectiles disappear
    private int speed = 5;
    private float radius = 75; 
    private boolean hasComeBack = false; // Tracks if the projectile has already split
    private int distanceBeforeDisappearing = 0; // Distance traveled by split projectiles
    private double angle;
    GifImage Spin = new GifImage("bullet006.gif");
    
    /**
     * Bullet constructor
     */
    public BoomerangShot(int x, int y, double angle, int speed)
    {
        setLocation(x, y);
        this.angle = angle;
        this.speed = speed;
    }
    
    // Default 'act' method called by Greenfoot
    public void act() {
        setImage(Spin.getCurrentImage());
        update();  // Call the renamed 'update' method inside the act method
    }
    
    // This method is now responsible for handling the movement and split logic
    public void update() {  
        handleMovement();
    }

    private void handleMovement() {
        move(speed);  // Move the projectile
        
        Assets assets = (Assets) getOneIntersectingObject(Assets.class); // check for walls
        if (!hasComeBack) {
            distanceTraveled += speed;

            // Check if the original BoomerangShot projectile should split
            if (distanceTraveled >= splitDistance || assets != null) {
                comeBack();  // Split the projectile into 5 new ones
                getWorld().removeObject(this); // Remove the original BoomerangShot projectile after splitting
            }
        } else {
            distanceBeforeDisappearing += speed;

            // If the split projectile travels the defined distance, remove it
            if (distanceBeforeDisappearing >= maxTravelDistance || assets != null) {
                getWorld().removeObject(this);
            }
        }
    }
    
    private void comeBack() {
        if (hasComeBack) return; // Prevent further splitting
        hasComeBack = true;

        World world = getWorld();
        Player player = (Player) getWorld().getObjects(Player.class).get(0); 
        if (player != null) {
            
            int playerX = player.getX();
            int playerY = player.getY();
            
            double angle = Math.atan2(playerY - getY(), playerX - getX());

            ReturningBoomerangShot returningBoomerangShot = new ReturningBoomerangShot(getX(), getY(), angle, speed); 
            getWorld().addObject(returningBoomerangShot, getX(), getY()); 
        }
    }

    public void markAsFinal() {
        hasComeBack = true; // Prevent the new projectiles from splitting again
    }
    
}
