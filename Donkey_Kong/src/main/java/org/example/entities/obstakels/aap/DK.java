package org.example.entities.obstakels.aap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class DK extends DynamicCompositeEntity {

    public DK(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(0, 0);
    }

    @Override
    public void setupEntities() {
        var dkSprite = new DKSprite(
                new Coordinate2D(0, 0)
        );

        addEntity(dkSprite);
    }
}