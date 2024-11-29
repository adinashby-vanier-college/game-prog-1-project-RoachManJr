import greenfoot.*;

/**
 * Bullet class that moves in a specific direction.
 */
public class ReturningBoomerangShot extends Player
{
    private float speed;
    private double angle;
    GifImage Spin = new GifImage("bullet006.gif");

    /**
     * Bullet constructor
     */
    public ReturningBoomerangShot(int x, int y, double angle, float speed)
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
        setImage(Spin.getCurrentImage());
        returnToSender();
    }
    
    /**
     * Act method to move the bullet in the given direction.
     */
    public void returnToSender()
    {
        // Calculate the movement in the x and y directions using the angle
        int dx = (int) (speed * Math.cos(angle));
        int dy = (int) (speed * Math.sin(angle));

        // Move the bullet
        setLocation(getX() + dx, getY() + dy);
        
        Assets assets = (Assets) getOneIntersectingObject(Assets.class); 
        Player player = (Player) getOneIntersectingObject(Player.class);

        // If the bullet is outside the world, remove it
        if (assets != null || player != null) {
            getWorld().removeObject(this);
        }
    }
}
