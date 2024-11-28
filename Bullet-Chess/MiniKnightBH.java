import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * Knight class that moves and shoots bullets at the Player.
 */
public class MiniKnightBH extends Knight
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

    /**
     * Act - do whatever the Knight wants to do.
     */
    public void act()
    {
        move3();
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
