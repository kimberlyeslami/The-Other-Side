
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Walker;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.jbox2d.common.Vec2;

/**
 *
 * @author kimberly
 */
public class RickController extends KeyAdapter {

    private static final float WALKING_SPEED = 5f;
    private static final float JUMPING_SPEED = 15;

    private Rick body;

    public RickController(Rick body) {
        this.body = body;
    }

    /**
     * handles key pressed events for walking, jumping and shooting
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // up key = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.addImage(body.getLeftImage());
            body.startWalking(-WALKING_SPEED); // left arrow key = walk left
        } else if (code == KeyEvent.VK_RIGHT) {
            body.addImage(body.getRightImage());
            body.startWalking(WALKING_SPEED); // right arrow key = walk right
        } else if (code == KeyEvent.VK_SPACE) {
            ((Rick) body).Shoot(); // space bar = shoot bullets
        }

    }

    /**
     * handles key released events for walking and jumping.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking(); // left arrow key released = stop walking 
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();  // right arrow key released = stop walking 
        }

    }

    /**
     * sets the body
     */
    public void setBody(Rick body) {
        this.body = body;
    }
}
