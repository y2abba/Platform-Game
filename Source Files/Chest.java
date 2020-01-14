import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chest extends Actor
{
   /**
    * Act - do whatever the door wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
   public void act() 
   {
       //Will only open if all keys have been captured.
       if(getWorld().getObjects(Key.class).isEmpty())
       {
           open();
       }
   }   
   public Chest()
   {
        GreenfootImage cc = new GreenfootImage("ClosedChest.png");
        setImage(cc);
   }
   //Executed when player intersects chest in player class.
   public void open()
   {
       GreenfootImage co = new GreenfootImage("OpenedChest.png");
       setImage(co);
   } 
}
