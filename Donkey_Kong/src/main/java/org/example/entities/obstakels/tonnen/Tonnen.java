package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.example.Hitbox;
import org.example.RectangleHitbox;
import org.example.entities.level.ladders.NietInteractieveLadders;

import java.util.List;
import java.util.Random;

public abstract class Tonnen extends DynamicCompositeEntity implements Collided, Collider {
    private int speed;
    private boolean movingDown = false;
    private boolean IsNotBeenThrough = false;

    public Tonnen(Coordinate2D initialLocation, int speed) {
        super(initialLocation);
        this.speed = speed;
    }

    @Override
    public abstract void setupEntities();

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (Collider colliderObject : collidingObjects) {
            if (colliderObject instanceof RectangleHitbox rect) {
                System.out.println("Detected collision with: " + rect.getId());
            }
            if (colliderObject instanceof RectangleHitbox rectangleHitbox) {
//                IsNotBeenThrough = true;
                switch (rectangleHitbox.getId()) {
                    case "TopFloor-LeftSide":
                        setMotion(1, 360d);
                        System.out.println("Hitbox1 collided - Moving Down");
                        break;
                    case "FirstFloor-LeftSide":
                        setMotion(1, 90d);
                        System.out.println("Hitbox2 collided - Moving Right");
                        break;
                    case "FirstFloor-RightSide":
                        setMotion(1, 360d);
                        System.out.println("Hitbox3 collided - Moving Down");
                        break;
                    case "BottomFloor-RightSide":
                        setMotion(1, 270d);
                        System.out.println("Hitbox4 collided - Moving Down");
                        break;
                    default:
                        System.out.println("Unknown hitbox: " + rectangleHitbox.getId());
                }
            }
        }
    }
}