import greenfoot.*;

public class QueenBulletRandom extends QueenPhase2
{
    private int speed = 4; //speed

    public QueenBulletRandom() {
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
