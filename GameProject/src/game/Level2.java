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
public class Level2 extends GameLevel {

    private final static int NUM_RED_KEYS = 4;
    private final static int NUM_BLUE_KEYS = 4;
    public Game game;
    Zombie zombie;
    Spikes spikes;

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
         * make platforms and enemies
         */
        //row 1  right
        Shape platform3Shape = new BoxShape(8f, 0.5f);
        Body platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(11.5f, -11));

        // row 1 middle  
        Shape platform13Shape = new BoxShape(4.25f, 0.5f);
        Body platform13 = new StaticBody(this, platform13Shape);
        platform13.setPosition(new Vec2(-1f, -7f));

        //row 1 left        
        Shape platform4Shape = new BoxShape(8, 0.5f);
        Body platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(-11.5f, -10.5f));

        //row 2 right
        Shape platform11Shape = new BoxShape(7f, 0.5f);
        Body platform11 = new StaticBody(this, platform11Shape);
        platform11.setPosition(new Vec2(14, -3f));
        platform11.setAngle(0.2f);

        //row 2 left
        Shape platform9Shape = new BoxShape(6, 0.5f);
        Body platform9 = new StaticBody(this, platform9Shape);
        platform9.setPosition(new Vec2(-14, -3));
        platform9.setAngle(-0.2f);

        //middle  
        Shape platform10Shape = new BoxShape(5f, 0.5f);
        Body platform10 = new StaticBody(this, platform10Shape);
        platform10.setPosition(new Vec2(-0.5f, 0.5f));
        // platform10.setAngle(0.2f);

        // row 3 left
        Shape platform8Shape = new BoxShape(6f, 0.5f);
        Body platform8 = new StaticBody(this, platform8Shape);
        platform8.setPosition(new Vec2(-15, 3f));
        platform8.setAngle(-0.2f);

        // row 3  right
        Shape platform12Shape = new BoxShape(6.25f, 0.5f);
        Body platform12 = new StaticBody(this, platform12Shape);
        platform12.setPosition(new Vec2(15, 3f));
        platform12.setAngle(0.2f);

        //row 4 left
        Shape platform5Shape = new BoxShape(4f, 0.5f);
        Body platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(-14, 8.5f));
        platform5.setAngle(-0.2f);

        Shape platform6Shape = new BoxShape(4f, 0.5f);
        Body platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(14, 8.5f));
        platform6.setAngle(0.2f);

        // row 4 middle 
        Shape platform7Shape = new BoxShape(4.25f, 0.5f);
        Body platform7 = new StaticBody(this, platform7Shape);
        platform7.setPosition(new Vec2(-0.5f, 6));
        // platform7.setAngle(-0.2f);

        //Zombie 4
        zombie = new Zombie(this);
        zombie.setPosition(new Vec2(15, -2));
        zombie.addCollisionListener(new DarylHit(daryl));
        zombie.addCollisionListener(new RickHit(rick));

        //Zombie 5
        zombie = new Zombie(this);
        zombie.setPosition(new Vec2(14, 8.5f));
        zombie.addCollisionListener(new DarylHit(daryl));
        zombie.addCollisionListener(new RickHit(rick));

        //Zombie 6
        zombie = new Zombie(this);
        zombie.setPosition(new Vec2(-15, 8.5f));
        zombie.addCollisionListener(new DarylHit(daryl));
        zombie.addCollisionListener(new RickHit(rick));

        //spike 1
        spikes = new Spikes(this);
        spikes.setPosition(new Vec2(0, 1.5f));

        //spike 2
        spikes = new Spikes(this);
        spikes.setPosition(new Vec2(0, -6));

        //spike
        spikes = new Spikes(this);
        spikes.setPosition(new Vec2(0, 7f));

        //spike4 
        spikes = new Spikes(this);
        spikes.setPosition(new Vec2(-16, -13.5f));

        //spike 5
        spikes = new Spikes(this);
        spikes.setPosition(new Vec2(16, -13.5f));

        for (int i = 0; i < 4; i++) {
            Body RedKey = new RedKey(this);
            RedKey.setPosition(new Vec2(i * 2 - 10, 10));

        }

        for (int i = 0; i < 4; i++) {
            Body BlueKey = new BlueKey(this);
            BlueKey.setPosition(new Vec2(i * 2 - 5, 5));

        }

        for (int i = 0; i < 5; i++) {
            Body healthHeart = new HealthHeart(this);
            healthHeart.setPosition(new Vec2(i * 2 - 1, 14));

        }

    }

    /**
     * set ricks start positions
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-8, -14);
    }

    /**
     * set daryls start positions
     */
    public Vec2 startPositionP2() {
        return new Vec2(-10, -14);
    }

    /**
     * set doors start positions
     */
    @Override
    public Vec2 redDoorPosition() {
        return new Vec2(17.25f, 10.25f);
    }

    /**
     * set doors start positions
     */
    public Vec2 blueDoorPosition() {
        return new Vec2(-17.25f, 10.25f);
    }

    /**
     * set enemy start positions
     */
    public Vec2 Enemy1Position() {
        return new Vec2(15f, -10);

    }

    /**
     * set enemy start positions
     */
    public Vec2 Enemy2Position() {
        return new Vec2(-15, -10);

    }

    /**
     * set enemy start positions
     */
    public Vec2 Enemy3Position() {
        return new Vec2(-15, -2);

    }

    /**
     * all the blue keys collected
     */
    public boolean blueKeyCompleted() {
        return getPlayer2().getBlueKeyCount() == NUM_BLUE_KEYS;

    }

    /**
     * all the red keys collected
     */
    public boolean redKeyCompleted() {
        return getPlayer1().getRedKeyCount() == NUM_RED_KEYS;
    }

    /**
     * checking if both sets of keys are collected
     */
    @Override
    public boolean isCompleted() {
        return redKeyCompleted() && blueKeyCompleted();
    }

}
