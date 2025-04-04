package org.example.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.entities.obstakels.tonnen.BlauweTonnen;
import org.example.entities.obstakels.tonnen.BruineTonnen;

import java.util.Random;

public class TonnenSpawner extends EntitySpawner {
    private double sceneWidth = 1.5;
    private final double SCENE_HEIGHT;

    public TonnenSpawner(double sceneWidth, final double SCENE_HEIGHT) {
        super(3000);
        this.sceneWidth = sceneWidth;
        this.SCENE_HEIGHT = SCENE_HEIGHT;
    }

    @Override
    public void spawnEntities() {
        if (new Random().nextInt(9) < 4) {
            spawn(new BlauweTonnen(new Coordinate2D(340, 130), 0.7));
        } else {
            spawn(new BruineTonnen(new Coordinate2D(300, 130), 0.7));
        }
    }
}