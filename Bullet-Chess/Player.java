import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Player extends Actor
{
    protected int shootDelay = 20;
    protected int dashDelay = 120;
    protected int cooldownCounter = 0;
    protected int dashCooldownCounter = 0;
    private int health = 100;
    private boolean canShoot = true;
    private int cooldownTime = 60;
    private int delayCounter = 0;
    private boolean canTripleShot = true;
    private int tripleShotCooldownTime = 120;
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
    {
        World world = getWorld();
        int dashDistance = 40;  
        int dashSpeed = 2;  
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if (dashCooldownCounter <= 0) {
            if (Greenfoot.isKeyDown("q")) {
                
                if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a")) {
                    // Dash up-left
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(-dashDistance/2, -dashDistance/2)) {
                            setLocation(getX() - dashDistance/2, getY() - dashDistance/2);
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d")) {
                    // Dash up-right
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(dashDistance/2, -dashDistance/2)) {
                            setLocation(getX() + dashDistance/2, getY() - dashDistance/2);
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a")) {
                    // Dash down-left
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(-dashDistance/2, dashDistance/2)) {
                            setLocation(getX() - dashDistance/2, getY() + dashDistance/2);
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("d")) {
                    // Dash down-right
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(dashDistance/2, dashDistance/2)) {
                            setLocation(getX() + dashDistance/2, getY() + dashDistance/2);
                        }
                        Greenfoot.delay(1);
                    }
                }
                // Check for straight dashes
                else if (Greenfoot.isKeyDown("w")) {
                    // Dash upwards
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(0, -dashDistance)) {
                            setLocation(getX(), getY() - dashDistance);
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("a")) {
                    // Dash left
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(-dashDistance, 0)) {
                            setLocation(getX() - dashDistance, getY());
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("s")) {
                    // Dash downwards
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(0, dashDistance)) {
                            setLocation(getX(), getY() + dashDistance);
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("d")) {
                    // Dash right
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(dashDistance, 0)) {
                            setLocation(getX() + dashDistance, getY());
                        }
                        Greenfoot.delay(1);
                    }
                }
                // Default dash (up)
                else {
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(0, -dashDistance)) {
                            setLocation(getX(), getY() - dashDistance);
                        }
                        Greenfoot.delay(1);
                    }
                }
                
                
                dashCooldownCounter = dashDelay;
            }
        } else {
            
            dashCooldownCounter--;
        }
    }

    private boolean checkCollision(int xOffset, int yOffset)
    {
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        
        if (getOneObjectAtOffset(xOffset, yOffset, Assets.class) != null) {
            return true;
        }
        
        return false; 
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