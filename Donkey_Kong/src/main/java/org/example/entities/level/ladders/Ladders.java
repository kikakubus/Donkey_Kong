package org.example.entities.level.ladders;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Ladders extends SpriteEntity {

    public Ladders(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}