import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * Knight class that moves and shoots bullets at the Player.
 */
public class MiniKnight_BL extends Knight
{
    private int x;
    private int y;
    private float radius = 75;    
    private float speed = 8;       
    int cooldownCounter1 = 0;
    private int step = 0;
    private int direction;
    
    int moveDelay = 50;
    int cooldownCounter = 0;

    
    private Player player;
    
    private int health = 6; 
    private HealthBar healthBar;
    private int targetX, targetY;
    private int speed2 = 2;
    
    public MiniKnight_BL() {
        targetX = 830;
        targetY = 840;
        healthBar = new HealthBar(6);
        healthBar.setOwner(this); 
    }
    
    public void addedToWorld(World world) {
        world.addObject(healthBar, getX(), getY() - 30);
    }

    /**
     * Act - do whatever the Knight wants to do.
     */
    public void act()
    {
        if (health <= 0) {
            removeSelf();
            return; 
        }
        
        if (getWorld() == null) return;
        
        updateHealthBar();
        
        if (cooldownCounter1 > 0) {
            cooldownCounter1--;
        }
        
        if (cooldownCounter <= 0) {
            move2();
            cooldownCounter = moveDelay;
        }
        if (cooldownCounter > 0) {
            cooldownCounter--;
        }
        
        checkForProjectileCollision();
    }
    
    private void updateHealthBar() {
        if (healthBar.getWorld() != null) {
            healthBar.setLocation(getX(), getY() - 30); 
        }
    }

    private void removeSelf() {
        if (healthBar != null && healthBar.getWorld() != null) {
            getWorld().removeObject(healthBar);
        }
        if (getWorld() != null) {
            getWorld().removeObject(this);
        }
    }

    public void move2()
    {
        player = (Player) getWorld().getObjects(Player.class).get(0); 
        if (player != null) {
            
            int playerX = player.getX();
            int playerY = player.getY();
            
            double angle = Math.atan2(playerY - getY(), playerX - getX());

            BulletHorse2 bulletHorse2 = new BulletHorse2(getX(), getY(), angle, speed); 
            getWorld().addObject(bulletHorse2, getX(), getY()); 
        }
    }
    
    private void checkForProjectileCollision() {
        if (isTouching(projectile.class)) {
            health -= 1;
            healthBar.decreaseHealth(1); 
            removeTouching(projectile.class);
        }
        if (isTouching(AOE.class)) {
            health -= 1;
            healthBar.decreaseHealth(1); 
            removeTouching(AOE.class);
        }
        if (isTouching(BoomerangShot.class)) {
            health -= 3;
            healthBar.decreaseHealth(3); 
            removeTouching(BoomerangShot.class);
        }
        if (isTouching(ReturningBoomerangShot.class)) {
            health -= 3;
            healthBar.decreaseHealth(3); 
            removeTouching(ReturningBoomerangShot.class);
        }
        if (isTouching(TripleShotProjectile.class)) {
            health -= 1;
            healthBar.decreaseHealth(1); 
            removeTouching(TripleShotProjectile.class);
        }
    }
}