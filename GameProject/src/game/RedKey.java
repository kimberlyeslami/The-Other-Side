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
public class RedKey extends DynamicBody {
       /**create red keys */
    public RedKey(World world) {
        super(world);
        Shape RedKeyShape = new PolygonShape(-0.746f,0.084f, -0.348f,0.348f, 
                0.732f,0.018f, -0.252f,-0.316f, -0.744f,0.059f);
        Fixture fixture = new SolidFixture(this, RedKeyShape);
        addImage(new BodyImage("data/redkey.png",1.5f));
        //setPosition(new Vec2(-8, -10));
    }
    
}  
    

