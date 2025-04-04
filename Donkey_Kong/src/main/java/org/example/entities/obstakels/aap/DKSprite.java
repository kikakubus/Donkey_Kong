package org.example.entities.obstakels.aap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class DKSprite extends DynamicSpriteEntity {

    public DKSprite(final Coordinate2D INITIAL_LOCATION) {
        super("sprites/DK.png", INITIAL_LOCATION, new Size(300, 100), 1, 2);
        setAutoCycle(800, 0);
    }
}