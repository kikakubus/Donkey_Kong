package org.example.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.entities.obstakels.tonnen.BlauweTonnen;
import org.example.entities.obstakels.tonnen.BruineTonnen;

import java.util.Random;

public class TonnenSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;

    public TonnenSpawner(double SceneWidth, double SceneHeight) {
        super(1800);
        this.sceneWidth = SceneWidth;
        this.sceneHeight = SceneHeight;
    }

    @Override
    public void spawnEntities() {
        if (new Random().nextInt(5) < 4) {
            spawn(new BruineTonnen(new Coordinate2D(300, 130), 1));
        }
    }
}