import lang.stride.*;
import java.util.*;
import greenfoot.*;

public class Player extends Actor {
    int shootDelay = 20;
    int dashDelay = 200;
    int cooldownCounter = 0;
    int dashCooldownCounter = 0;
    public void act() {
        movePlayer();
        canMoveLeft();
        canMoveRight();
        canMoveUp();
        canMoveDown();
        performAction();
        doAction();
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
        if (Greenfoot.isKeyDown("w") && canMoveUp()) {
            setLocation(getX(), getY() - 3); 
        }
        if (Greenfoot.isKeyDown("s") && canMoveDown()) {
            setLocation(getX(), getY() + 3); 
        }
        if (Greenfoot.isKeyDown("a") && canMoveLeft()) {
            setLocation(getX() - 3, getY()); 
        }
        if (Greenfoot.isKeyDown("d") && canMoveRight()) {
            setLocation(getX() + 3, getY()); 
        }
    
    }

    public boolean canMoveLeft() {
        boolean canMoveLeft = true;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if(getOneObjectAtOffset(imageWidth / -2 - 3, imageHeight / -2, Assets.class) != null ||
           getOneObjectAtOffset(imageWidth / -2 - 3, imageHeight / 2 - 1, Assets.class) != null) {
           canMoveLeft = false;
        }
        return canMoveLeft;
    }
    
        public boolean canMoveRight() {
        boolean canMoveRight = true;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if(getOneObjectAtOffset(imageWidth / 2 + 3, imageHeight / -2, Assets.class) != null ||
           getOneObjectAtOffset(imageWidth / 2 + 3, imageHeight / 2 - 1, Assets.class) != null) {
           canMoveRight = false;
        }
        return canMoveRight;
    }
    
        public boolean canMoveUp() {
        boolean canMoveUp = true;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / -2 - 4, RoofedOpenedDoor.class) != null ||
           getOneObjectAtOffset(imageWidth / 2, imageHeight / -2 - 4, RoofedOpenedDoor.class) != null) {
            
        }
        else if(getOneObjectAtOffset(imageWidth / -2, imageHeight / -2 - 4, Assets.class) != null ||
           getOneObjectAtOffset(imageWidth / 2, imageHeight / -2 - 4, Assets.class) != null) {
            canMoveUp = false;
        }
        return canMoveUp;
    }
    
        public boolean canMoveDown() {
        boolean canMoveDown = true;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if(getOneObjectAtOffset(imageWidth / -2, imageHeight / 2 + 2, Assets.class) != null ||
           getOneObjectAtOffset(imageWidth / 2, imageHeight / 2 + 2, Assets.class) != null) {
           canMoveDown = false;
        }
        return canMoveDown;
    }
    
    private void shootProjectile()  {
        if (Greenfoot.mouseClicked(null)) { // Detect click anywhere on the world
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                int mouseX = mouse.getX();
                int mouseY = mouse.getY();
                int dx = mouseX - getX();
                int dy = mouseY - getY();
                projectile Projectile = new projectile(dx, dy);
                getWorld().addObject(Projectile, getX(), getY());
            }
        }
    }
    private void dashing() {
        if (Greenfoot.isKeyDown("q")) {
            if (Greenfoot.isKeyDown("w")) {
                setLocation(getX(), getY() - 100); 
            }
            else if (Greenfoot.isKeyDown("s")) {
                setLocation(getX(), getY() + 100); 
            }
            else if (Greenfoot.isKeyDown("a")) {
                setLocation(getX() - 100, getY()); 
            }
            else if (Greenfoot.isKeyDown("d")) {
                setLocation(getX() + 100, getY()); 
            }
            else {
                setLocation(getX(), getY() - 100);
            }
        }
    }
    
   
    private boolean canShoot = true; 
    private int cooldownTime = 60;  // Cooldown time 10 sec
    private int delayCounter = 0; 

    public void performAction() { 
        handleShooting();
        manageCooldown();
    }

    private void handleShooting() {
        if (canShoot && Greenfoot.isKeyDown("5")) {
            fireProjectile();
            canShoot = false; 
        }
    }

    private void fireProjectile() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            int playerX = getX();
            int playerY = getY();

            
            int angle = (int) Math.toDegrees(Math.atan2(mouseY - playerY, mouseX - playerX));

            
            World world = getWorld();
            AOE aoe = new AOE();
            world.addObject(aoe, playerX, playerY);
            aoe.setRotation(angle);
        }
    }

    private void manageCooldown() {
        if (!canShoot) {
            delayCounter++;
            if (delayCounter >= cooldownTime) {
                canShoot = true;
                delayCounter = 0;
            }
        }
    }
    private boolean canTripleShot = true;
    private int tripleShotCooldownTime = 120; // 2 second cooldown for Tripleshot
    private int tripleShotCooldownCounter = 0;

    public void doAction() {  
        handleTripleShot();
        manageTripleShotCooldown();
    }

    private void handleTripleShot() {
        if (canTripleShot && Greenfoot.isKeyDown("3")) {
            shootTripleShot();
            canTripleShot = false; // Start cooldown for TripleShot
        }
    }

    private void shootTripleShot() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            int playerX = getX();
            int playerY = getY();

            
            int mainAngle = (int) Math.toDegrees(Math.atan2(mouseY - playerY, mouseX - playerX));

            
            World world = getWorld();
            for (int i = -1; i <= 1; i++) {
                TripleShotProjectile tripleShot = new TripleShotProjectile();
                world.addObject(tripleShot, playerX, playerY);
                tripleShot.setRotation(mainAngle + i * 15); 
            }
        }
    }

    private void manageTripleShotCooldown() {
        if (!canTripleShot) {
            tripleShotCooldownCounter++;
            if (tripleShotCooldownCounter >= tripleShotCooldownTime) {
                canTripleShot = true;
                tripleShotCooldownCounter = 0;
            }
        }
    }
    
}