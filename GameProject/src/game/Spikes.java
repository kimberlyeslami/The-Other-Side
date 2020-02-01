/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.StaticBody;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author kimbe
 */
public class Spikes extends StaticBody {

    /**
     * makes the spikes
     */
    public Spikes(World world) {
        super(world);
        Shape SpikesShape = new PolygonShape(-0.67f, -0.47f, -0.29f, 0.87f,
                0.47f, 0.86f, 0.83f, -0.49f, -0.62f, -0.48f);
        Fixture fixture = new SolidFixture(this, SpikesShape);
        addImage(new BodyImage("data/spikes.png", 5f));
        //setPosition(new Vec2(6, -6));
    }

}
