package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.Hitbox.CircleHitbox;
import org.example.Hitbox.Hitbox;

public class BruineTonnen extends Tonnen {

    public BruineTonnen(Coordinate2D initialLocation, int speed) {
        super(initialLocation, speed);
        setMotion(speed, 270d);
    }

    @Override
    public void setupEntities() {

        Hitbox circleHitbox = new CircleHitbox(
                new Coordinate2D(0, 0)
        );

        var bruineTonnenSprite = new BruineTonnenSprite(
                new Coordinate2D(0, 0)
        );


        addEntity(circleHitbox);
        addEntity(bruineTonnenSprite);

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}