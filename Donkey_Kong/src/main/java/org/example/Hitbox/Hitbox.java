package org.example.Hitbox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public class Hitbox extends RectangleEntity implements Collider {

    public Hitbox(final Coordinate2D initialLocation) {
        super(initialLocation);
        setContrast(5);
    }
}