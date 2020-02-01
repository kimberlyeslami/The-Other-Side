package game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

public class WalkRightState extends FSMState<Negan> {

    /**
     * boss moves right
     */
    protected void update() {
        Negan negan = getContext();
        if (negan.inRangeLeft()) {
            gotoState(new WalkLeftState());
        } else if (!negan.inRange()) {
            gotoState(new StandStillState());
        } else {
            negan.setLinearVelocity(new Vec2(4.0f, 0.0f));
        }
    }

    protected void enter() {
        Negan negan = getContext();
        negan.setLinearVelocity(new Vec2(4.0f, 0.0f));
    }

    protected void exit() {
    }
}
