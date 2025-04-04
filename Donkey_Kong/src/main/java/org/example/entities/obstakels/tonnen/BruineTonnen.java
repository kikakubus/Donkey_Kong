package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class BruineTonnen extends Tonnen {

    public BruineTonnen(Coordinate2D initialLocation, double speed) {
        super(initialLocation, speed);
        setMotion(speed, 270d);
    }

    @Override
    public void setupEntities() {
        var bruineTonnenSprite = new BruineTonnenSprite(
                new Coordinate2D(0, 0)
        );

        addEntity(bruineTonnenSprite);

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}