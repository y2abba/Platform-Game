import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is responsible for introducing the name of the game, and beginning the story
 */
public class Welcome extends Actor
{
    private int spacePressed;
    /**
     * Act - do whatever the StoryText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        removeWelcome();
        if (this.isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    //Constructor
    
    public Welcome()
    {
        GreenfootImage text = new GreenfootImage("Welcome.PNG");
        this.setImage(text);
    }
    
    //Moves Welcome up
    public void removeWelcome()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            spacePressed += 1;
        }
        if(spacePressed >= 1)
        {
            setLocation(getX(), getY() - 3);
        }
    }
}
