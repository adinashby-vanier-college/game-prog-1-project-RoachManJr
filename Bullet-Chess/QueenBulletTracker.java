import greenfoot.*;

/**
 * Bullet class that moves in a specific direction.
 */
public class QueenBulletTracker extends QueenPhase2
{
    private float speed;
    private double angle;

    /**
     * Bullet constructor
     */
    public QueenBulletTracker(int x, int y, double angle, float speed)
    {
        setLocation(x, y);
        this.angle = angle;
        this.speed = speed;
    }

    /**
     * Act method to move the bullet in the given direction.
     */
    public void act()
    {
        // Calculate the movement in the x and y directions using the angle
        int dx = (int) (speed * Math.cos(angle));
        int dy = (int) (speed * Math.sin(angle));

        // Move the bullet
        setLocation(getX() + dx, getY() + dy);
        
        Assets assets = (Assets) getOneIntersectingObject(Assets.class); 

        // If the bullet is outside the world, remove it
        if (assets != null) {
            getWorld().removeObject(this);
        }
    }
}
