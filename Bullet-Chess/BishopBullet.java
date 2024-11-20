import greenfoot.*;  // Import Greenfoot classes

public class BishopBullet extends Bishop {
    private int dx, dy;

    // Constructor to set the direction of the bullet
    public BishopBullet(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void act() {
        move(dx, dy);  // Move the bullet in the specified direction

        Assets assets = (Assets) getOneIntersectingObject(Assets.class); // Check if the bullet is at the walls
        if (assets != null) {
            getWorld().removeObject(this);
        }
    }

    // Move the bullet by dx and dy
    private void move(int dx, int dy) {
        setLocation(getX() + dx, getY() + dy);
    }
}
