/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

/**
 *
 * @author kimberly
 */
public class Rick extends Walker {

    private int RedKeyCount;
    private int CansCount;
    private int lives;
    private int cans;
    private Game game;
    private World w;
    private int direction;
    public static SoundClip gameover;

    private static final Shape rickShape = new PolygonShape(
            -0.13f, 0.98f, 1.3f, 0.13f, 0.53f, -1.39f, -1.48f, -1.38f,
            -1.2f, -0.16f, -0.66f, 0.97f, -0.18f, 0.98f);

    /**
     * left image
     */
    private static final BodyImage leftImage
            = new BodyImage("data/rickLeft.png", 3.0f);
    /**
     * right image
     */
    private static final BodyImage rightImage
            = new BodyImage("data/rickRight.png", 3.0f);

    /**
     * initialises ricks variables
     */
    public Rick(World w, Game game) {
        super(w, rickShape);
        this.w = w;
        this.game = game;
        addImage(rightImage);
        SolidFixture fixture = new SolidFixture(this, rickShape);
        this.addCollisionListener(new RickHit(this));
        fixture.setFriction(8.0f);
        this.setGravityScale(2.0f);
        RedKeyCount = 0;
        lives = 6;
        cans = 0;
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
     * get the direction of the character
     */
    public int getDirection() {
        return direction;
    }

    /**
     * get red keys
     */
    public int getRedKeyCount() {
        return RedKeyCount;
    }

    /**
     * count red keys
     */
    public void incrementRedKeyCount() {
        RedKeyCount++;
        System.out.println("RedKey count = " + RedKeyCount);
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
        System.out.println("Rick has hit an Enemy! lose a life " + lives);

    }

    /**
     * increase lives
     */
    public void increaseLives() {
        lives++;
        System.out.println("Rick has Gained a life " + lives);
    }

    /**
     * get can count
     */
    public int getCansCount() {
        return CansCount;
    }

    /**
     * get cans
     */
    public int getCans() {
        return cans;
    }

    /**
     * increment the key count
     */
    public void incrementCanCount() {
        cans++;
        System.out.println(" Cans count = " + CansCount);
    }

    /**
     * increase key count
     */
    public void increaseCanCount() {
        cans++;
        System.out.println("Rick has Collected a Can " + cans);
    }

    /**
     * player hit spikes
     */
    public void hitSpikes() {
        lives--;
        System.out.println("Rick has Hit the spikes " + lives);

    }

    /**
     * zero health and game over
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
     * player shoot
     */
    public void Shoot() {
        System.out.println("Shoots!");
        Bullet bullet = new Bullet(w);
        if (direction == 1) {
            bullet.setPosition(this.getPosition().add(new Vec2(0.5f, 0)));
        } else {
            bullet.setPosition(this.getPosition().add(new Vec2(-1.0f, 0)));
        }
        bullet.setLinearVelocity(new Vec2(8.0f * direction, 0.0f));
    }

    /**
     * get red key count
     */
    public int getRKeyCount() {
        return RedKeyCount;
    }

}
