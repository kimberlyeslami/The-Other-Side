package game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

public class WalkLeftState extends FSMState<Negan> {

    /**
     * boss moves left
     */
    protected void update() {
        Negan negan = getContext();
        if (negan.inRangeRight()) {
            gotoState(new WalkRightState());
        } else if (!negan.inRange()) {
            gotoState(new StandStillState());
        } else {
            negan.setLinearVelocity(new Vec2(-4.0f, 0.0f));
        }
    }

    protected void enter() {
        Negan negan = getContext();
        negan.setLinearVelocity(new Vec2(-4.0f, 0.0f));
    }

    protected void exit() {
    }
}
