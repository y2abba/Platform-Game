import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * NOTE:
 * This class and the story subclasses are all used collectively to produce the rolling text in
 * the Story world.
 */
public class Story1 extends Actor
{
    /**
     * Act - do whatever the Story1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveStory();
    }    
    
    public Story1()
    {
        GreenfootImage storyOne = new GreenfootImage("Story1.PNG");
        this.setImage(storyOne);
    }
    //Moves the story boxes at a constant rate.
    public void moveStory()
    {
        setLocation(getX(), getY() - 2);
        if (this.isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
