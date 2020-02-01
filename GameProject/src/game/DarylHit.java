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
public class DarylHit implements CollisionListener {

    private Daryl daryl;

    public DarylHit(Daryl daryl) {
        this.daryl = daryl;

    }

    /**
     * player collides with enemy and loses lives
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == daryl) {
            daryl.reduceLives();
            daryl.zeroHealth();
        }
        if (e.getOtherBody() instanceof Bat) {
            if (e.getReportingBody() instanceof Daryl) {
                daryl.reduceLives();
                daryl.zeroHealth();
            }

        }
        if (e.getOtherBody() instanceof Cans) {
            if (e.getReportingBody() instanceof Daryl) {
                daryl.increaseCanCount();
                e.getOtherBody().destroy();
            }
        }
        if (e.getOtherBody() instanceof BlueKey) {
            if (e.getReportingBody() instanceof Daryl) {
                daryl.incrementBlueKeyCount();
                e.getOtherBody().destroy();
            }
        }
        if (e.getOtherBody() instanceof HealthHeart) {
            if (e.getReportingBody() instanceof Daryl) {
                daryl.increaseLives();
                e.getOtherBody().destroy();
            }
        }
        if (e.getOtherBody() instanceof Spikes) {
            if (e.getReportingBody() instanceof Daryl) {
                daryl.hitSpikes();
                daryl.zeroHealth();
            }
        }
    }
}
