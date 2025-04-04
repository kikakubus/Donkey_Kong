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
import org.example.DonkeyKong;
import org.example.entities.level.Balken;
import org.example.entities.level.ladders.InteractieveLadders;
import org.example.entities.obstakels.aap.DK;
import org.example.entities.obstakels.tonnen.Tonnen;
import org.example.entities.obstakels.vlammetjes.Vlammetjes;
import org.example.entities.powerups.Hamers;
import org.example.entities.tekst.HealthText;
import org.example.entities.tekst.ScoreText;
import org.example.globals.Globals;
import org.example.scenes.GameScherm;

import java.util.List;
import java.util.Set;

public class SuperMax extends DynamicSpriteEntity implements KeyListener, Collided, Newtonian, SceneBorderTouchingWatcher {
    private DonkeyKong donkeyKong;
    private GameScherm gameScherm;
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

    public SuperMax(Coordinate2D initialLocation, HealthText healthText, ScoreText scoreText, DonkeyKong donkeyKong, GameScherm gameScherm) {
        super("sprites/SuperMax.png", initialLocation, new Size(40, 40), 4, 2);
        this.donkeyKong = donkeyKong;
        this.gameScherm = gameScherm;
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
            if (pressedKeys.contains(KeyCode.DOWN) && !Globals.hammerState) {
                climbing = true;
                movingVertically = true;
                setMotion(playerSpeed, 360d);
            } else if (pressedKeys.contains(KeyCode.UP) && !Globals.hammerState) {
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
                    if (Globals.hammerState) {
                        setAutoCycle(interval, 3);
                    } else {
                        setAutoCycle(interval, 1);
                    }
                }
            } else if (pressedKeys.contains(KeyCode.RIGHT)) {
                movingHorizontally = true;
                horizontalMotion = playerSpeed;
                if (onGround) {
                    setMotion(playerSpeed, 90d);
                    if (Globals.hammerState) {
                        setAutoCycle(interval, 2);
                    } else {
                        setAutoCycle(interval, 0);
                    }
                }
            }
        }

        if (pressedKeys.contains(KeyCode.SPACE) && onGround && !Globals.hammerState) {
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

            if (collider instanceof Hamers) {
                Hamers.hammerPickup(gameScherm);
                ((Hamers) collider).remove();
                Hamers.endingPowerUp(gameScherm);
            }

            if (collider instanceof InteractieveLadders) {
                canClimb = true;
                touchingLadder = true;
            }

            if (collider instanceof DK) {
                health--;
                healthText.setHealthText(health);

                setAnchorLocation(
                        new Coordinate2D(25, 450)
                );
            }

            if (collider instanceof Tonnen) {
                if (Globals.hammerState) {
                    score = score + 300;
                    Globals.SCORE = score;
                    scoreText.setScoreText(score);
                    ((Tonnen) collider).remove();
                } else {
                    health--;
                    healthText.setHealthText(health);

                    setAnchorLocation(
                            new Coordinate2D(25, 450)
                    );
                }
            }

            if (collider instanceof Vlammetjes) {
                if (Globals.hammerState) {
                    score = score + 500;
                    Globals.SCORE = score;
                    scoreText.setScoreText(score);
                    ((Vlammetjes) collider).remove();
                } else {
                    health--;
                    healthText.setHealthText(health);

                    setAnchorLocation(
                            new Coordinate2D(25, 450)
                    );
                }
            }
        }

        if (!touchingLadder) {
            climbing = false;
        }

        onGround = touchingGround;

        if (health == 0) {
            donkeyKong.setActiveScene(2);
        }
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
