/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author kimbe
 */
public class Zombie extends DynamicBody {

    /**
     * create zombie
     */
    public Zombie(World world) {
        super(world);
        Shape ZombieShape = new PolygonShape(0.54f, 1.43f, 1.1f, 0.03f, 0.75f,
                -1.48f, -0.9f, -1.47f, -1.09f, -0.41f, -0.28f, 1.22f, 0.5f, 1.43f);
        Fixture fixture = new SolidFixture(this, ZombieShape);
        addImage(new BodyImage("data/zombie.png", 3));
        //setPosition(new Vec2(6, -6));
    }

}
