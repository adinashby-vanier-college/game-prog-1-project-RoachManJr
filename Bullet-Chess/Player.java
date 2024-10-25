import lang.stride.*;
import java.util.*;
import greenfoot.*;

import greenfoot.*;  

public class Player extends Actor {
    int SHOOT_DELAY = 20;
    int cooldownCounter = 0;
    public void act() {
        movePlayer();
        if (Greenfoot.mouseClicked(null) && cooldownCounter<= 0) {
            shootProjectile();
            cooldownCounter = SHOOT_DELAY;
        }
        if (cooldownCounter > 0) {
            cooldownCounter--;
        }
    }

    private void movePlayer() {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 3); 
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 3); 
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 3, getY()); 
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 3, getY()); 
        }
    }

    private void shootProjectile()  {
        if (Greenfoot.mouseClicked(null)) { // Detect click anywhere on the world
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                int mouseX = mouse.getX();
                int mouseY = mouse.getY();
                int dx = mouseX - getX();
                int dy = mouseY - getY();
                Projectile projectile = new Projectile(dx, dy);
                getWorld().addObject(projectile, getX(), getY());
            }
        }
    }
}