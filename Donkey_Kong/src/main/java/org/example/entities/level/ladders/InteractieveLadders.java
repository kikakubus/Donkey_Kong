package org.example.entities.level.ladders;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class InteractieveLadders extends Ladders {

    public InteractieveLadders(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, new Size(50, 50), resource);
    }
}