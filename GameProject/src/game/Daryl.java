/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import static game.Rick.gameover;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 *
 * @author kimberly
 */
public class Daryl extends Walker {

    private int BlueKeyCount;
    private int cans;
    private int CansCount;
    private int lives;
    Game game;
    World w;
    private int direction;
    /**
     * sets daryl shape
     */
    private static final Shape darylShape = new PolygonShape(0.0f, 1.05f, 1.49f,
            0.0f, 0.73f, -1.3f, -1.22f, -1.29f, -0.76f, 0.76f, -0.04f, 1.05f);

    /**
     * left image
     */
    private static final BodyImage leftImage
            = new BodyImage("data/darylLeft.png", 3.0f);
    /**
     * right image
     */
    private static final BodyImage rightImage
            = new BodyImage("data/darylRight.png", 3.0f);

    /**
     * initialises the variables
     */
    public Daryl(World w, Game game) {
        super(w, darylShape);
        this.w = w;
        this.game = game;
        addImage(rightImage);
        SolidFixture fixture = new SolidFixture(this, darylShape);
        this.addCollisionListener(new DarylHit(this));
        fixture.setFriction(8.0f);
        this.setGravityScale(2.0f);
        BlueKeyCount = 0;
        lives = 6;
        direction = 1;
    }

    /**
     * get left image
     */
    public BodyImage getLeftImage() {
        this.removeAllImages();
        direction = -1;
        return leftImage;
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
     * gets direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * get blue keys
     */
    public int getBlueKeyCount() {
        return BlueKeyCount;
    }

    /**
     * count blue keys
     */
    public void incrementBlueKeyCount() {
        BlueKeyCount++;
        System.out.println("BlueKey count = " + BlueKeyCount);
    }

    /**
     * counts the cans
     */
    public int getCansCount() {
        return CansCount;
    }

    /**
     * gets the cans
     */
    public int getCans() {
        return cans;
    }

    /**
     * increment the can count
     */
    public void incrementCanCount() {
        cans++;
        System.out.println(" Cans count = " + CansCount);
    }

    /**
     * increase the can count
     */
    public void increaseCanCount() {
        cans++;
        System.out.println("Daryl has Collected a Can " + cans);
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
        System.out.println("Daryl has hit a Enemy! lose a life " + lives);

    }

    /**
     * lose lives when spikes are hit
     */
    public void hitSpikes() {
        lives--;
        System.out.println("Daryl has Hit the spikes " + lives);

    }

    /**
     * increase lives
     */
    public void increaseLives() {
        lives++;
        System.out.println("Daryl has Gained a life " + lives);

    }

    /**
     * when health is zero its game over
     */
    public void zeroHealth() {
        if (lives <= 0) {
            this.destroy();
            game.getFrame().dispose();
            game.gameMusic.stop();
            game.bossMusic.stop();
            GameOverScreen gameOverScreen = new GameOverScreen();
            gameOverScreen.setVisible(true);
            try {
                // Open an audio input stream
                gameover = new SoundClip("data/GameOver.mp3");
                gameover.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }

        }
    }

    /**
     * get the blue key count
     */
    public int getBKeyCount() {
        return BlueKeyCount;
    }

    /**
     * daryl shoots arrows
     */
    public void Shoot() {
        System.out.println("Shoots Arrow!");
        Arrows arrow = new Arrows(w);

        if (direction == 1) {
            arrow.setPosition(this.getPosition().add(new Vec2(3f, 0)));
            arrow.rotateDegrees(180);
        } else {
            arrow.setPosition(this.getPosition().add(new Vec2(-3.0f, 0)));
        }
        arrow.rotateDegrees(180);
        arrow.setLinearVelocity(new Vec2(8.0f * direction, 1.0f));
    }

}
