package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import org.example.DonkeyKong;
import org.example.Hitbox;
import org.example.RectangleHitbox;
import org.example.entities.obstakels.aap.DK;
import org.example.entities.players.SuperMax;
import org.example.entities.spawners.TonnenSpawner;
import org.example.entities.tekst.HealthText;
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
                new Coordinate2D(getWidth() / 9 , getHeight() / 9)
        );

        var aap = new DK(
                new Coordinate2D(getWidth() / 1.5 , getHeight() / 8.8)
        );

        var superMax = new SuperMax(
                new Coordinate2D(getWidth() / 1.3 , getHeight() / 1.5),
                healthText
        );

        addEntity(healthText);
        addEntity(aap);
        addEntity(superMax);

        hitboxes.add(new RectangleHitbox("TopFloor-LeftSide", new Coordinate2D(120,140)));
        hitboxes.add(new RectangleHitbox("FirstFloor-LeftSide", new Coordinate2D(150, 316)));
        hitboxes.add(new RectangleHitbox("FirstFloor-RightSide", new Coordinate2D(390, 295)));
        hitboxes.add(new RectangleHitbox("BottomFloor-RightSide", new Coordinate2D(338, 473)));

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