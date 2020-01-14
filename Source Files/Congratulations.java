import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Congratulations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Congratulations extends World
{
    /**
     * Act - do whatever the Congratulations wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Plays music for winning!
        Greenfoot.playSound("Congrats.wav");
        //Key shortcuts
        if(Greenfoot.isKeyDown("m"))
        {
            Greenfoot.setWorld(new Menu());
        }
        if(Greenfoot.isKeyDown("e"))
        {
            Greenfoot.stop();
        }
    }    
    
    public Congratulations()
    {
        super(980, 700, 1); 
        
        GreenfootImage c = new GreenfootImage("Congratulations.PNG");
        setBackground(c);
    }
}
