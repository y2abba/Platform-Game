import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story extends World
{
    private int counter = 0;
    public void act()
    {
        if(getObjects(Welcome.class).isEmpty())
        {
            counter++;
        }
        if(("s".equals(Greenfoot.getKey())) && !getObjects(StartAndSkipStory.class).isEmpty())
        {
            Greenfoot.setWorld(new Instructions());
        }
        if(counter == 40)
        {
            addObject(new Story1(), 980/2, 700);
        }
        if(counter == 80)
        {
            addObject(new Story2(), 980/2, 700);
        }
        if(counter == 200)
        {
            addObject(new Story3(), 980/2, 700);
        }
        if(counter == 280)
        {
            addObject(new Story4(), 980/2, 700);
        }
        if(counter == 320)
        {
            addObject(new Story5(), 980/2, 700);
        }
        if(counter == 440)
        {
            addObject(new Story6(), 980/2, 700);
        }
        if(counter == 480)
        {
            addObject(new Story7(), 980/2, 700);
        }
        if(counter == 520)
        {
            addObject(new Story8(), 980/2, 700);
        }
        if(counter == 620)
        {
            addObject(new Story9(), 980/2, 700);
        }
        if(counter == 660)
        {
            addObject(new Story10(), 980/2, 700);
        }
        
        /**StartGame() and GoInstructions() are added so that you are able to move from
        * to the instructions or start the actual game.
        */
        if(counter == 800)
        {
            addObject(new StartGame(), 980/2, 700);
            removeObjects(getObjects(StartAndSkipStory.class));
        }
        if(counter == 860)
        {
            addObject(new GoInstructions(), 980/2, 700);
        }
        
    }

    /**
     * Constructor for objects of class Story.
     * 
     */
    public Story()
    {    
        // Create a new world with 980x700 cells with a cell size of 1x1 pixels.
        super(980, 700, 1); 
        
        GreenfootImage storyBackground = new GreenfootImage("StoryBackground.png");
        setBackground(storyBackground);
        
        addObject(new Welcome(), 980/2, 700/2);
        addObject(new StartAndSkipStory(), 980/2, 700/2 + 200);
    }
    
}
