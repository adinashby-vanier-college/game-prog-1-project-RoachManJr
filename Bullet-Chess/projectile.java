import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class projectile extends Actor
{
    private int dx;
    private int dy;
    private double speed = 5.0;

    /**
     * 
     */
    public projectile(int dx, int dy)
    {
        double length = Math.sqrt(dx * dx + dy * dy);
        this.dx = (int)(dx / length * speed);
        this.dy = (int)(dy / length * speed);
    }

    /**
     * 
     */
    public void act()
    {
        moveBullet();
        
        GreenfootImage myImage; //Bullet Image (DO NOT CHANGE)
        myImage = new GreenfootImage("SmallerBeeper.png");
        setImage(myImage);
    }

    /**
     * 
     */
    private void moveBullet()
    {
        setLocation(getX() + dx, getY() + dy);
        Assets assets = (Assets) getOneIntersectingObject(Assets.class);
        if (isAtEdge() || assets != null) {
            getWorld().removeObject(this);
        }
    }
}
