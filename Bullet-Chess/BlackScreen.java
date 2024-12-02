import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class BlackScreen extends Actor
{
    private GreenfootImage image;

    public BlackScreen(String message) {
        // Set up the dimensions for the black screen
        int screenWidth = 1000; // Adjust width as needed
        int screenHeight = 800; // Adjust height as needed

        // Create the background
        image = new GreenfootImage(screenWidth, screenHeight);
        image.setColor(Color.BLACK);
        image.fillRect(0, 0, screenWidth, screenHeight);

        // Set text properties
        image.setColor(Color.RED);
        image.setFont(new Font("Comic Sans MS", false, false, 30)); // Set font (bold, not italic, size 30)

        // Get the text size indirectly
        GreenfootImage temp = new GreenfootImage(message, 30, Color.RED, null);
        int textWidth = temp.getWidth();
        int textHeight = temp.getHeight();

        // Calculate text position
        int x = (screenWidth - textWidth) / 2;
        int y = (screenHeight - textHeight) / 2;

        // Draw the text on the black screen
        image.drawImage(temp, x, y);

        setImage(image);
    }
}
