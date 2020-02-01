/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 *
 * @author kimbe
 */
public class RickHit implements CollisionListener {

    private Rick rick;

    public RickHit(Rick rick) {
        this.rick = rick;

    }

    /**
     * player collides with zombie and loses lifes
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == rick) {
            rick.reduceLives();
            rick.zeroHealth();
        }
        if (e.getOtherBody() instanceof Bat) {
            if (e.getReportingBody() instanceof Rick) {
                rick.reduceLives();
                rick.zeroHealth();
                e.getOtherBody().destroy();
            }
        }
        if (e.getOtherBody() instanceof Cans) {
            if (e.getReportingBody() instanceof Rick) {
                rick.increaseCanCount();
                e.getOtherBody().destroy();
            }
        }
        if (e.getOtherBody() instanceof RedKey) {
            if (e.getReportingBody() instanceof Rick) {
                rick.incrementRedKeyCount();
                e.getOtherBody().destroy();
            }
        }
        if (e.getOtherBody() instanceof HealthHeart) {
            if (e.getReportingBody() instanceof Rick) {
                rick.increaseLives();
                e.getOtherBody().destroy();
            }
        }
        if (e.getOtherBody() instanceof Spikes) {
            if (e.getReportingBody() instanceof Rick) {
                rick.hitSpikes();
                rick.zeroHealth();
            }

        }
    }
}
