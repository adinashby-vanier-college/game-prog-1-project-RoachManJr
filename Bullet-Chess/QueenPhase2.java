import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * Represents the second phase of the Queen in the game.
 */
public class QueenPhase2 extends Queen
{
    private boolean isDead = false; // Flag to track if the Queen is dead

    /**
     * Act - do whatever the QueenPhase2 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkHealth(); // Check if the Queen has died
    }

    /**
     * Checks the health of the Queen and transitions to GameWonScreen if health is 0.
     */
    private void checkHealth()
    {
        if (!isDead && getHealth() <= 0) // Assuming `getHealth()` is a method in the `Queen` class
        {
            isDead = true; // Mark the Queen as dead to prevent multiple triggers
            transitionToGameWonScreen();
        }
    }

    /**
     * Handles the transition to the GameWonScreen.
     */
    private void transitionToGameWonScreen()
    {
        Greenfoot.setWorld(new GameWonScreen()); // Assuming GameWonScreen is a World subclass
    }

    /**
     * Placeholder for getting health. Replace this with actual health logic from the `Queen` class.
     */
    public int getHealth()
    {
        // Replace this with the actual implementation to retrieve the Queen's health
        return 0; // Example: Queen is dead
    }
}
