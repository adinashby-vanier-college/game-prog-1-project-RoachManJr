import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * Knight class that moves and shoots bullets at the Player.
 */
public class MiniKnightF extends Knight
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

    /**
     * Act - do whatever the Knight wants to do.
     */
    public void act()
    {
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
    }
}
