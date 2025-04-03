package org.example.entities.obstakels.vlammetjes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class BlauweVlammetjes extends Vlammetjes implements Collider, SceneBorderCrossingWatcher {
    private double speed;

    public BlauweVlammetjes(Coordinate2D initialLocation) {
        super("sprites/BlauwVlam.png", initialLocation);
        this.speed = 1;
        setMotion(speed, 90d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        switch (border) {
            case LEFT:
                setAnchorLocationX(1);
                setMotion(speed, 90d);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - speed);
                setMotion(speed, 270d);
                break;
            default:
                break;
        }
    }
}
