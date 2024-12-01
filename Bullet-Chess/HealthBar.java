import greenfoot.*; 

public class HealthBar extends Actor
{
    private int maxHealth;
    private int health;
    private Actor owner; 

    public HealthBar(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        updateBar();
    }

    public void setOwner(Actor owner) {
        this.owner = owner;
    }

    public void updateHealth(int health) {
        this.health = health;
        updateBar();
    }

    public void decreaseHealth(int amount) {
        health -= amount;
        if (health < 0) health = 0;
        updateBar();
    }

    public void updateBar() {
        int width = 45;  
        int height = 5;  
        int healthWidth = (int) ((double) health / maxHealth * width);

        GreenfootImage healthBar = new GreenfootImage(width, height);
        healthBar.setColor(Color.RED); 
        healthBar.fill();

        healthBar.setColor(Color.GREEN); 
        healthBar.fillRect(0, 0, healthWidth, height);

        setImage(healthBar);
    }
}
