package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import org.example.Hitbox.RectangleHitbox;
import java.util.List;

public abstract class Tonnen extends DynamicCompositeEntity implements Collided, Collider, SceneBorderCrossingWatcher {
    private int speed;

    public Tonnen(Coordinate2D initialLocation, int speed) {
        super(initialLocation);
        this.speed = speed;
    }

    @Override
    public abstract void setupEntities();

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        // Checks which Hitbox the barrels collide with
        // The switch searches a ID that has been assigned to the hitbox
        for (Collider colliderObject : collidingObjects) {
            if (colliderObject instanceof RectangleHitbox rectangleHitbox) {
                switch (rectangleHitbox.getId()) {
                    case "TopFloor-LeftSide", "FirstFloor-RightSide":
                        setMotion(0.7, 360d);
                        break;
                    case "FirstFloor-LeftSide":
                        setMotion(0.7, 90d);
                        break;
                    case "BottomFloor-RightSide":
                        setMotion(0.7, 270d);
                        break;
                    default:
                        System.out.println("Unknown hitbox: " + rectangleHitbox.getId());
                }
            }
        }
    }
}