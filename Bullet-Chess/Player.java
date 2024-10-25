import lang.stride.*;
import java.util.*;
import greenfoot.*;

import greenfoot.*;  

public class Player extends Actor {
    int shootDelay = 20;
    int dashDelay = 200;
    int cooldownCounter = 0;
    int dashCooldownCounter = 0;
    public void act() {
        movePlayer();
        if (Greenfoot.mouseClicked(null) && cooldownCounter<= 0) {
            shootProjectile();
            cooldownCounter = shootDelay;
        }
        if (cooldownCounter > 0) {
            cooldownCounter--;
        }
        if (Greenfoot.isKeyDown("q") && dashCooldownCounter<= 0) {
            dashing();
            dashCooldownCounter = dashDelay;
        }
        if (dashCooldownCounter > 0) {
            dashCooldownCounter--;
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
    private void dashing() {
        if (Greenfoot.isKeyDown("q")) {
             if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 100); 
            }
            if (Greenfoot.isKeyDown("s")) {
                setLocation(getX(), getY() + 100); 
            }
            if (Greenfoot.isKeyDown("a")) {
                setLocation(getX() - 100, getY()); 
            }
            if (Greenfoot.isKeyDown("d")) {
                setLocation(getX() + 100, getY()); 
            }
        }
    }
}