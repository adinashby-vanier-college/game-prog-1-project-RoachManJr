import lang.stride.*;
import java.util.*;
import greenfoot.*;
/**
 * 
 */
public class Boss_1 extends Actor
{
    private BossProjectileHorse1 bossprojectilehorse1; 
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
        if (bossprojectilehorse1 != null) {
                bossprojectilehorse1.updateCenter(getX(), getY());
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
        if (bossprojectilehorse1 != null) {
            bossprojectilehorse1.updateCenter(getX(), getY());
        }
        bossprojectilehorse1 = new BossProjectileHorse1(getX(), getY(), radius, speed);
        getWorld().addObject(bossprojectilehorse1, getX(), getY());
    }
    public void move2()
    {
        
    }
    public void move3()
    {
        
    }
}
