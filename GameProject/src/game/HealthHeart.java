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
import org.jbox2d.common.Vec2;

/**
 *
 * @author kimbe
 */
public class HealthHeart extends DynamicBody {

    private HealthHeart heart;

    /**
     * creates the health heart
     */
    public HealthHeart(World world) {
        super(world);
        Shape HealthHeartShape = new PolygonShape(0.365f, 0.431f, 0.49f, 0.293f,
                0.043f, -0.45f, -0.45f, 0.093f, -0.45f, 0.3f, -0.318f, 0.434f,
                0.358f, 0.435f);
        Fixture fixture = new SolidFixture(this, HealthHeartShape);
        addImage(new BodyImage("data/healthHeart.png", 1.0f));
        //setPosition(new Vec2(-8, -10));
    }

}
