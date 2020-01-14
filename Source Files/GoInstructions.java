import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoInstructions extends Story1
{
    /**
     * Act - do whatever the Instructions wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getY() > 650/2 + getImage().getHeight() + 30)
        {
            moveStory();
        }
        //Key shortcut
        if(Greenfoot.isKeyDown("i"))
        {
            Greenfoot.setWorld(new Instructions());
        }
    } 
    public GoInstructions()
    {
        GreenfootImage i = new GreenfootImage("i.PNG");
        this.setImage(i);
    }      
}
