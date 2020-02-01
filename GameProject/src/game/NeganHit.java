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
public class NeganHit implements CollisionListener {

    private Negan negan;

    public NeganHit(Negan negan) {
        this.negan = negan;

    }

    /**
     * when negans hit, lose lives
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Bullet) {
            if (e.getReportingBody() instanceof Negan) {
                e.getOtherBody().destroy();
                negan.reduceLives();
                negan.zeroHealth();
            }
        }
        if (e.getOtherBody() instanceof Arrows) {
            if (e.getReportingBody() instanceof Negan) {
                e.getOtherBody().destroy();
                negan.reduceLives();
                negan.zeroHealth();

            }
        }
    }
}
