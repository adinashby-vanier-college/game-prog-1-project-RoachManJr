// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class projectile extends Actor
{

    /**
     * Act - do whatever the projectile wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        ProjectileMove();
        RemoveBullet();
    }

    /**
     * 
     */
    public void ProjectileMove()
    {
        setLocation(getX(), getY() - 5);
    }

    /**
     * 
     */
    public void RemoveBullet()
    {
        if (getY() == 0) {
            getWorld().removeObject(this);
        }
    }
}
