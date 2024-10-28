import lang.stride.*;
import java.util.*;
import greenfoot.*;
/**
 * 
 */
public class Boss_1 extends Actor
{
    private BossProjectileHorse bossprojectilehorse; 
    private float radius = 75;    
    private float speed = 2;       
    int move1Delay = 2000;
    int cooldownCounter1 = 0;
    
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
        moveKnight();
        
    }

    /**
     * 
     */
    public void moveKnight()
    {
    }
    /**
     * 
     */
    public void move1()
    {
        if (bossprojectilehorse != null) {
            bossprojectilehorse.updateCenter(getX(), getY());
        }
        bossprojectilehorse = new BossProjectileHorse(getX(), getY(), radius, speed);
        getWorld().addObject(bossprojectilehorse, getX(), getY());
    }
    public void move2()
    {
        
    }
    public void move3()
    {
        
    }
}
