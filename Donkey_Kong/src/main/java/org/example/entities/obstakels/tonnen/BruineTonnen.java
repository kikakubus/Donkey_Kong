package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;

public class BruineTonnen extends Tonnen {

    public BruineTonnen(Coordinate2D initialLocation, int speed) {
        super(initialLocation, speed);
        setMotion(speed, 270d);
    }

    @Override
    public void setupEntities() {
        var bruineTonnenSprite = new TonnenSprite(
                new Coordinate2D(0, 0));

        addEntity(bruineTonnenSprite);
    }
}