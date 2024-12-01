import greenfoot.*;

public class King extends Queen {
    private Player target; 
    private int speed; 
    public King(Player player) {
        this.target = player;
        this.speed = 1; 
    }

    public void act() {
        followPlayer();
    }

    private void followPlayer() {
        if (target == null || getWorld() == null) {
            return; 
        }
        int kingX = getX();
        int kingY = getY();
        int playerX = target.getX();
        int playerY = target.getY();

        int dx = playerX - kingX;
        int dy = playerY - kingY;

        double distance = Math.sqrt(dx * dx + dy * dy);
        if (distance > 0) {
            int moveX = (int) Math.round(speed * dx / distance);
            int moveY = (int) Math.round(speed * dy / distance);
            setLocation(kingX + moveX, kingY + moveY);
        }
    }
}
