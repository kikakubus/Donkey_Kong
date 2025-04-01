package org.example.entities.level;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Balken extends DynamicSpriteEntity implements Collider {

    public Balken(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}