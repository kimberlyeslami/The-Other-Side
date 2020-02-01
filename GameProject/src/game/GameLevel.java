/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author kimbe
 */
public abstract class GameLevel extends World {

    Rick rick;
    Daryl daryl;
    Zombie enemy1;
    Zombie enemy2;
    Zombie enemy3;
    Bullet bullet;
    Daryl getPlayer2;

    /**
     * get Rick
     */
    public Rick getPlayer1() {
        return rick;
    }

    /**
     * get Daryl
     */
    public Daryl getPlayer2() {
        return daryl;
    }

    /**
     * get enemy 1
     */
    public Zombie getEnemy1() {
        return enemy1;
    }

    /**
     * get enemy 2
     */
    public Zombie getEnemy2() {
        return enemy2;
    }

    /**
     * get enemy 1
     */
    public Zombie getEnemy3() {
        return enemy3;
    }

    /**
     * populates the other levels by creating all the entities on each level
     */
    public void populate(Game game) {
        rick = new Rick(this, game);
        rick.setPosition(startPosition());
        daryl = new Daryl(this, game);
        daryl.setPosition(startPositionP2());
        enemy1 = new Zombie(this);
        enemy1.setPosition(Enemy1Position());
        enemy1.addCollisionListener(new RickHit(rick));
        enemy1.addCollisionListener(new DarylHit(daryl));
        enemy2 = new Zombie(this);
        enemy2.setPosition(Enemy2Position());
        enemy2.addCollisionListener(new DarylHit(daryl));
        enemy2.addCollisionListener(new RickHit(rick));
        enemy3 = new Zombie(this);
        enemy3.setPosition(Enemy3Position());
        enemy3.addCollisionListener(new RickHit(rick));
        enemy3.addCollisionListener(new DarylHit(daryl));
        RedDoor redDoor = new RedDoor(this);
        redDoor.setPosition(redDoorPosition());
        redDoor.addCollisionListener(new DoorListener(game));
        BlueDoor blueDoor = new BlueDoor(this);
        blueDoor.setPosition(blueDoorPosition());
        blueDoor.addCollisionListener(new DoorListener(game));

    }

    /**
     * sets methods to be used in the levels to set the positions for the items
     */
    public abstract Vec2 startPosition();

    public abstract Vec2 startPositionP2();

    public abstract Vec2 redDoorPosition();

    public abstract Vec2 blueDoorPosition();

    public abstract Vec2 Enemy1Position();

    public abstract Vec2 Enemy2Position();

    public abstract Vec2 Enemy3Position();

    public abstract boolean isCompleted();

}
