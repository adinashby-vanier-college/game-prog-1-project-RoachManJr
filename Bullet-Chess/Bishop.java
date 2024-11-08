import greenfoot.*;  // Import Greenfoot classes
import java.util.Random;  // For random number generation

public class Bishop extends Actor {
    // The center of the world (400, 300) in an 800x600 world
    private int[] center = {500, 350}; 

    // The four corners of the world
    private int[][] corners = {
        {0, 0},      // Top-left corner
        {1000, 0},    // Top-right corner
        {0, 700},    // Bottom-left corner
        {1000, 700}   // Bottom-right corner
    };

    private int currentCornerIndex = 0;  // Index to keep track of which corner we are targeting
    private boolean isMoving = false;    // Flag to control if the bishop is moving
    private int[] targetPosition;        // The target position (center or a corner)
    private int moveSpeed = 3;           // Movement speed of the bishop
    private int shootCooldown = 0;       // Timer for shooting bullets

    public void act() {
        if (getWorld() == null) return;  // Early exit if not added to a world

        // Decide what to do based on whether it's time to move
        if (!isMoving) {
            if (targetPosition == null || targetPosition == center) {
                moveToNextCorner();  // Move to next corner when at the center
            } else {
                moveToCenter();  // After reaching a corner, go back to the center
            }
        }

        // Move the bishop towards its target (center or corner)
        if (isMoving) {
            moveTowardsTarget();
        }

        // When the bishop reaches the target (corner or center), do the next action
        if (reachedTarget()) {
            isMoving = false;  // Stop moving when the target is reached

            // If the bishop is at the center, go to the next corner
            if (targetPosition == center) {
                currentCornerIndex = (currentCornerIndex + 1) % corners.length;  // Move to the next corner in sequence
            }
        }

        // Shoot bullets every 20 frames (adjustable cooldown)
        shootBullets();
    }

    // Set the target position to the next corner in sequence
    private void moveToNextCorner() {
        targetPosition = corners[currentCornerIndex];  // Set the target position to the current corner
        isMoving = true;  // Start moving towards the corner
    }

    // Move the bishop back to the center after reaching a corner
    private void moveToCenter() {
        targetPosition = center;  // Set the target position to the center
        isMoving = true;  // Start moving towards the center
    }

    // Move the bishop step-by-step towards the target position (either a corner or center)
    private void moveTowardsTarget() {
        int x = getX();
        int y = getY();
        int targetX = targetPosition[0];
        int targetY = targetPosition[1];

        // Use trigonometric functions to move the Bishop diagonally
        double angle = Math.atan2(targetY - y, targetX - x);  // Angle between current position and target
        double moveX = Math.cos(angle) * moveSpeed;  // Horizontal movement
        double moveY = Math.sin(angle) * moveSpeed;  // Vertical movement

        // Update the position with the calculated movement
        setLocation(x + (int) moveX, y + (int) moveY);
    }

    // Check if the bishop has reached the target position (either a corner or the center)
    private boolean reachedTarget() {
        // The bishop is considered to have reached the target if it's within a small threshold
        return Math.abs(getX() - targetPosition[0]) <= moveSpeed && Math.abs(getY() - targetPosition[1]) <= moveSpeed;
    }

    // Shoot bullets in all four diagonal directions
    private void shootBullets() {
        shootCooldown++;  // Increment the shooting cooldown
        if (shootCooldown >= 40) {  // Shoot every 20 frames (adjustable)
            shootCooldown = 0;  // Reset cooldown

            // Create and shoot bullets in four diagonal directions
            BishopBullet bulletTL = new BishopBullet(-4, -4);  // Top-left
            getWorld().addObject(bulletTL, getX(), getY());

            BishopBullet bulletTR = new BishopBullet(4, -4);   // Top-right
            getWorld().addObject(bulletTR, getX(), getY());

            BishopBullet bulletBR = new BishopBullet(4, 4);    // Bottom-right
            getWorld().addObject(bulletBR, getX(), getY());

            BishopBullet bulletBL = new BishopBullet(-4, 4);   // Bottom-left
            getWorld().addObject(bulletBL, getX(), getY());
        }
    }
}
