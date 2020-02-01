/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import static java.awt.Color.black;
import org.jbox2d.common.Vec2;

/**
 *
 * @author kimberly
 */
public class Bullet extends DynamicBody {

    private Bullet bullet;

    /**
     * creates and initialises the bullet
     */
    public Bullet(World world) {
        super(world);
        Shape BulletShape = new CircleShape(0.2f);
        Fixture fixture = new SolidFixture(this, BulletShape);
        setFillColor(black);
        this.setGravityScale(0.1f);
        this.addCollisionListener(new BulletCollision(bullet));

    }

}
