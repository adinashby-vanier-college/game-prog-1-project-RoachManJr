import lang.stride.*;
import java.util.*;
import greenfoot.*;
/**
 * 
 */
public class Knight extends NPCs
{
    private BulletHorse1 bulletHorse1; 
    private int x;
    private int y;
    private float radius = 75;    
    private float speed = 2;       
    int move1Delay = 1000;
    int cooldownCounter1 = 0;
    private int step = 0;
    private int direction;
    
    int moveDelay = 50;
    int cooldownCounter = 0;
    /**
     * Act - do whatever the Boss_1 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (cooldownCounter1<= 0) {
                move1();
                cooldownCounter1= move1Delay;
            }
        if (cooldownCounter1 > 0) {
                cooldownCounter1--;
            }
        if (bulletHorse1 != null) {
                bulletHorse1.updateCenter(getX(), getY());
            }
        }
    /**
     * 
     */
    public void moveKnight()
    {
        
    }   
    public void move1()
    {
        bulletHorse1 = new BulletHorse1(getX(), getY(), radius, speed);
        getWorld().addObject(bulletHorse1, getX(), getY());
    }
    public void move2()
    {
        
    }
    public void move3()
    {
        
    }
}
