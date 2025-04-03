package org.example.Hitbox;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class CircleHitbox extends Hitbox {

    public CircleHitbox(String id, Coordinate2D initialLocation) {
        super(initialLocation, id);
        setWidth(30);
        setAnchorLocationX(5);
        setHeight(20);
        setFill(Color.RED);
    }
}