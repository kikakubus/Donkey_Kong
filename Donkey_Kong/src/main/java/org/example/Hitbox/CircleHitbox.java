package org.example.Hitbox;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class CircleHitbox extends Hitbox {

    public CircleHitbox(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(1);
        //setAnchorLocationX(5);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        setHeight(10);
        setFill(Color.TRANSPARENT);
    }
}