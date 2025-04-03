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
import org.example.Hitbox.CircleHitbox;
import org.example.entities.level.Balken;
import org.example.entities.level.ladders.InteractieveLadders;
import org.example.entities.level.ladders.Ladders;
import org.example.entities.obstakels.aap.DK;
import org.example.entities.obstakels.tonnen.BlauweTonnen;
import org.example.entities.obstakels.tonnen.BruineTonnen;
import org.example.entities.obstakels.tonnen.Tonnen;
import org.example.entities.tekst.HealthText;
import org.example.entities.tekst.ScoreText;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class SuperMax extends DynamicSpriteEntity implements KeyListener, Collided, Newtonian, SceneBorderTouchingWatcher {
    private double playerSpeed = 1;
    private boolean onGround = false;
    private double jumpStrength = 4;
    private double horizontalMotion = 0;
    private int interval = 200;
    private int health = 3;
    private int score = 0;
    private boolean canClimb = false;
    private boolean climbing = false;
    private HealthText healthText;
    private ScoreText scoreText;

    public SuperMax(Coordinate2D initialLocation, HealthText healthText, ScoreText scoreText) {
        super("sprites/SuperMax.png", initialLocation, new Size(40, 40), 3, 2);
        this.healthText = healthText;
        this.scoreText = scoreText;

        healthText.setHealthText(health);
        scoreText.setScoreText(score);
        setGravityConstant(0.07);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        boolean movingHorizontally = false;
        boolean movingVertically = false;
        climbing = false;

        if (canClimb) {
            if (pressedKeys.contains(KeyCode.DOWN)) {
                climbing = true;
                movingVertically = true;
                setMotion(playerSpeed, 360d);
            } else if (pressedKeys.contains(KeyCode.UP)) {
                climbing = true;
                movingVertically = true;
                setMotion(playerSpeed, 180d);
            }
        }

        if (!climbing) {
            if (pressedKeys.contains(KeyCode.LEFT)) {
                movingHorizontally = true;
                horizontalMotion = -playerSpeed;
                if (onGround) {
                    setMotion(playerSpeed, 270d);
                    setAutoCycle(interval, 1);
                }
            } else if (pressedKeys.contains(KeyCode.RIGHT)) {
                movingHorizontally = true;
                horizontalMotion = playerSpeed;
                if (onGround) {
                    setMotion(playerSpeed, 90d);
                    setAutoCycle(interval, 0);
                }
            }
        }

        if (pressedKeys.contains(KeyCode.SPACE) && onGround) {
            if (movingHorizontally) {
                setMotion(jumpStrength, horizontalMotion > 0 ? 160d : 200d);
            } else {
                setMotion(jumpStrength, 180d);
            }
            onGround = false;
        }

        if (!movingHorizontally && !movingVertically && onGround && !climbing) {
            setSpeed(0);
        }

        canClimb = false;
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        canClimb = false;
        boolean touchingLadder = false;
        boolean touchingGround = false;

        for (Collider collider : colliders) {
            if (collider instanceof Balken) {
                touchingGround = true;
                alignWithPlatform((Balken) collider);
            }
            if (collider instanceof InteractieveLadders) {
                canClimb = true;
                touchingLadder = true;
            }

            if (collider instanceof BruineTonnen || collider instanceof BlauweTonnen || collider instanceof DK) {
                health--;
                healthText.setHealthText(health);

                setAnchorLocation(
                        new Coordinate2D(25, 450)
                );
            }

            if (collider instanceof CircleHitbox circleHitbox) {
                switch (circleHitbox.getId()) {
                    case "Bruine-Tonnen":
                        score = score + 100;
                        scoreText.setScoreText(score);
                        break;
                    case "Blauwe-Tonnen":
                        score = score + 200;
                        scoreText.setScoreText(score);
                        break;
                }
            }
        }

        if (!touchingLadder) {
            climbing = false;
        }

        onGround = touchingGround;
    }

    private void alignWithPlatform(Balken balken) {
        if (!climbing) {
            setAnchorLocationY(balken.getBoundingBox().getMinY() - getHeight());
        }
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
                onGround = true;
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
