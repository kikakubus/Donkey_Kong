package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BlauweTonnenSprite extends DynamicSpriteEntity {

    public BlauweTonnenSprite(final Coordinate2D INITIAL_LOCATION) {
        super("sprites/BlueBarrel.png", INITIAL_LOCATION, new Size(40, 40), 2, 2);
        setAutoCycle(450, 0);
    }
}