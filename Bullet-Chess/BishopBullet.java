import greenfoot.*;  

public class BishopBullet extends Bishop {
    private int dx, dy;

    
    public BishopBullet(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void act() {
        move(dx, dy);  

        Assets assets = (Assets) getOneIntersectingObject(Assets.class); 
        if (assets != null) {
            getWorld().removeObject(this);
        }
    }

    
    private void move(int dx, int dy) {
        setLocation(getX() + dx, getY() + dy);
    }
}
