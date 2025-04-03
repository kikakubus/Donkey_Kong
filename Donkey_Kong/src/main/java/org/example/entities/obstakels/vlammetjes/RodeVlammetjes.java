package org.example.entities.obstakels.vlammetjes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.entities.level.Balken;

import java.util.List;

public class RodeVlammetjes extends Vlammetjes implements Collider, SceneBorderCrossingWatcher {
    private double speed;

    public RodeVlammetjes(Coordinate2D initialLocation) {
        super("sprites/RodeVlam.png", initialLocation);
        this.speed = 0.7;
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
