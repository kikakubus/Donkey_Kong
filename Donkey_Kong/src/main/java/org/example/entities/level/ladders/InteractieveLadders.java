package org.example.entities.level.ladders;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

public class InteractieveLadders extends Ladders  implements Collider {

    public InteractieveLadders(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, new Size(30, 30), resource);
    }
}