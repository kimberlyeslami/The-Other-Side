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
public class Zombie2 extends DynamicBody {

    /**
     * create zombie2
     */
    public Zombie2(World world) {
        super(world);
        Shape Zombie2Shape = new PolygonShape(0.58f, -2.03f, -0.69f, -2.03f,
                -0.76f, 0.07f, -0.55f, 1.83f, 0.0f, 2.17f, 0.74f, 1.99f, 0.9f,
                -0.54f, 0.6f, -1.99f);
        Fixture fixture = new SolidFixture(this, Zombie2Shape);
        addImage(new BodyImage("data/Zombie2.jpg", 5f));

    }

}
