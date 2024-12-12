import lang.stride.*;
import java.util.*;
import greenfoot.*;

public class Player extends Actor
{
    
    protected int shootDelay = 20;
    protected int cooldownCounter = 0;
    
    private boolean canShoot = true;
    private int cooldownTime = 400;
    private int delayCounter = 0;
    
    private boolean canTripleShot = true;
    private int tripleShotCooldownTime = 400;
    private int tripleShotCooldownCounter = 0;
    private static boolean isTripleShotUnlocked = false;
    
    private boolean canShootBoo = true;
    private int booCooldownTime = 500;
    private int delayBooCounter = 0;
    private static boolean isBoomerangUnlocked = false;
    
    private static boolean isBombUnlocked = false;
    
    protected int dashDelay = 120;
    protected int dashCooldownCounter = 0;
    
    private int health;
    private Heart[] hearts;
    
     private int hitCooldown;  // Timer for invincibility after being hit
    private static final int INVINCIBILITY_TIME = 60;  // Cooldown time (in frames, 60 frames = 1 second)
    private boolean invincible;  // Whether the player is currently invincible
     private int flashTimer;  // Timer for controlling the flashing effect
     // Static variables for saving state
     
    private int cooldownBarBomb = 400; 
        private CooldownAbilityBarBomb cooldownAbilityBarBomb;
        
    private int cooldownBarTriple = 400; 
        private CooldownAbilityBarTriple cooldownAbilityBarTriple;
    
