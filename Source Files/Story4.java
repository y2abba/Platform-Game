import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story4 extends Story1
{
    /**
     * Act - do whatever the Story4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveStory();
    } 
    public Story4()
    {
        GreenfootImage storyFour = new GreenfootImage("Story4.PNG");
        this.setImage(storyFour);
    }   
}
