package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import org.example.DonkeyKong;
import org.example.entities.obstakels.aap.DK;
import org.example.entities.obstakels.tonnen.BruineTonnen;
import org.example.entities.players.SuperMax;
import org.example.maps.Maps;

public class GameScherm extends DynamicScene implements TileMapContainer {
    private DonkeyKong donkeyKong;

    public GameScherm(DonkeyKong donkeyKong) {
        //setBackgroundAudio("Sound/Stage_1.mp3");
        this.donkeyKong = donkeyKong;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        var aap = new DK(
                new Coordinate2D(getWidth() / 1.5 , getHeight() / 8.8)
        );

        var superMax = new SuperMax(
                new Coordinate2D(getWidth() / 1.3 , getHeight() / 1.5)
        );

        var bruineTonnen = new BruineTonnen(
                new Coordinate2D(getWidth() / 1.5 , getHeight() / 1.6)
        );

        addEntity(aap);
        addEntity(superMax);
        addEntity(bruineTonnen);
    }

    @Override
    public void setupTileMaps() {
        var gameMap = new Maps();

        addTileMap(gameMap);
    }
}