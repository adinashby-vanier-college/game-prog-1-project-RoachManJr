import lang.stride.*;
import java.util.*;
import greenfoot.*;
import greenfoot.World;

/**
 * 
 */
public class GameOverScreen extends World
{
     private Player player;  // Reference to the player
    /**
     * Constructor for objects of class GameOverScreen.
     */
    public GameOverScreen(Player player)
    {
        super(800, 800, 1);
        showTextWithBigWhiteFont("Game Over", 270, 300);
        
        this.player = player;  // Pass the player reference
        
        // Add Go Back to Title Button
        Button titleButton = new Button("Go to Title Screen");
        addObject(titleButton, getWidth() / 2, getHeight() / 2 + 50);
    }
    
    public void act()
    {
        // Check if title button is clicked
        if (Greenfoot.mouseClicked(getObjects(Button.class).get(0)))
        {
            Greenfoot.setWorld(new TitleScreen());  // Switch to the title screen
        }
    }
    /**
     * 
     */
    public void showTextWithBigWhiteFont(String message, int x, int y)
    {
        GreenfootImage bg = getBackground();
        Font font =  new  Font(50);
        bg.setFont(font);
        bg.setColor(Color.WHITE);
        bg.drawString(message, x, y);
    }
}
