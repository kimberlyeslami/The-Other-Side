/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 *
 * @author kimbe
 */
public class Arrows extends DynamicBody {

    World w;
    private Arrows arrow;
    /**
     * creates right arrow shape
     */
    private static final Shape RightArrowShape = new PolygonShape(-1.239f,
            0.216f, -0.867f, 0.224f, 1.133f, 0.004f, -0.8f, -0.149f, -1.259f, -0.165f,
            -1.259f, 0.176f);
    /**
     * creates left arrow shape
     */

    private static final Shape LeftArrowShape = new PolygonShape(1.259f,
            -0.161f, 1.278f, 0.188f, 0.867f, 0.196f, -1.145f, 0.004f, 0.816f,
            -0.176f, 1.251f, -0.192f);
    /**
     * adds left image
     */
    private static final BodyImage leftArrow
            = new BodyImage("data/leftArrow.png", 0.8f);
    /**
     * adds right image
     */
    private static final BodyImage rightArrow
            = new BodyImage("data/rightArrow.png", 0.8f);

    /**
     * initialised the variables for arrow
     */
    public Arrows(World world) {
        super(world);
        Fixture fixture = new SolidFixture(this, RightArrowShape);
        addImage(rightArrow);
        this.setGravityScale(1f);
        this.addCollisionListener(new ArrowCollision(arrow));

    }

}
