package org.example.entities.obstakels.tonnen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class Tonnen extends DynamicCompositeEntity {

    public Tonnen(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    public abstract void setupEntities();
}