import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class FlashCard extends World
{
    private int timer;

    /**
     * Constructor for objects of class FlashCard.
     */
    public FlashCard()
    {
        super(800, 800, 1);
        GreenfootImage background = new GreenfootImage("cd3333.png");
        setBackground(background);
        timer = 0;
        prepare();
    }

    public void act() {
        timer++;
        if (timer >= 180) {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
