import greenfoot.*;

public class BlackScreen extends Actor {
    private GreenfootImage image;
    private int fontSize = 24; 

    public BlackScreen() {
        image = new GreenfootImage(1000, 800); 
        image.setColor(Color.BLACK);
        image.fillRect(0, 0, image.getWidth(), image.getHeight());
        setImage(image);
    }

    public void animateMessage(String message) {
        image.setColor(Color.RED); 
        image.setFont(new Font("Comic Sans MS", true, false, fontSize)); // Comic Sans MS, bold
        setImage(image);

        StringBuilder currentText = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            currentText.append(message.charAt(i));
            image.clear();
            image.setColor(Color.BLACK);
            image.fillRect(0, 0, image.getWidth(), image.getHeight());
            image.setColor(Color.RED);
            image.drawString(currentText.toString(), 350 , image.getHeight() / 2); // Adjust position as needed
            setImage(image);
            Greenfoot.delay(10); 
        }
    }
}

