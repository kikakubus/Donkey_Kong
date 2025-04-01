package org.example.entities.players;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.entities.level.Balken;
import org.example.entities.level.ladders.Ladders;
import org.example.entities.obstakels.tonnen.Tonnen;

import java.util.List;
import java.util.Set;

public class SuperMax extends DynamicSpriteEntity implements KeyListener, Collided, Newtonian, SceneBorderTouchingWatcher {
    private double playerSpeed = 1;
    private boolean onGround = false;
    private double jumpStrength = 3.8;
    private double horizontalMotion = 0; // Store horizontal speed
    private int interval = 200;
    private boolean canClimb = false;

    public SuperMax(Coordinate2D initialLocation) {
        super("sprites/SuperMax.png", initialLocation, new Size(100, 50), 3, 2);

        setGravityConstant(0.10); // Set gravity for a natural fall
        //setFrictionConstant(0.02); // Slight friction for air movement
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        boolean movingHorizontally = false;

        // Horizontal movement when on the ground
        if (pressedKeys.contains(KeyCode.LEFT)) {
            movingHorizontally = true;
            horizontalMotion = -playerSpeed;

            if (onGround) {
                setMotion(playerSpeed, 270d);  // Move left on the ground
                setAutoCycle(interval, 1);
            }
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            movingHorizontally = true;
            horizontalMotion = playerSpeed;

            if (onGround) {
                setMotion(playerSpeed, 90d);  // Move right on the ground
                setAutoCycle(interval, 0);
            }
        }

        // Jumping logic
        if (pressedKeys.contains(KeyCode.SPACE) && onGround) {
            if (movingHorizontally) {
                setMotion(jumpStrength, horizontalMotion > 0 ? 160d : 200d); // Jump and maintain horizontal motion
            } else {
                setMotion(jumpStrength, 180d); // Jump upwards if not moving horizontally
            }
            onGround = false; // Player is in the air now
        }

        // Stop horizontal movement when not moving left or right
        if (!movingHorizontally && onGround) {
            setSpeed(0);
        }
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        canClimb = false;

        for (Collider collider : colliders) {
            if (collider instanceof Balken) {
                onGround = true;  // Player has landed
                alignWithPlatform((Balken) collider);
            }

            if (collider instanceof Ladders) {
                canClimb = true;
            }
        }
    }

    private void alignWithPlatform(Balken balken) {
        setAnchorLocationY(balken.getBoundingBox().getMinY() - getHeight()); // Align with the platform
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - playerSpeed);
                onGround = true;  // Player is on the ground
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - playerSpeed);
            default:
                break;
        }
    }
}
