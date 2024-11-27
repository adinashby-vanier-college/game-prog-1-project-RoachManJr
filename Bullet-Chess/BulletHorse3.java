import greenfoot.*;

public class BulletHorse3 extends Knight
{
    private int speed = 4; //speed

    public BulletHorse3() {
        // maybe add extra stuff
    }

    public void act()
    {
        move(speed); 

        Assets assets = (Assets) getOneIntersectingObject(Assets.class); 
        if (assets != null) {
            getWorld().removeObject(this);
        }
    }

    
    public void setRotation(int direction)
    {
        super.setRotation(direction);  
    }
}