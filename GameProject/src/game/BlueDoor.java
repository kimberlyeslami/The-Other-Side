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
public class BlueDoor extends StaticBody {

    /**
     * creates the blue door
     */
    public BlueDoor(World world) {
        super(world);
        Shape BlueDoorShape = new PolygonShape(-0.64f, 1.48f, 0.66f, 1.5f,
                0.65f, -1.3f, -0.65f, -1.29f);
        Fixture fixture = new SolidFixture(this, BlueDoorShape);
        addImage(new BodyImage("data/blueDoor.png", 3f));
        setPosition(new Vec2(-10, -10));
    }

}
