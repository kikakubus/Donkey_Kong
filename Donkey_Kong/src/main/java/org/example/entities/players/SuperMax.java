package org.example.entities.players;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class SuperMax extends DynamicSpriteEntity implements KeyListener, Collided {

    public SuperMax(Coordinate2D initialLocation) {
        super("sprites/SuperMax.png", initialLocation, new Size(100, 50), 3, 2);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(2, 270d);
            setCurrentFrameIndex(2);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(2, 90d);
            setCurrentFrameIndex(6);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(2, 180d);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(2, 360d);
        }
    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}