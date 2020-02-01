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
public class BulletCollision implements CollisionListener {

    private Bullet bullet;

    public BulletCollision(Bullet bullet) {
        this.bullet = bullet;

    }

    /**
     * creates collision with the bullets and the zombies
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Zombie) {
            if (e.getReportingBody() instanceof Bullet) {
                e.getOtherBody().destroy();
                e.getReportingBody().destroy();
            }
        }

        if (e.getOtherBody() instanceof Zombie2) {
            if (e.getReportingBody() instanceof Bullet) {
                e.getOtherBody().destroy();
                e.getReportingBody().destroy();
            }

        } else if (!(e.getOtherBody() instanceof Rick)) {
            e.getReportingBody().destroy();
        }
    }

}
