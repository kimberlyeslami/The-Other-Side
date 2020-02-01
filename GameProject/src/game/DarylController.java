/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.jbox2d.common.Vec2;

/**
 *
 * @author kimbe
 */
public class DarylController extends KeyAdapter {

    private static final float WALKING_SPEED = 5f;
    private static final float JUMPING_SPEED = 15;

    private Daryl body;

    public DarylController(Daryl body) {
        this.body = body;
    }

    /**
     * handles key pressed actions for walking, jumping and shooting
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // w key = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.addImage(body.getLeftImage());
            body.startWalking(-WALKING_SPEED); // d key = walk left
        } else if (code == KeyEvent.VK_D) {
            body.addImage(body.getRightImage());
            body.startWalking(WALKING_SPEED); // a key = walk right
        } else if (code == KeyEvent.VK_F) {
            ((Daryl) body).Shoot(); // F = shoot arrows
        }
    }

    /**
     * handles key released actions for walking and jumping
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D) {
            body.stopWalking(); // left arrow key released = stop walking 
        } else if (code == KeyEvent.VK_A) {
            body.stopWalking();  // right arrow key released = stop walking 
        }

    }

    /**
     * set body
     */
    public void setBody(Daryl body) {
        this.body = body;
    }

}
