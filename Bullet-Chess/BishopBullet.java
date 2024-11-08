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

        // Check if the bullet is at the edge of the world
        if (isAtEdge()) {
            getWorld().removeObject(this);  // Remove the bullet from the world
        }
    }

    // Move the bullet by dx and dy
    private void move(int dx, int dy) {
        setLocation(getX() + dx, getY() + dy);
    }
}
