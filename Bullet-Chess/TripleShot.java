import lang.stride.*;
import java.util.*;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TripleShot extends Actor
{
    public void act()
    {
        // Check if the "3" key is pressed
        if (Greenfoot.isKeyDown("3"))
        {
            shootThreeProjectiles();
        }
    }

    private void shootThreeProjectiles()
    {
        // Base rotation for the middle projectile
        int baseRotation = getRotation();
        int startX = getX();
        int startY = getY();

        // Create and add the left projectile with a slight angle offset
        projectile leftProjectile = new projectile(startX, startY);
        getWorld().addObject(leftProjectile, startX, startY);
        leftProjectile.setRotation(baseRotation - 15); // Left offset

        // Create and add the center projectile with no offset
        projectile centerProjectile = new projectile(startX, startY);
        getWorld().addObject(centerProjectile, startX, startY);
        centerProjectile.setRotation(baseRotation); // Center shot

        // Create and add the right projectile with a slight angle offset
        projectile rightProjectile = new projectile(startX, startY);
        getWorld().addObject(rightProjectile, startX, startY);
        rightProjectile.setRotation(baseRotation + 15); // Right offset

        // Move each projectile slightly to prevent overlap at the start
        leftProjectile.move(10);
        centerProjectile.move(10);
        rightProjectile.move(10);
    }
}


 
