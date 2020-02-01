/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author kimbe
 */
public class Cans extends DynamicBody {

    /**
     * creates the cans
     */
    public Cans(World world) {
        super(world);
        Shape CansShape = new PolygonShape(-0.527f, -0.975f, 0.54f, -0.963f,
                0.515f, 0.979f, -0.527f, 0.971f, -0.54f, -0.967f);
        Fixture fixture = new SolidFixture(this, CansShape);
        addImage(new BodyImage("data/Soup.png", 2f));
        //setPosition(new Vec2(6, -6));
    }

}
