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
    private int health;
    private boolean canShoot = true;
    private int cooldownTime = 60;
    private int delayCounter = 0;
    private boolean canTripleShot = true;
    private int tripleShotCooldownTime = 120;
    private int tripleShotCooldownCounter = 0;
    private boolean canShootBoo = true;
    private int booCooldownTime = 60;
    private int delayBooCounter = 0;
    private Heart[] hearts;
     private int hitCooldown;  // Timer for invincibility after being hit
    private static final int INVINCIBILITY_TIME = 60;  // Cooldown time (in frames, 60 frames = 1 second)
    private boolean invincible;  // Whether the player is currently invincible
     private int flashTimer;  // Timer for controlling the flashing effect
     private int checkpointX;  // X position of the last checkpoint
    private int checkpointY;  // Y position of the last checkpoint
    public Player()
    {
        health = 3;
        hearts = new Heart[3];
        hitCooldown = 0;  // Start with no cooldown
        invincible = false;  // Player is not invincible initially
        flashTimer = 0;
    }

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
        actBoomerang();
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
         // Ensure the player is in the world before attempting to position hearts
        if (getWorld() != null)
        {
            if (hearts[0] == null) {
                // Create the hearts and add them to the world once the player is in the world
                for (int i = 0; i < 3; i++) {
                    hearts[i] = new Heart(true); // Start with all full hearts
                    getWorld().addObject(hearts[i], 30, getWorld().getHeight() - 130 + i * 50);  // Position them in the bottom left
                }
            }
        }
        displayHealth();  // Update the health display
        if (isTouching(Checkpoint.class)) {
                setCheckpoint();  // Call the setCheckpoint method when the player touches the checkpoint
            }
        checkForDamage();
        if (invincible)
            {
                hitCooldown--;
                if (hitCooldown <= 0) {
                    invincible = false;  // End invincibility when the timer reaches 0
                }
                flash();
            }
            else
            {
                GreenfootImage img = getImage();
                img.setTransparency(255);  // Reset transparency to fully opaque
                setImage(img);
            }
        if (health <= 0) {
            death();
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

    public void actBoomerang()
    {
        handleBoomerang();
        boomerangCooldown();
    }
    
    /**
     * 
     */
    private void handleBoomerang()
    {
        if (canShootBoo && Greenfoot.isKeyDown("2")) {
            fireBoomerang();
            canShootBoo = false;
        }
    }
    
    /**
     * 
     */
    private void fireBoomerang()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            int playerX = getX();
            int playerY = getY();
            int angle = (int)Math.toDegrees(Math.atan2(mouseY - playerY, mouseX - playerX));
            World world = getWorld();
            BoomerangShot boomerangShot =  new  BoomerangShot(getX(), getY(), angle, 8);
            world.addObject(boomerangShot, playerX, playerY);
            boomerangShot.setRotation(angle);
        }
    }
    
    /**
     * 
     */
    private void boomerangCooldown()
    {
        if ( ! canShootBoo) {
            delayBooCounter = delayBooCounter + 1;
            if (delayBooCounter >= booCooldownTime) {
                canShootBoo = true;
                delayBooCounter = 0;
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
    
    public void takeDamage(int damage){
        if (invincible) return;  // Prevent taking damage if invincible
        
        health -= damage;
        if (health < 0) health = 0;  // Prevent health from going below 0
        
        invincible = true;  // Start the invincibility period
        hitCooldown = INVINCIBILITY_TIME;  // Set the cooldown timer (adjustable duration)
        
        flashTimer = 0;
    }
    
    public void heal(int amount){
        health += amount;
        if (health > 3) health = 3;
    }
    
    public boolean isDead()
    {
        return health <= 0;
    }
    
    public void displayHealth()
    {
         for (int i = 0; i < 3; i++)
        {
            if (i < health)
            {
                hearts[i].updateHeart(true);  // Full heart
            }
            else
            {
                hearts[i].updateHeart(false);  // Empty heart
            }
        }
    }
    public int getHealth()
    {
        return health;
    }
    public void checkForDamage()
    {
        // Only check for damage if the player is not invincible
        if (!invincible)
        {
            // Check if the player is touching any object that deals damage
            Actor npcs = getOneIntersectingObject(NPCs.class);  // Change Enemy.class to the class of your damage-dealing actor
            if (npcs != null) {
                takeDamage(1);  // Take 1 point of damage (you can change this value)
            }
        }
    }
    public void flash()
    {
        flashTimer++;
        int alpha = 255;  // Default (fully opaque)

        // Create a simple flashing effect by alternating transparency
        if (flashTimer % 10 < 5) {
            alpha = 100;  // Make the player semi-transparent (flashing effect)
        }

        // Apply the alpha transparency to the player's image
        GreenfootImage img = getImage();
        img.setTransparency(alpha);  // Set the transparency (0 = fully transparent, 255 = fully opaque)
        setImage(img);  // Apply the modified image
    }
    public void death()
    {
        // Add your death logic here
        
        // For example:
        // - Play a death sound
        // - Remove the player from the world
        Greenfoot.playSound("Bottle Break.wav");  // You can add a death sound file here
        getWorld().removeObject(this);  // Remove the player from the world
        
        // Optionally, show a "Game Over" message, or reset the game
        Greenfoot.setWorld(new GameOverScreen(this, getWorld()));
    }
    public void setCheckpoint()
    {
        checkpointX = getX();  // Save current X position
        checkpointY = getY();  // Save current Y position
    }
    // Respawn the player at the checkpoint position and reset health
    public void respawn()
    {
        setLocation(checkpointX, checkpointY);  // Move the player to the checkpoint
        health = 3;  // Reset health to maximum (3 hearts)
        displayHealth();  // Update health display
    }
}