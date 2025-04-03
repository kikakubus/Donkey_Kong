package org.example.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import org.example.globals.Globals;
import org.example.scenes.GameScherm;

import java.util.Timer;
import java.util.TimerTask;

public class Hamers extends SpriteEntity implements Collider {
    public static Timer timer = new Timer();

    public Hamers(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }

    public static void hammerPickup(GameScherm gameScherm) {
        Globals.hammerState = true;
        gameScherm.setBackgroundAudio("Sound/Hammer.mp3");
    }

    public static void endingPowerUp(GameScherm gameScherm) {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Globals.hammerState = false;
                gameScherm.setBackgroundAudio("Sound/Stage_1.mp3");
            }

        }, Globals.powerUpTimer);
    }
}
