package org.example.Hitbox;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class RectangleHitbox extends Hitbox {
    private String Id;

    public RectangleHitbox(String id, Coordinate2D initialLocation) {
        super(initialLocation);
        this.Id = id;
        setWidth(27);
        setHeight(60);
        setFill(Color.RED);
    }

    public String getId() {
        return Id;
    }
}