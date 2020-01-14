import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is responsible for a) beginning the story, then b) skipping the story
 * and starting the game.
 */
public class StartAndSkipStory extends Actor
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Change to skip story and move to bottom left, exists only when StartGame object does not.
        if(Greenfoot.isKeyDown("space"))
        {
            GreenfootImage skipStory = new GreenfootImage("SkipStory.PNG");
            this.setImage(skipStory);
            this.setLocation(980-90, 700-20);
        }
    }
    //Constructor
    public StartAndSkipStory()
    {
        //Images
        GreenfootImage startStory = new GreenfootImage("StartStory.PNG");
        //Story Start
        this.setImage(startStory);
    }
}
