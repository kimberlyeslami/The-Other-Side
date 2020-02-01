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
 * @author kimbe
 */
public class BatCollision implements CollisionListener {

    private Bat bat;

    public BatCollision(Bat bat) {
        this.bat = bat;

    }

    /**
     * collisions with the bat,between the zombies and the bat
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Zombie) {
            if (e.getReportingBody() instanceof Bat) {
                e.getOtherBody().destroy();
                e.getReportingBody().destroy();
            }

        } else if (!(e.getOtherBody() instanceof Negan)) {
            e.getReportingBody().destroy();
        }

    }
}
