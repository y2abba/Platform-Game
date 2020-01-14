import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story11 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends Story1
{
    /**
     * Act - do whatever the Story11 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getY() > 650/2)
        {
            moveStory();
        }
        //Key shortcut
        if(Greenfoot.isKeyDown("s"))
        {
            Greenfoot.setWorld(new WorldOne());
        }
    } 
    public StartGame()
    {
        GreenfootImage s = new GreenfootImage("StartGame.PNG");
        this.setImage(s);
    }    
}
