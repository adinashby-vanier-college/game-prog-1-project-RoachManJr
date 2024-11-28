import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * Knight class that moves and shoots bullets at the Player.
 */
public class Knight extends NPCs
{
    private BulletHorse1 bulletHorse1; 
    private int x;
    private int y;
    private float radius = 75;    
    private float speed = 8;       
    
    private int step = 0;
    private int direction;
    
    int moveDelay = 50;
    int cooldownCounter = 0;
    
    int move1Delay = 800;
    int cooldownCounter1 = 0;
    
    int cooldownCounter2 = 0;

    
    private Player player;

    /**
     * Act - do whatever the Knight wants to do.
     */
    public void act()
    {
        if (cooldownCounter1 <= 0) {
            move1();
            cooldownCounter1 = move1Delay;
        }
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
        if (bulletHorse1 != null) {
            bulletHorse1.updateCenter(getX(), getY());
        }
        move3();
    }

    /**
     * First move: Move in a certain direction and spawn a bullet.
     */
    public void move1()
    {
        bulletHorse1 = new BulletHorse1(getX(), getY(), radius, speed);
        getWorld().addObject(bulletHorse1, getX(), getY());
    }

    /**
     * Second move: Shoot bullets at the Player.
     */
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
        else{}
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
}

