import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story3 extends Story1
{
    /**
     * Act - do whatever the Story3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveStory();
    } 
    public Story3()
    {
        GreenfootImage storyThree = new GreenfootImage("Story3.PNG");
        this.setImage(storyThree);
    }    
}
