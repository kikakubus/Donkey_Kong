package org.example.Hitbox;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class RectangleHitbox extends Hitbox {

    public RectangleHitbox(String id, Coordinate2D initialLocation) {
        super(initialLocation, id);
        setWidth(27);
        setHeight(60);
        setFill(Color.RED);
    }
}