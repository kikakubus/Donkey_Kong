package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BruineTonnenSprite extends DynamicSpriteEntity {

    public BruineTonnenSprite(final Coordinate2D initialLocation) {
        super("sprites/Barrel.png", initialLocation, new Size(40, 40), 2, 2);
        setAutoCycle(450, 0);
    }
}