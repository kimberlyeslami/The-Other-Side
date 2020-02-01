/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

import org.jbox2d.common.Vec2;

/**
 *
 * @author kimbe
 */
public class Level1 extends GameLevel {

    private final static int NUM_RED_KEYS = 3;
    private final static int NUM_BLUE_KEYS = 3;
    public Game game;

    public void populate(Game game) {
        super.populate(game);
        this.game = game;

        /**
         * make the ground
         */
        Shape shape = new BoxShape(20f, 0.5f);
        Body ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -14.5F));

        /**
         * set walls
         */
        Shape wallShape = new BoxShape(100, 0);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-20, -6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(20, -6));
        leftWall.setAngleDegrees(90);
        rightWall.setAngleDegrees(90);

        /**
         * make platforms and keys
         */
        //row 1  right
        Shape platform3Shape = new BoxShape(8f, 0.5f);
        Body platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(11.5f, -11));
        //platform3.setAngle(0.2f);

        //middle  
        Shape platform13Shape = new BoxShape(4, 0.5f);
        Body platform13 = new StaticBody(this, platform13Shape);
        platform13.setPosition(new Vec2(0f, -6.5f));

        //row 1 left        
        Shape platform4Shape = new BoxShape(8, 0.5f);
        Body platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(-12, -10.5f));

        //row 2 right
        Shape platform11Shape = new BoxShape(7f, 0.5f);
        Body platform11 = new StaticBody(this, platform11Shape);
        platform11.setPosition(new Vec2(14, -4f));

        //row 2 left
        Shape platform9Shape = new BoxShape(7, 0.5f);
        Body platform9 = new StaticBody(this, platform9Shape);
        platform9.setPosition(new Vec2(-14, -3));
        // platform9.setAngle(-0.2f);

        //middle  
        Shape platform10Shape = new BoxShape(4f, 0.5f);
        Body platform10 = new StaticBody(this, platform10Shape);
        platform10.setPosition(new Vec2(0.5f, 0f));
        // platform10.setAngle(-0.2f);

        // row 3 left
        Shape platform8Shape = new BoxShape(6.5f, 0.5f);
        Body platform8 = new StaticBody(this, platform8Shape);
        platform8.setPosition(new Vec2(-14, 3f));

        // row 3  right
        Shape platform12Shape = new BoxShape(6.5f, 0.5f);
        Body platform12 = new StaticBody(this, platform12Shape);
        platform12.setPosition(new Vec2(14, 3f));

        //row 4 left
        Shape platform5Shape = new BoxShape(4, 0.5f);
        Body platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(-14, 8.5f));

        // row 4 right
        Shape platform6Shape = new BoxShape(4, 0.5f);
        Body platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(14, 8.5f));

        // row 4 middle 
        Shape platform7Shape = new BoxShape(3.75f, 0.5f);
        Body platform7 = new StaticBody(this, platform7Shape);
        platform7.setPosition(new Vec2(0f, 6));

        for (int i = 0; i < 3; i++) {
            Body RedKey = new RedKey(this);
            RedKey.setPosition(new Vec2(i * 2 - 0, 0));

        }

        for (int i = 0; i < 3; i++) {
            Body BlueKey = new BlueKey(this);
            BlueKey.setPosition(new Vec2(i * 2 - 1, 8));

        }

    }

    /**
     * set start positions
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-8, -14);
    }

    /**
     * set door starts positions
     */
    public Vec2 startPositionP2() {
        return new Vec2(-11, -14);
    }

    @Override
    public Vec2 redDoorPosition() {
        return new Vec2(17.25f, 10.25f);
    }

    /**
     * set door starts positions
     */
    public Vec2 blueDoorPosition() {
        return new Vec2(-17.25f, 10.25f);
    }
    //  @Override

    /**
     * set enemy starts positions
     */
    public Vec2 Enemy1Position() {
        return new Vec2(9, -6);

    }

    /**
     * set enemy starts positions
     */
    public Vec2 Enemy2Position() {
        return new Vec2(13, 6);

    }

    /**
     * set enemy starts positions
     */
    public Vec2 Enemy3Position() {
        return new Vec2(-11, -2);

    }

    /**
     * all the red keys collected
     */
    public boolean redKeyCompleted() {
        return getPlayer1().getRedKeyCount() == NUM_RED_KEYS;
    }

    /**
     * all the blue keys collected
     */
    public boolean blueKeyCompleted() {
        return getPlayer2().getBlueKeyCount() == NUM_BLUE_KEYS;

    }

    @Override
    public boolean isCompleted() {
        return redKeyCompleted() && blueKeyCompleted();
    }

}
