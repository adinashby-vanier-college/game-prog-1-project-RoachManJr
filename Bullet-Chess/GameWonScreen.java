import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class GameWonScreen extends World
{
    private int scrollSpeed = 2;
    private GreenfootImage bg; 
    private int textYPosition = 800; 

    /**
     * Constructor for objects of class GameWonScreen.
     */
    public GameWonScreen()
    {
        super(800, 800, 1);
        bg = new GreenfootImage(800, 800);
        setBackground(bg);

        bg.setColor(Color.BLACK);
        bg.fill();

        prepareCredits();
    }

    /**
     * Prepare the scrolling credits.
     */
    private void prepareCredits()
    {
        // Add credits in a list to render them line by line
        String[] credits = {
            "Game Title: Bullet Chess",
            "",
            "Created By:",
            "",
            "Tegran Tamrazyan - AI Programmer",
            "Ehsan Hussain - Level Designer",
            "Ravneet Singh - Combat Designer",
            "Lucas Coveyduck - UI Designer/ Transition Specialist",
            "",
            "Asset Credits go to!:",
            "brick walls - by ShadowArtist",
            "stonewallwithcolumns-tileset - by Michael Howe",
            "boomerang png - by Napoleon",
            "",
            "Special Thanks To:",
            "Chat Gpt , jk",
            "And You, the Player!",
            "",
            "Thank You for Playing!",
        };

        int startY = textYPosition; 
        int lineHeight = 40; 
        Font font = new Font("Arial", true, false, 25);
        bg.setFont(font);
        bg.setColor(Color.WHITE);

        for (String line : credits) {
            bg.drawString(line, 100, startY);
            startY += lineHeight; // Move to the next line
        }
    }

    /**
     * Scrolling credits effect.
     */
    public void act()
    {
        textYPosition -= scrollSpeed;
        bg = new GreenfootImage(800, 800);
        bg.setColor(Color.BLACK);
        bg.fill();

        prepareCredits();
        setBackground(bg);

      
        if (textYPosition + bg.getHeight() < 0) {
            Greenfoot.stop(); 
        }
    }
}