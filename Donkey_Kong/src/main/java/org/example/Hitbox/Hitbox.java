package org.example.Hitbox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public class Hitbox extends RectangleEntity implements Collider {
    private String id;

    public Hitbox(final Coordinate2D initialLocation, String id) {
        super(initialLocation);
        this.id = id;
        setContrast(5);
    }

    public String getId() {
        return id;
    }
}