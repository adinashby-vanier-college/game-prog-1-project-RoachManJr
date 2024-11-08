import greenfoot.*;  // Importing the Greenfoot package

public class RookBullet extends Rook
{
    private int speed = 4;
    private int direction;  // Direction of the bullet

    public RookBullet(int direction) {
        this.direction = direction;
    }

    public void act() {
        moveBullet();
    }

    private void moveBullet() {
        if (direction == 0) {
            move(speed);  // Right
        } else if (direction == 1) {
            setRotation(270);  // Top
            move(speed);
        } else if (direction == 2) {
            setRotation(90);   // Bottom
            move(speed);
        } else if (direction == 3) {
            move(-speed);      // Left
        }

        // Remove bullet if it goes off screen
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
