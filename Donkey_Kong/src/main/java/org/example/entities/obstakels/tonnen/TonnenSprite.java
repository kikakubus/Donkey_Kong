package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class TonnenSprite extends DynamicSpriteEntity {

    public TonnenSprite(final Coordinate2D initialLocation) {
        super("sprites/Barrel.png", initialLocation, new Size(70, 70), 2, 2);
        setAutoCycle(450, 0);
    }
}