    private int cooldownBarBoomerang = 500; 
        private CooldownAbilityBarBoomerang cooldownAbilityBarBoomerang;
   public Player()
    {
        health = 5;
        hearts = new Heart[health];
        hitCooldown = 0;  
        invincible = false;  
        flashTimer = 0;
        
        cooldownAbilityBarBomb = new CooldownAbilityBarBomb(400);
        cooldownAbilityBarTriple = new CooldownAbilityBarTriple(400);
        cooldownAbilityBarBoomerang = new CooldownAbilityBarBoomerang(500);
    }
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
        transitionToSystemOfWorlds();
        inspectPaper();
        inspectPaper2();
        inspectPaper3();
        if (Greenfoot.mouseClicked(null) && cooldownCounter <= 0) {
            shootProjectile();
            cooldownCounter = shootDelay;
        }
        if (cooldownCounter > 0) {
            cooldownCounter = cooldownCounter - 1;
        }
        if (Greenfoot.isKeyDown("Shift") && dashCooldownCounter <= 0) {
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
                for (int i = 0; i < health; i++) {
                    hearts[i] = new Heart(true); // Start with all full hearts
                    getWorld().addObject(hearts[i], 30, getWorld().getHeight() - 250 + i * 50);  // Position them in the bottom left
                }
            }
        }
        displayHealth();  // Update the health display
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
        private void inspectPaper() {
        Actor infoPaper = getOneIntersectingObject(InfoPaperTriple.class);
        if (infoPaper != null) {
            isTripleShotUnlocked = true;
            getWorld().removeObject(infoPaper); // Remove the paper after inspecting
        }
    }
        private void inspectPaper2() {
        Actor infoPaper2 = getOneIntersectingObject(InfoPaperBomb.class);
        if (infoPaper2 != null) {
            isBombUnlocked = true;
            getWorld().removeObject(infoPaper2); // Remove the paper after inspecting
        }
        
    }
        private void inspectPaper3() {
        Actor infoPaper3 = getOneIntersectingObject(InfoPaperBoomerang.class);
        if (infoPaper3 != null) {
            isBoomerangUnlocked = true;
            getWorld().removeObject(infoPaper3); // Remove the paper after inspecting
        }
    }
    private void movePlayer()
    {
        if (Greenfoot.isKeyDown("w") && canMoveUp()) {setLocation(getX(), getY() - 4);}
        if (Greenfoot.isKeyDown("s") && canMoveDown()) {setLocation(getX(), getY() + 4);}
        if (Greenfoot.isKeyDown("a") && canMoveLeft()) {setLocation(getX() - 4, getY());}
        if (Greenfoot.isKeyDown("d") && canMoveRight()) {setLocation(getX() + 4, getY());}
    }
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
    private void dashing()
    {
        World world = getWorld();
        int dashDistance = 40;  
        int dashSpeed = 2;  
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        
        if (dashCooldownCounter <= 0) {
            if (Greenfoot.isKeyDown("Shift")) {
                
                if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a")) {
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(-dashDistance/2, -dashDistance/2)) {
                            setLocation(getX() - dashDistance/2, getY() - dashDistance/2);
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d")) {
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(dashDistance/2, -dashDistance/2)) {
                            setLocation(getX() + dashDistance/2, getY() - dashDistance/2);
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a")) {
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(-dashDistance/2, dashDistance/2)) {
                            setLocation(getX() - dashDistance/2, getY() + dashDistance/2);
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("d")) {
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(dashDistance/2, dashDistance/2)) {
                            setLocation(getX() + dashDistance/2, getY() + dashDistance/2);
                        }
                        Greenfoot.delay(1);
                    }
                }
                else if (Greenfoot.isKeyDown("w")) {
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(0, -dashDistance)) {
                            setLocation(getX(), getY() - dashDistance);
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("a")) {
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(-dashDistance, 0)) {
                            setLocation(getX() - dashDistance, getY());
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("s")) {
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(0, dashDistance)) {
                            setLocation(getX(), getY() + dashDistance);
                        }
                        Greenfoot.delay(1);
                    }
                } else if (Greenfoot.isKeyDown("d")) {
                    for (int i = 0; i < dashSpeed; i++) {
                        if (!checkCollision(dashDistance, 0)) {
                            setLocation(getX() + dashDistance, getY());
                        }
                        Greenfoot.delay(1);
                    }
                }
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
    private void handleBoomerang()
    {
        if (isBoomerangUnlocked && canShootBoo && Greenfoot.isKeyDown("x")) {
            fireBoomerang();
            canShootBoo = false;
            cooldownBarBoomerang = 500;
            
            if (cooldownAbilityBarBoomerang.getWorld() == null && getWorld() != null) {
                getWorld().addObject(cooldownAbilityBarBoomerang, 50, 120); 
            }
    
            cooldownAbilityBarBoomerang.resetCooldown();
        }
        if (cooldownBarBoomerang > 0) {
            cooldownBarBoomerang -= 1;
            cooldownAbilityBarBoomerang.decreaseCooldown(1);
        } else if (cooldownAbilityBarBoomerang.getWorld() != null) {
            getWorld().removeObject(cooldownAbilityBarBoomerang); 
        }
    }
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
    private void boomerangCooldown()
    {
        if ( ! canShootBoo) {
            delayBooCounter++;
            cooldownBarBoomerang--;
            cooldownAbilityBarBoomerang.decreaseCooldown(1);
            
            
            if (cooldownBarBoomerang <= 0) {
                canShootBoo = true;
                delayBooCounter = 0;
                if (cooldownAbilityBarBoomerang.getWorld() != null) {
                    getWorld().removeObject(cooldownAbilityBarBoomerang);
                }
            }
        }
    }
    public void performAction()
    {
        handleShooting();
        manageCooldown();
    }
    private void handleShooting()
    {
            if (isBombUnlocked && canShoot && Greenfoot.isKeyDown("v")) {
            fireProjectile();
            canShoot = false;
            cooldownBarBomb = 400; 
    
            
            if (cooldownAbilityBarBomb.getWorld() == null && getWorld() != null) {
                getWorld().addObject(cooldownAbilityBarBomb, 50, 200); 
            }
    
            cooldownAbilityBarBomb.resetCooldown();
        }
 
        if (cooldownBarBomb > 0) {
            cooldownBarBomb -= 1;
            cooldownAbilityBarBomb.decreaseCooldown(1);
        } else if (cooldownAbilityBarBomb.getWorld() != null) {
            getWorld().removeObject(cooldownAbilityBarBomb); 
        }
    }
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
    private void manageCooldown()
    {
            if (!canShoot) {
            delayCounter++;
            cooldownBarBomb--; 
            cooldownAbilityBarBomb.decreaseCooldown(1); 
            
            
            if (cooldownBarBomb <= 0) {
                canShoot = true;
                delayCounter = 0;
                if (cooldownAbilityBarBomb.getWorld() != null) {
                    getWorld().removeObject(cooldownAbilityBarBomb); 
                }
            }
        }
    }
    public void doAction()
    {
        handleTripleShot();
        manageTripleShotCooldown();
    }
    private void handleTripleShot()
    {
        if (isTripleShotUnlocked && canTripleShot && Greenfoot.isKeyDown("c")) {
            shootTripleShot();
            canTripleShot = false;
            cooldownBarTriple = 400;
            
            if (cooldownAbilityBarTriple.getWorld() == null && getWorld() != null) {
                getWorld().addObject(cooldownAbilityBarTriple, 50, 160); 
            }
    
            cooldownAbilityBarTriple.resetCooldown();
        }
        if (cooldownBarTriple > 0) {
            cooldownBarTriple -= 1;
            cooldownAbilityBarTriple.decreaseCooldown(1);
        } else if (cooldownAbilityBarTriple.getWorld() != null) {
            getWorld().removeObject(cooldownAbilityBarTriple); 
        }
    }
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
    private void manageTripleShotCooldown()
    {
        if ( ! canTripleShot) {
            tripleShotCooldownCounter++;
            cooldownBarTriple--;
            cooldownAbilityBarTriple.decreaseCooldown(1);
            
            if (cooldownBarTriple <= 0) {
                canTripleShot = true;
                tripleShotCooldownCounter = 0;
                if (cooldownAbilityBarTriple.getWorld() != null) {
                    getWorld().removeObject(cooldownAbilityBarTriple);
                }
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
        if (health > 5) health = 5;
    }
    public boolean isDead()
    {
        return health <= 0;
    }
    public void displayHealth()
    {
         for (int i = 0; i < 5; i++)
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
        Greenfoot.playSound("Bottle Break.wav"); 
        getWorld().removeObject(this);  
        
        Greenfoot.setWorld(new GameOverScreen(this));
        
        isTripleShotUnlocked = false;
        isBombUnlocked = false;
        isBoomerangUnlocked = false;
    }
    // Respawn the player at the checkpoint position and reset health
    public void respawn()
    {
        health = 5;  // Reset health to maximum (5 hearts)
        displayHealth();  // Update health display
    }
    public void transitionToSystemOfWorlds()
    {
        if (isTouching(InfoPaperTriple.class)){
            World systemOfTriple =  new  SystemOfTriple();
            Greenfoot.setWorld(systemOfTriple); 
        } else if (isTouching(InfoPaperBomb.class)){
            World systemOfBomb =  new  SystemOfBomb();
            Greenfoot.setWorld(systemOfBomb);
        } else if (isTouching(InfoPaperBoomerang.class)){
            World systemOfBoomerang =  new  SystemOfBoomerang();
            Greenfoot.setWorld(systemOfBoomerang);
        } else if (isTouching(InfoPaperDoor.class)){
            World systemOfDoor =  new  SystemOfDoor();
            Greenfoot.setWorld(systemOfDoor);
        } else if (isTouching(InfoPaperDash.class)){
            World systemOfDash =  new  SystemOfDash();
            Greenfoot.setWorld(systemOfDash);
        } else if (isTouching(InfoPaperShoot.class)){
            World systemOfShoot =  new  SystemOfShoot();
            Greenfoot.setWorld(systemOfShoot);
        }
    }
}