import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class FadeTransitionChallenge1 extends Actor
{
    private int opacity = 0;
    /**
     * Act - do whatever the FadeTransition wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
      public void FadeEffect() {
        GreenfootImage img = new GreenfootImage(940, 940); // Match world size
        img.setColor(new Color(0, 0, 0));
        img.fill();
        setImage(img);
        getImage().setTransparency(opacity);
    }

    public void act() {
        if (opacity < 255) {
            opacity += 5; // Adjust speed of fade-out
            getImage().setTransparency(opacity);
        } else {
            // Transition to the next world once fully opaque
            Greenfoot.setWorld(new Challenge1_1());
        }
    }
}
