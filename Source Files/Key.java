import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is one of the goals the player must touch/get. It enables him/her to win.
 */
public class Key extends Actor
{
    private Chest c;
    /**
     * Act - do whatever the Key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public Key()
    {
        GreenfootImage k = new GreenfootImage("key.png");
        setImage(k);
    }
}
