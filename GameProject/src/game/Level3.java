
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
  and open the template in the editor. 
*/
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;


/*
 * @author kimbe
 */
public class Level3 extends GameLevel{
    private final static int  NUM_RED_KEYS = 5;
    private final static int  NUM_BLUE_KEYS = 5;
    Zombie2  zombie2;
    public Game game;

public void populate(Game game) {
        super.populate(game);
        this.game = game;

     
        
/** make the ground */
        Shape shape = new BoxShape(20f, 0.5f);
        Body ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -14.5F));

        /** set walls */
        Shape wallShape = new BoxShape(100,0);
        Body leftWall = new StaticBody(this,wallShape);
        leftWall.setPosition( new Vec2(-20,-6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(20,-6));
        leftWall.setAngleDegrees(90);
        rightWall.setAngleDegrees(90);
        
       
        /* make  platforms */
        
        //row 1
        Shape platform3Shape = new BoxShape(25f, 0.5f);
        Body platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(9.5f, -11));
        //platform3.setAngle(0.2f);
        
       //middle  
      Shape platform13Shape = new BoxShape(6, 0.5f);
       Body platform13 = new StaticBody(this, platform13Shape);
      platform13.setPosition(new Vec2(10f,-7f));
       
      
        //row 1 left        
       /* Shape platform4Shape = new BoxShape(8, 0.5f);
        Body platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(-12, -10.5f)); */
        
         //row 2 right
       /* Shape platform11Shape = new BoxShape(7f, 0.5f);
        Body platform11 = new StaticBody(this, platform11Shape);
        platform11.setPosition(new Vec2(14,-4f)); */
        
        //row 2 left
       Shape platform9Shape = new BoxShape(25, 0.5f);
       Body platform9 = new StaticBody(this, platform9Shape);
       platform9.setPosition(new Vec2(-14, -3));
      // platform9.setAngle(-0.2f);
        
       //middle  
       /*Shape platform10Shape = new BoxShape(4f, 0.5f);
       Body platform10 = new StaticBody(this, platform10Shape);
       platform10.setPosition(new Vec2(0.5f,0f));
       // platform10.setAngle(-0.2f);*/
        
       // row 3 left
        Shape platform8Shape = new BoxShape(10f, 0.5f);
        Body platform8 = new StaticBody(this, platform8Shape);
        platform8.setPosition(new Vec2(-13 ,2.5f));
        
        // row 3  right
        Shape platform12Shape = new BoxShape(10f, 0.5f);
        Body platform12= new StaticBody(this, platform12Shape);
        platform12.setPosition(new Vec2(13,2.5f));
        
    
        //row 4 left
        Shape platform5Shape = new BoxShape(5, 0.5f);
        Body platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(-15,8.5f));
        
       // row 4 right
        Shape platform6Shape = new BoxShape(5, 0.5f);
        Body platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(15,8.5f));
        
        // row 4 middle 
        Shape platform7Shape = new BoxShape(3.75f, 0.5f);
        Body platform7 = new StaticBody(this, platform7Shape);
        platform7.setPosition(new Vec2(0f,6));
        
        
        
          for (int i = 0; i < 5; i++) {
            Body RedKey = new RedKey(this);
            RedKey.setPosition(new Vec2(i*2-10, 10));
          
           
           }
          
           for (int i = 0; i < 5; i++) {
            Body BlueKey = new BlueKey(this);
            BlueKey.setPosition(new Vec2(i*2-1, 8));
            
          
           } 
            
           //Zombie 4
     zombie2 = new Zombie2(this);
     zombie2.setPosition( new Vec2(0,0));
     zombie2.addCollisionListener( new DarylHit (daryl));
     zombie2.addCollisionListener( new RickHit (rick));
     
          //Zombie 5
     zombie2 = new Zombie2(this);
     zombie2.setPosition( new Vec2(5,5));
     zombie2.addCollisionListener( new DarylHit (daryl));
     zombie2.addCollisionListener( new RickHit (rick));
     
      //Zombie 4
     zombie2 = new Zombie2(this);
     zombie2.setPosition( new Vec2(-5,5));
     zombie2.addCollisionListener( new DarylHit (daryl));
     zombie2.addCollisionListener( new RickHit (rick));
     
     //zombie 6
     zombie2 = new Zombie2(this);
     zombie2.setPosition( new Vec2(0,-10));
     zombie2.addCollisionListener( new DarylHit (daryl));
     zombie2.addCollisionListener( new RickHit (rick));
}
/** set ricks starts positions*/
    @Override
    public Vec2 startPosition() {
        return new Vec2(-8,-14);
    } 
    /** set daryls start positions*/
     public Vec2 startPositionP2() {
        return new Vec2(-11,-14);
    }
/** set doors starts positions*/
    @Override
    public Vec2 redDoorPosition() {
        return new Vec2(17.25f,10.25f);
    }
    /** set doors start positions*/
    public Vec2 blueDoorPosition() {
        return new Vec2(-17.25f,10.25f);
    }
    /** set enemy start positions*/
  //  @Override
    public Vec2 Enemy1Position() {
        return new Vec2(9,-6);
        
   }
    /** set enemy start positions*/
     public Vec2 Enemy2Position() {
        return new Vec2(13,6);
        
   }
     /**
     * set enemy starts positions
     */
      public Vec2 Enemy3Position() {
        return new Vec2(-11,-2);
        
   }
      /**
       * all red keys collected
     * @return 
       */
     public boolean redKeyCompleted() {
        return getPlayer1().getRedKeyCount() == NUM_RED_KEYS;
    }

    /**
     * all the blue keys collected
     * @return 
     */
    public boolean blueKeyCompleted() {
        return getPlayer2().getBlueKeyCount() == NUM_BLUE_KEYS;

    }

    /**
     * checking if both sets of keys are collected
     * @return 
     */
    @Override
    public boolean isCompleted() {
        return redKeyCompleted() && blueKeyCompleted();
    }
}
