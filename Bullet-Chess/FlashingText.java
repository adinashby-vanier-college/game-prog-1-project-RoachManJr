import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class FlashingText extends Actor
{
        private int counter = 0;  // Counter to control the flashing rate
    private boolean visible = true;  // To track the visibility of the text
    
    public FlashingText(String text)
    {
        GreenfootImage img = new GreenfootImage(text, 30, Color.WHITE, new Color(0, 0, 0, 0)); // Create text image in green color
        setImage(img);  // Set the image of this actor to the created text image
    }

    public void act()
    {
        counter++;  // Increment the counter each time act() is called
        
        // Flash text every 20 frames (about 0.33 seconds if the frame rate is 60)
        if (counter % 35 == 0) {
            visible = !visible;  // Toggle visibility
            updateVisibility();
        }
    }

    private void updateVisibility()
    {
        if (visible) {
            getImage().setTransparency(255);  // Make text visible
        } else {
            getImage().setTransparency(0);    // Make text invisible
        }
    }
}
