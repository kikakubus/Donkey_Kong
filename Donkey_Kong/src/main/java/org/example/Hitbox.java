package org.example;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class Hitbox extends RectangleEntity implements Collider {

    public Hitbox(final Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(27);
        setHeight(60);
        setFill(Color.RED);
    }
}