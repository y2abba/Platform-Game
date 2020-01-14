import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story5 extends Story1
{
    /**
     * Act - do whatever the Story5 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveStory();
    } 
    public Story5()
    {
        GreenfootImage storyFive = new GreenfootImage("Story5.PNG");
        this.setImage(storyFive);
    }   
}
