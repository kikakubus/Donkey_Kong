package org.example.entities.level.ladders;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

public class NietInteractieveLadders extends Ladders {

    public NietInteractieveLadders(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, new Size(75, 75), resource);
    }
}