package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.example.Hitbox;

import java.util.List;
import java.util.Random;

public abstract class Tonnen extends DynamicCompositeEntity implements Collided, Collider {
    private int speed;
    private boolean movingDown = false;
    private boolean hasMadeDecision = false;

    public Tonnen(Coordinate2D initialLocation, int speed) {
        super(initialLocation);
        this.speed = speed;
    }

    @Override
    public abstract void setupEntities();

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (Collider colliderObject : collidingObjects) {
            if (colliderObject instanceof Hitbox && !movingDown && !hasMadeDecision) {
                hasMadeDecision = true;
                Random random = new Random();
                if (random.nextInt(2) == 0) {
                    movingDown = true;
                    setMotion(1, 360d);
                }
            }
        }
    }
}