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
public class DoorListener implements CollisionListener {

    private Game game;

    DoorListener(Game game) {
        this.game = game;
    }

    /**
     * collision with the door
     */
    public void collide(CollisionEvent e) {
        Rick rick = game.getPlayer1();
        if (e.getOtherBody() == rick && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }

}
