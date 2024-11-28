import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
   private String label;  // The label of the button
    
    public Button(String label)
    {
        this.label = label;
        updateImage();
    }
    
    // Method to update the button's image with the label text
    private void updateImage()
    {
        GreenfootImage img = new GreenfootImage(label, 24, Color.WHITE, new Color(0, 0, 0, 128));
        setImage(img);
    }
    
    // Check if the button is clicked
    public boolean isClicked()
    {
        return Greenfoot.mouseClicked(this);
    }
}
