package game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

public class StandStillState extends FSMState<Negan> {

    /**
     * boss stands still
     */
    protected void update() {
        Negan negan = getContext();
        if (negan.inRangeLeft()) {
            gotoState(new WalkLeftState());
        } else if (negan.inRangeRight()) {
            gotoState(new WalkRightState());
        }
    }

    protected void enter() {
        Negan negan = getContext();
        negan.setLinearVelocity(new Vec2());
    }

    protected void exit() {
    }
}
