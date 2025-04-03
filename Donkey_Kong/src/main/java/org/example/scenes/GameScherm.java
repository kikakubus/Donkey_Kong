package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import org.example.DonkeyKong;
import org.example.Hitbox.Hitbox;
import org.example.Hitbox.BrokenLadderHitbox;
import org.example.entities.obstakels.aap.DK;
import org.example.entities.obstakels.vlammetjes.BlauweVlammetjes;
import org.example.entities.obstakels.vlammetjes.RodeVlammetjes;
import org.example.entities.players.SuperMax;
import org.example.entities.spawners.TonnenSpawner;
import org.example.entities.tekst.HealthText;
import org.example.entities.tekst.ScoreText;
import org.example.maps.Maps;

import java.util.ArrayList;

public class GameScherm extends DynamicScene implements TileMapContainer, EntitySpawnerContainer {
    private DonkeyKong donkeyKong;
    private ArrayList<Hitbox> hitboxes = new ArrayList<>();

    public GameScherm(DonkeyKong donkeyKong) {
        this.donkeyKong = donkeyKong;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("Sound/Stage_1.mp3");
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        var healthText = new HealthText(
                new Coordinate2D(getWidth() / 4 , 10)
        );

        var scoreText = new ScoreText(
                new Coordinate2D(getWidth() / 2, 10)
        );

        var aap = new DK(
                new Coordinate2D(getWidth() / 1.5 , getHeight() / 8.8)
        );

        var superMax = new SuperMax(
                new Coordinate2D(25, 450),
                healthText, scoreText,
                donkeyKong,
                this
        );

        var rodeVlam = new RodeVlammetjes(
                new Coordinate2D(getWidth() / 2, 445)
        );

        var blauweVlam = new BlauweVlammetjes(
                new Coordinate2D(getWidth() / 2, 287)
        );


        addEntity(healthText);
        addEntity(scoreText);
        addEntity(aap);
        addEntity(superMax);
        addEntity(rodeVlam);
        addEntity(blauweVlam);

        hitboxes.add(new BrokenLadderHitbox("TopFloor-LeftSide", new Coordinate2D(120,140)));
        hitboxes.add(new BrokenLadderHitbox("FirstFloor-LeftSide", new Coordinate2D(150, 316)));
        hitboxes.add(new BrokenLadderHitbox("FirstFloor-RightSide", new Coordinate2D(390, 295)));
        hitboxes.add(new BrokenLadderHitbox("BottomFloor-RightSide", new Coordinate2D(338, 473)));

        for (Hitbox hitbox : hitboxes) {
            addEntity(hitbox);
        }
    }

    @Override
    public void setupTileMaps() {
        var gameMap = new Maps();

        addTileMap(gameMap);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new TonnenSpawner(getWidth(), getHeight()));
    }
}