package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class BlauweTonnen extends Tonnen {

    public BlauweTonnen(Coordinate2D initialLocation, double speed) {
        super(initialLocation, speed);
        setMotion(speed, 270d);
    }

    @Override
    public void setupEntities() {
        var blauweTonnenSprite = new BlauweTonnenSprite(
                new Coordinate2D(0, 0)
        );

        addEntity(blauweTonnenSprite);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}