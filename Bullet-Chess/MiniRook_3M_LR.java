import greenfoot.*;

public class MiniRook_3M_LR extends Rook
{
    private int targetX, targetY;
    private int speed = 2;  
    int shooting = 40;
    int cooldownShooting = -10;
    int direction = 0;
    
    private int health = 6; 
    private HealthBar healthBar;
        public MiniRook_3M_LR() {
        targetX = 830;
        targetY = 840;
        healthBar = new HealthBar(6);
        healthBar.setOwner(this); 
    }

    public void addedToWorld(World world)
    {
        world.addObject(healthBar, getX(), getY() - 30);
    }

    public void act()
    {
        if (health <= 0) {
            removeSelf();
            return;
        }

        moveToTarget();
        updateHealthBar();

        if (atTarget()) {
            moveToRandomHorizontal();
        }

        handleShooting();
        checkForProjectileCollision();
    }

        private void updateHealthBar() {
        if (healthBar.getWorld() != null) {
            healthBar.setLocation(getX(), getY() - 30); 
        }
    }

    private void removeSelf()
    {
        if (healthBar.getWorld() != null) {
            getWorld().removeObject(healthBar);
        }
        getWorld().removeObject(this);
    }

    private void handleShooting()
    {
        if (cooldownShooting <= 0) {
            shoot();
            cooldownShooting = shooting;
        }
        if (cooldownShooting > 0) {
            cooldownShooting--;
        }
    }

    private void moveToTarget()
    {
        int currentX = getX();
        int currentY = getY();

        if (currentX < targetX)
            setLocation(currentX + speed, currentY);
        else if (currentX > targetX)
            setLocation(currentX - speed, currentY);

        if (currentY < targetY)
            setLocation(currentX, currentY + speed);
        else if (currentY > targetY)
            setLocation(currentX, currentY - speed);
    }

    private boolean atTarget()
    {
        return (Math.abs(getX() - targetX) <= speed) && (Math.abs(getY() - targetY) <= speed);
    }

    private void moveToRandomHorizontal()
    {
        int worldWidth = getWorld().getWidth();
        int worldHeight = getWorld().getHeight();

        if (worldWidth > 0 && worldHeight > 0)
        {
            if (direction > 3) {
                direction = 0;
            }
            switch (direction)
            {
                case 0:  
                    targetX = 102;
                    targetY = 190;
                    direction++;
                    break;
                case 1:  
                    targetX = 830;
                    targetY = 190;
                    direction++;
                    break;
                case 2:  
                    targetX = 102;
                    targetY = 840;
                    direction++;
                    break;
                case 3:  
                    targetX = 830;
                    targetY = 840;
                    direction++;
                    break;
            }
        }
        else
        {
            targetX = getWorld().getWidth() / 2;
            targetY = getWorld().getHeight() / 2;
        }
    }

    private void shoot()
    {
        RookBullet rightBullet = new RookBullet(0);
        RookBullet topBullet = new RookBullet(1);
        RookBullet bottomBullet = new RookBullet(2);
        RookBullet leftBullet = new RookBullet(3);

        getWorld().addObject(rightBullet, getX(), getY());
        getWorld().addObject(topBullet, getX(), getY());
        getWorld().addObject(bottomBullet, getX(), getY());
        getWorld().addObject(leftBullet, getX(), getY());
    }

    private void checkForProjectileCollision()
    {
        if (isTouching(projectile.class)) {
            health -= 1;
            healthBar.decreaseHealth(1); 
            removeTouching(projectile.class);
        }
        if (isTouching(AOE.class)) {
            health -= 1;
            healthBar.decreaseHealth(1); 
            removeTouching(AOE.class);
        }
        if (isTouching(BoomerangShot.class)) {
            health -= 3;
            healthBar.decreaseHealth(3); 
            removeTouching(BoomerangShot.class);
        }
        if (isTouching(ReturningBoomerangShot.class)) {
            health -= 3;
            healthBar.decreaseHealth(3); 
            removeTouching(ReturningBoomerangShot.class);
        }
        if (isTouching(TripleShotProjectile.class)) {
            health -= 1;
            healthBar.decreaseHealth(1); 
            removeTouching(TripleShotProjectile.class);
        }
    }
}


