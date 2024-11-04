import lang.stride.*;
import java.util.*;
import greenfoot.*;
/**
 * 
 */
public class Boss_1 extends Actor
{
    private BossProjectileHorse bossprojectilehorse; 
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
    if (bossprojectilehorse != null) {
            bossprojectilehorse.updateCenter(getX(), getY());
        }
    if (cooldownCounter<= 0) {
            moveKnight();
            cooldownCounter= moveDelay;
        }
    if (cooldownCounter > 0) {
            cooldownCounter--;
        } 
    }
    /**
     * 
     */
    public void moveKnight()
    {
        if (step == 0) {
            direction = Greenfoot.getRandomNumber(4); 
            if (direction == 0) {
                move(100); 
            } else if (direction == 1) {
                move(-100); 
            } else if (direction == 2) {
                setLocation(getX(), getY() - 100); 
            } else if (direction == 3) {
                setLocation(getX(), getY() + 100); 
            }
            step++;
        } else if (step == 1) {
            // Move 1 step perpendicular to the previous movement
            if (direction == 0 || direction == 1) {
                setLocation(getX(), getY() + 50); // Move 1 step down/up
            } else {
                setLocation(getX()+ 50, getY()); // Move 1 step right/left
            }
            step++;
        } else {
            
            step = 0; 
        }
    }   
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
