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
     private World previousWorld;
    /**
     * Constructor for objects of class GameOverScreen.
     */
    public GameOverScreen(Player player, World previousWorld)
    {
        super(800, 800, 1);
        showTextWithBigRedFont("Game Over", 180, 200);
        
        this.player = player;  // Pass the player reference
        this.previousWorld = previousWorld;
        
         // Add Respawn Button
        Button respawnButton = new Button("Respawn at Checkpoint");
        addObject(respawnButton, getWidth() / 2, getHeight() / 2);
        
        // Add Go Back to Title Button
        Button titleButton = new Button("Go to Title Screen");
        addObject(titleButton, getWidth() / 2, getHeight() / 2 + 50);
    }
    
    public void act()
    {
        // Check if respawn button is clicked
        if (Greenfoot.mouseClicked(getObjects(Button.class).get(0)))
        {
            player.respawn();  // Respawn the player at the checkpoint
            Greenfoot.setWorld(previousWorld);  // Switch to the game world
        }
        
        // Check if title button is clicked
        if (Greenfoot.mouseClicked(getObjects(Button.class).get(1)))
        {
            Greenfoot.setWorld(new TitleScreen());  // Switch to the title screen
        }
    }
    /**
     * 
     */
    public void showTextWithBigRedFont(String message, int x, int y)
    {
        GreenfootImage bg = getBackground();
        Font font =  new  Font(50);
        bg.setFont(font);
        bg.setColor(Color.RED);
        bg.drawString(message, x, y);
    }
}
