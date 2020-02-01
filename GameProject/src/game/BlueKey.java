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
public class BlueKey extends DynamicBody {

    /**
     * create blue keys
     */
    public BlueKey(World world) {
        super(world);
        Shape BlueKeyShape = new PolygonShape(-0.534f, 0.387f, 0.914f, 0.119f,
                -0.462f, -0.359f, -0.942f, -0.014f, -0.56f, 0.384f);
        Fixture fixture = new SolidFixture(this, BlueKeyShape);
        addImage(new BodyImage("data/blueKey.png", 0.8f));
        setPosition(new Vec2(-8, -10));
    }

}
