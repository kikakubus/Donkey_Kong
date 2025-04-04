package org.example.entities.obstakels.vlammetjes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Vlammetjes extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    public Vlammetjes(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(30));
    }
}
