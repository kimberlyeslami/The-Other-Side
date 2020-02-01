/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import fsm.FSM;
import org.jbox2d.common.Vec2;

/**
 *
 * @author kimbe
 */
public class Negan extends Walker implements StepListener {

    private FSM<Negan> fsm;
    World w;
    Game game;
    public int direction;
    private int lives;
    private int shoot;
    public int defeat;
    public static final float RANGE = 10;
    /**
     * negan shape
     */
    private static final Shape neganShape = new PolygonShape(0.45f, 1.88f,
            0.92f, 0.98f, 0.6f, -2.16f, -0.76f, -2.17f, -2.18f, 0.76f, -0.46f, 1.87f);

    /**
     * right image
     */
    private static final BodyImage rightImage
            = new BodyImage("data/Negan.png", 5f);  

    /**
     * where the world and the game are initialised the variables for negan.
     */
    public Negan(World w, Game game) {
        super(w, neganShape);
        this.w = w;
        this.game = game;
        addImage(rightImage);
        SolidFixture fixture = new SolidFixture(this, neganShape);
        fixture.setFriction(8.0f);
        this.setGravityScale(1.0f);
        lives = 10;
        direction = 1;
        shoot = 0;
        fsm = new FSM<Negan>(this, new StandStillState());
        getWorld().addStepListener(this);
        this.addCollisionListener(new NeganHit(this));

    }

    /**
     * get right image
     */
    public BodyImage getRightImage() {
        this.removeAllImages();
        direction = 1;
        return rightImage;
    }

    /**
     * get direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * get lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * reduce lives
     */
    public void reduceLives() {
        lives--;
        System.out.println("Negan Hit! lose a life " + lives);

    }

    /**
     * when health is reduced to zero
     */
    public void zeroHealth() {
        if (lives <= 0) {
            this.destroy();
            defeat=1;
        }
    }

    /**
     * negans attack
     */
    public void shoot() {
        if (direction == 1) {
            Bat bat = new Bat(this.getWorld(), this);
            bat.setPosition(new Vec2((this.getPosition().x + 0.75f * this.direction), this.getPosition().y));
            bat.rotateDegrees(180);
        } else if (direction == -1) {
            Bat bat = new Bat(this.getWorld(), this);
            bat.setPosition(new Vec2((this.getPosition().x + 0.75f * this.direction), this.getPosition().y));
            bat.getStillImageB();
            bat.addImage(bat.getStillImageB());

        }
    }

    /**
     * checks if the player is in range to the left of negan
     */

    public boolean inRangeLeft() {
        Body a = game.getPlayer1();
        float gap = getPosition().x + a.getPosition().x;
        direction = -1;
        return gap < RANGE && gap > 0;
    }

    /**
     * checks if the player is in range to the right of negan
     */
    public boolean inRangeRight() {
        Body a = game.getPlayer1();
        float gap = getPosition().x + a.getPosition().x;
        direction = 1;
        return gap > -RANGE && gap < 0;
    }

    /**
     * checks if the player is in range of negan
     */
    public boolean inRange() {
        return inRangeLeft() || inRangeRight();
    }

    public void preStep(StepEvent e) {
        fsm.update();
    }

    /**
     * after 120 frames the boss shoots
     */
    public void postStep(StepEvent e) {
        if (shoot >= 120) {
            shoot();
            shoot = 0;
        }
        shoot += 1;
    }

}
