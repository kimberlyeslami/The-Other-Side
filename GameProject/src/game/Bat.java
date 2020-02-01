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
public class Bat extends DynamicBody {

    private Bat bat;
    /**
     * creates bat shape
     */
    private static final Shape BatShape = new PolygonShape(1.886f, -0.08f,
            1.534f, 0.233f, -1.602f, 0.415f, -1.955f, 0.114f, -1.608f, -0.386f,
            1.585f, -0.375f, 1.892f, -0.097f);
    /**
     * adds left image
     */
    private static final BodyImage Bat
            = new BodyImage("data/bat.png", 0.8f);
    /**
     * adds right image
     */
    private static final BodyImage Bat2
            = new BodyImage("data/bat.png", 0.8f);

    /**
     * initialises the variables for bat
     */
    public Bat(World world, Negan negan) {
        super(world);

        Fixture fixture = new SolidFixture(this, BatShape);
        addImage(Bat);
        this.setGravityScale(0f);
        this.addCollisionListener(new BatCollision(bat));
        // this.addCollisionListener(new RickHit(rick));
        this.setLinearVelocity(new Vec2(negan.direction * 10f, 0));
    }

    /**
     * removes right image and gets left image
     */
    public BodyImage getStillImageB() {
        this.removeAllImages();
        return Bat2;
    }

}
