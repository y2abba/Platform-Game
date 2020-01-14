import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Mover
{
    //Allows the player to jump
    private boolean jumper = true;
    //Initial vertical speed is 0
    private double vSpeed = 0;
    //Decides acceleration due to gravity
    private double acceleration = 0.2;
    //Decides horizontal speed
    private double hSpeed = 2;
    //Decides strength of jump
    private int jumpStrength = -6;
    //Declare the images needed to animate the player moving right or left.
    GreenfootImage[] rightMove = new GreenfootImage[4];
    GreenfootImage[] leftMove = new GreenfootImage[4];
    //Required to enable animation movement.
    private int imageNumber;
    //Gets an act counter; primarily used for animating in this class.
    private int counter = 0;
    //Gun delay variables
    private int gunDelay = 0;
    //Ammo
    private int ammo = 30;
    //Changes angle of rotation if shooting
    private int rotate = 0;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //General counter needed for movement and firing shots.
        counter++;
        //Following variable gun delay determines how often player can shoot, ticks down.
        gunDelay--;
        //Checks to see if any blocks are in the player's way, prevents him/her from going into blocks.
        checkAround();
        //Left, right and up movement relies on keys
        checkKeys();
        //Checks to see if the player should fall or not.
        checkFall();
        //Allows the player to go up the ladder
        goUpLadder();
        //Allows the player to win the game, he/her needs to capture the keys, and then can only get the chest.
        chestAndKey();
        //Checking to see if the player has intersected any objects resulting in his/her death.
        checkDeath();
    }  
    public Player()
    {
       for(int i = 0; i < leftMove.length; i++)
       {
           leftMove[i] = new GreenfootImage( "leftMove" + (i) + ".png");
           setImage(leftMove[imageNumber]);
       }
       for(int i = 0; i < rightMove.length; i++)
       {
           rightMove[i] = new GreenfootImage( "rightMove" + (i) + ".png");
           setImage(rightMove[imageNumber]);
       }
    }  
    
    //Checking keys pressed down in order to execute methods.
    public void checkKeys()
    {
        jump();
        moveRight();
        moveLeft();
        shoot();
    }
    
    //Prevents player from getting into walls.
    public void checkAround()
    {
        checkRight();
        checkLeft();
        checkAbove();
    }
    
    //Combines the two methods to produce the goal of the player.
    public void chestAndKey()
    {
        keyCheck();
        openChest();
    }
    
    //Makes player move right
    private void moveRight()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + (int) hSpeed, getY());
            if(counter % 3 == 0)
            {
                rightAnimation();
            }
            rotate = 0;
        }
    }
    
    //Makes player move left
    private void moveLeft()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - (int) hSpeed, getY());
            if(counter % 3 == 0)
            {
                leftAnimation();
            }
            rotate = 2;
        }
    }
    
    //Animation whilst moving right.
    public void rightAnimation()
    {
        imageNumber = (imageNumber + 3) % rightMove.length;
        setImage(rightMove[imageNumber]);
    }
    
    //Animation whilst moving left.
    public void leftAnimation()
    {
        imageNumber = (imageNumber + 3) % leftMove.length;
        setImage(leftMove[imageNumber]);
    }
    
    //Makes player jump
    private void jump()
    {
        if(Greenfoot.isKeyDown("w") && jumper == true)
        {
            vSpeed = jumpStrength;
            fall();
            jumper = false;
        }
    }
    
    //Check to see if the player is on the ground or not, if no, then fall.
    public void checkFall()
    {
        //onGround defined later on.
        if(onGround())
        {
            vSpeed = 0;
        }
        //fall is defined later on.
        else fall();
    }
    
    //Makes the player fall.
    public void fall()
    {
        setLocation(getX(), getY() + (int) vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    
    //Check to see if the player is on the ground
    public boolean onGround()
    {
        int playerH = getImage().getHeight();
        int findGround = (int) (playerH/2 + 5);
        Actor Ground = getOneObjectAtOffset(0, findGround, Block.class);
        
        if(Ground != null)
        {
            //goToGround is defined later on
            vSpeed = 0;
            goToGround(Ground);
            jumper = true;
            return true;
        }
        else return false;
    }
    
    //Makes the player go to the top of the ground
    public void goToGround(Actor Ground)
    {
        int groundHeight = Ground.getImage().getHeight();
        int playerH = getImage().getHeight();
        int newY = Ground.getY() - groundHeight;
        setLocation(getX(), newY);
    }
    
    //Check to see if there is a platform above the player
    public boolean checkAbove()
    {
        int playerH = getImage().getHeight();
        int findPlatform = (int) (playerH/-2 + 3);
        Actor Platform = getOneObjectAtOffset(0, findPlatform, Block.class);
        
        if(Platform != null)
        {
            vSpeed = 0;
            hitHead(Platform);
            return true;
        }
        else return false;
    }
    
    //Hit head on the platform above
    public void hitHead(Actor Platform)
    {
        int platformHeight = Platform.getImage().getHeight();
        int newY = Platform.getY() + platformHeight + 2;
        setLocation(getX(), newY);
    }
    
    //Checking to see if player is in a wall to his right.
    public boolean checkRight()
    {
        int playerW = getImage().getWidth();
        int findRight = (int) (playerW/2 - 3);
        Actor rightBlock = getOneObjectAtOffset(findRight, 0, Block.class);
        
        if(rightBlock != null)
        {
            stopRightThere(rightBlock);
            return true;
        }
        else return false;
    }
    
    //Checking to see if player is in a wall to his left.
    public boolean checkLeft()
    {
        int playerW = getImage().getWidth();
        int findLeft = (int) (playerW/-2 + 2);
        Actor leftBlock = getOneObjectAtOffset(findLeft, 0, Block.class);
        
        if(leftBlock != null)
        {
            stopLeftThere(leftBlock);
            return true;
        }
        else return false;
    }
    
    //Prevents player from entering a wall on his right.
    public void stopRightThere(Actor rightBlock)
    {
        int rightBlockWidth = rightBlock.getImage().getWidth();
        int playerW = getImage().getWidth();
        int newX = rightBlock.getX() - (rightBlockWidth + 15) + playerW/2;
        setLocation(newX, getY());
    }
    
    //Prevents player from entering a wall on his left.
    public void stopLeftThere(Actor leftBlock)
    {
        int leftBlockWidth = leftBlock.getImage().getWidth();
        int playerW = getImage().getWidth();
        int newX = leftBlock.getX() + (leftBlockWidth + 11) - playerW/2;
        setLocation(newX, getY());
    }
    //Go up the ladder
    private void goUpLadder()
    {
        if(isTouching(Ladder.class))
        {
            if(Greenfoot.isKeyDown("w"))
            {
                setLocation(getX(), getY() - 5);
            }
        }
    }
    //Player's shoot ability.
    public void shoot()
    {
        if (Greenfoot.isKeyDown("space") && ammo > 0 && gunDelay <= 20)
        {
            PlayerProjectile s = new PlayerProjectile();
            Greenfoot.playSound("pew.wav");
            if(rotate == 0)
            {
                s.setRotation(90*rotate);
                getWorld().addObject(s , getX() + 10, getY() - 4);
            }
            else
            {
                s.setRotation(90*rotate);
                getWorld().addObject(s, getX() - 10, getY() - 4);     
            }
            ammo--;
            useAmmo();
            gunDelay = 40;
        }
    }
    
    //Uses ammo, 1 per shot.
    public void useAmmo() 
    {
         if (getWorld() instanceof WorldOne)
        {
           WorldOne world1 = (WorldOne) getWorld();
           Counter c = world1.getCounter();
           c.loseAmmo();
        }
        else if (getWorld() instanceof WorldTwo)
        {
           WorldTwo world1 = (WorldTwo) getWorld();
           Counter c = world1.getCounter();
           c.loseAmmo();
        }
        else if (getWorld() instanceof WorldThree)
        {
           WorldThree world1 = (WorldThree) getWorld();
           Counter c = world1.getCounter();
           c.loseAmmo();
        }
    }
    
    //Check if player is killed
    public void checkDeath() // checks if player died
    {
        Actor L = getOneIntersectingObject(Lava.class);
        Actor LT = getOneIntersectingObject(LavaTop.class);
        Actor EP = getOneIntersectingObject(EnemyProjectile.class);
        Actor E = getOneIntersectingObject(MovingEnemy.class);
        if (L!= null || LT!= null || EP!= null || E != null)
        {
            getWorld().addObject(new GameOver(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.playSound("rip.wav");
            getWorld().removeObject(this);
        }
    }
    
    //Checks to see if key(s) has been obtained, if so, the chest will open in the Chest class.
    public void keyCheck() 
    {
        Key y = (Key)getOneIntersectingObject(Key.class);
        if (y!=null) 
        {
            getWorld().removeObject(y);
        }
    }
    
    //Enables player to touch chest.
    public void openChest()
    {
        Chest c = (Chest) getOneIntersectingObject(Chest.class);
        if(c != null && getWorld() instanceof WorldOne && getWorld().getObjects(Key.class).isEmpty())
        {
            Greenfoot.setWorld(new WorldTwo());
        }
        if(c != null && getWorld() instanceof WorldTwo && getWorld().getObjects(Key.class).isEmpty())
        {
            Greenfoot.setWorld(new WorldThree());
        }
        if(c != null && getWorld () instanceof WorldThree && getWorld().getObjects(Key.class).isEmpty())
        {
            Greenfoot.setWorld(new Congratulations());
        }
    }
}
