import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * Knight class that moves and shoots bullets at the Player.
 */
public class MiniKnightMiddle extends Knight
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

    int cooldownCounter2 = 0;
    
    private Player player;
    
    private int health = 6; 
    private HealthBar healthBar;
    private int targetX, targetY;
    private int speed2 = 2;
    
    public MiniKnightMiddle() {
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
        
        move3();
        
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

        public void move3() {
        cooldownCounter2++;
            if (cooldownCounter2 == 10) {
            cooldownCounter2 = 0;
            BulletHorse3 bullet = new BulletHorse3(); 
            int randomDirection = Greenfoot.getRandomNumber(360); 
            bullet.setRotation(randomDirection); 
            getWorld().addObject(bullet, getX(), getY());
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
