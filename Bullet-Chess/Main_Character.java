// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Main_Character extends Actor
{

    /**
     * Act - do whatever the Main_Character wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
        fireProjectile();
    }

    /**
     * 
     */
    public void moveAround()
    {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 4);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 4);
        }
        if (Greenfoot.isKeyDown("a")) {
            move(-4);
        }
        if (Greenfoot.isKeyDown("d")) {
            move(4);
        }
    }

    /**
     * 
     */
    public void fireProjectile()
    {
        if (Greenfoot.isKeyDown("space")) {
            getWorld().addObject( new  projectile(), getX(), getY() - 30);
        }
    }
}
