package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.Hitbox.TonnenHitbox;
import org.example.Hitbox.Hitbox;

public class BlauweTonnen extends Tonnen {

    public BlauweTonnen(Coordinate2D initialLocation, int speed) {
        super(initialLocation, speed);
        setMotion(speed, 270d);
    }

    @Override
    public void setupEntities() {
        var blauweTonnenSprite = new BlauweTonnenSprite(
                new Coordinate2D(0, 0)
        );

        Hitbox circleHitbox = new TonnenHitbox(
                "Blauwe-Tonnen", new Coordinate2D(0, 0)
        );

        addEntity(blauweTonnenSprite);
        addEntity(circleHitbox);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}