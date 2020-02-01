/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author kimberly
 */
public class ArrowCollision implements CollisionListener {

    private Arrows arrow;

    public ArrowCollision(Arrows arrow) {
        this.arrow = arrow;

    }

    /**
     * makes a collision between the zombies and the arrows.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Zombie) {
            if (e.getReportingBody() instanceof Arrows) {
                e.getOtherBody().destroy();
                e.getReportingBody().destroy();
            }
        }
        if (e.getOtherBody() instanceof Zombie2) {
            if (e.getReportingBody() instanceof Arrows) {
                e.getOtherBody().destroy();
                e.getReportingBody().destroy();

            }

        } else if (!(e.getOtherBody() instanceof Daryl)) {
            e.getReportingBody().destroy();
        }
    }
}
