package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BruineTonnenSprite extends DynamicSpriteEntity {

    public BruineTonnenSprite(final Coordinate2D INITIAL_LOCATION) {
        super("sprites/Barrel.png", INITIAL_LOCATION, new Size(40, 40), 2, 2);
        setAutoCycle(450, 0);
    }
}