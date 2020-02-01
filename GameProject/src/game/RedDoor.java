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
public class RedDoor extends StaticBody {

    /** create red door */
  public RedDoor(World world) {
        super(world);
        Shape RedDoorShape = new PolygonShape(-0.65f,1.49f, 0.66f,1.49f, 
                0.65f,-1.29f, -0.65f,-1.31f, -0.65f,1.45f);
        Fixture fixture = new SolidFixture(this, RedDoorShape);
        addImage(new BodyImage("data/redDoor.png",3f));
        setPosition(new Vec2(-10, -10));
    }
    
}


