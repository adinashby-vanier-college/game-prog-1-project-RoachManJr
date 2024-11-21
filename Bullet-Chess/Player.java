import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Player extends Actor
{
    protected int shootDelay = 20;
    protected int dashDelay = 200;
    protected int cooldownCounter = 0;
    protected int dashCooldownCounter = 0;
    private int health = 100;
    private boolean canShoot = true;
    private int cooldownTime = 60;
    /* Cooldown time 10 sec*/
    private int delayCounter = 0;
    private boolean canTripleShot = true;
    private int tripleShotCooldownTime = 120;
    /* 2 second cooldown for Tripleshot*/
    private int tripleShotCooldownCounter = 0;

    /**
     * 
     */
    public void act()
    {
        movePlayer();
        canMoveLeft();
        canMoveRight();
        canMoveUp();
        canMoveDown();
        performAction();
        doAction();
        if (Greenfoot.mouseClicked(null) && cooldownCounter <= 0) {
            shootProjectile();
            cooldownCounter = shootDelay;
        }
        if (cooldownCounter > 0) {
            cooldownCounter = cooldownCounter - 1;
        }
        if (Greenfoot.isKeyDown("q") && dashCooldownCounter <= 0) {
            dashing();
            dashCooldownCounter = dashDelay;
        }
        if (dashCooldownCounter > 0) {
            dashCooldownCounter = dashCooldownCounter - 1;
        }
    }

    /**
     * 
     */
    private void movePlayer()
    {
        if (Greenfoot.isKeyDown("w") && canMoveUp()) {
            setLocation(getX(), getY() - 4);
        }
        if (Greenfoot.isKeyDown("s") && canMoveDown()) {
            setLocation(getX(), getY() + 4);
        }
        if (Greenfoot.isKeyDown("a") && canMoveLeft()) {
            setLocation(getX() - 4, getY());
        }
        if (Greenfoot.isKeyDown("d") && canMoveRight()) {
            setLocation(getX() + 4, getY());
        }
    }

    /**
     * 
     */
    public boolean canMoveLeft()
    {
        boolean canMoveLeft = true;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if (getOneObjectAtOffset(imageWidth / -2 - 4, imageHeight / -2, Assets.class) != null || getOneObjectAtOffset(imageWidth / -2 - 4, imageHeight / 2 - 2, Assets.class) != null) {
            canMoveLeft = false;
        }
        return canMoveLeft;
    }

    /**
     * 
     */
    public boolean canMoveRight()
    {
        boolean canMoveRight = true;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if (getOneObjectAtOffset(imageWidth / 2 + 4, imageHeight / -2, Assets.class) != null || getOneObjectAtOffset(imageWidth / 2 + 4, imageHeight / 2 - 2, Assets.class) != null) {
            canMoveRight = false;
        }
        return canMoveRight;
    }

    /**
     * 
     */
    public boolean canMoveUp()
    {
        boolean canMoveUp = true;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if (getOneIntersectingObject(SafeEntrance.class) != null) {
            
        } else if (getOneObjectAtOffset(imageWidth / -2, imageHeight / -2 - 4, Assets.class) != null || getOneObjectAtOffset(imageWidth / 2, imageHeight / -2 - 4, Assets.class) != null) {
            canMoveUp = false;
        }
        return canMoveUp;
    }

    /**
     * 
     */
    public boolean canMoveDown()
    {
        boolean canMoveDown = true;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        if (getOneObjectAtOffset(imageWidth / -2, imageHeight / 2 + 2, Assets.class) != null || getOneObjectAtOffset(imageWidth / 2, imageHeight / 2 + 2, Assets.class) != null) {
            canMoveDown = false;
        }
        return canMoveDown;
    }

    /**
     * 
     */
    private void shootProjectile()
    {
        if (Greenfoot.mouseClicked(null)) {
            /* Detect click anywhere on the world*/
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null) {
                int mouseX = mouse.getX();
                int mouseY = mouse.getY();
                int dx = mouseX - getX();
                int dy = mouseY - getY();
                projectile Projectile =  new  projectile(dx, dy);
                getWorld().addObject(Projectile, getX(), getY());
            }
        }
    }

    /**
     * 
     */
    private void dashing()
    {   World world = getWorld();
        if (Greenfoot.isKeyDown("q")) {
            /* Dash when 'q' is pressed Diagonal and straight movement based on key combinations*/
            if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a")) {
                /* Dash top-left*/
                setLocation(getX() - 100, getY() - 100);
            }
            else if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d")) {
                /* Dash top-right*/
                setLocation(getX() + 100, getY() - 100);
            }
            else if (Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a")) {
                /* Dash bottom-left*/
                setLocation(getX() - 100, getY() + 100);
            }
            else if (Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("d")) {
                /* Dash bottom-right*/
                setLocation(getX() + 100, getY() + 100);
            }
            else if (Greenfoot.isKeyDown("w")) {
                /* Dash up (forward)*/
                    setLocation(getX(), getY() - 100);
            }
            else if (Greenfoot.isKeyDown("a")) {
                /* Dash left*/
                setLocation(getX() - 100, getY());
            }
            else if (Greenfoot.isKeyDown("s")) {
                /* Dash down*/
                setLocation(getX(), getY() + 100);
            }
            else if (Greenfoot.isKeyDown("d")) {
                /* Dash right*/
                setLocation(getX() + 100, getY());
            }
            else {
                /* If no directional key is pressed, dash forward (upward)*/
                setLocation(getX(), getY() - 100);
            }
        }
    }

    /**
     * 
     */
    public void performAction()
    {
        handleShooting();
        manageCooldown();
    }

    /**
     * 
     */
    private void handleShooting()
    {
        if (canShoot && Greenfoot.isKeyDown("5")) {
            fireProjectile();
            canShoot = false;
        }
    }

    /**
     * 
     */
    private void fireProjectile()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            int playerX = getX();
            int playerY = getY();
            int angle = (int)Math.toDegrees(Math.atan2(mouseY - playerY, mouseX - playerX));
            World world = getWorld();
            AOE aoe =  new  AOE();
            world.addObject(aoe, playerX, playerY);
            aoe.setRotation(angle);
        }
    }

    /**
     * 
     */
    private void manageCooldown()
    {
        if ( ! canShoot) {
            delayCounter = delayCounter + 1;
            if (delayCounter >= cooldownTime) {
                canShoot = true;
                delayCounter = 0;
            }
        }
    }

    /**
     * 
     */
    public void doAction()
    {
        handleTripleShot();
        manageTripleShotCooldown();
    }

    /**
     * 
     */
    private void handleTripleShot()
    {
        if (canTripleShot && Greenfoot.isKeyDown("3")) {
            shootTripleShot();
            canTripleShot = false;
            /* Start cooldown for TripleShot*/
        }
    }

    /**
     * 
     */
    private void shootTripleShot()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            int playerX = getX();
            int playerY = getY();
            int mainAngle = (int)Math.toDegrees(Math.atan2(mouseY - playerY, mouseX - playerX));
            World world = getWorld();
            int i = -1;
            while (i <= 1) {
                TripleShotProjectile tripleShot =  new  TripleShotProjectile();
                world.addObject(tripleShot, playerX, playerY);
                tripleShot.setRotation(mainAngle + i * 15);
                i = i + 1;
            }
        }
    }

    /**
     * 
     */
    private void manageTripleShotCooldown()
    {
        if ( ! canTripleShot) {
            tripleShotCooldownCounter = tripleShotCooldownCounter + 1;
            if (tripleShotCooldownCounter >= tripleShotCooldownTime) {
                canTripleShot = true;
                tripleShotCooldownCounter = 0;
            }
        }
    }

    /**
     * 
     */
    private void die()
    {
        
    }

    /**
     * 
     */
    private void checkForDamage()
    {
        if (isTouching(Rook.class)) {
            takeDamage(10);
        }
    }

    /**
     * 
     */
    private void takeDamage(int damage)
    {
        health = health - damage;
        if (health <= 0) {
            die();
        }
        /*Rook rook = new Rook();
        if(this.isTouching(rook)){
                getWorld().removeObject(this);
        }*/
    }
}