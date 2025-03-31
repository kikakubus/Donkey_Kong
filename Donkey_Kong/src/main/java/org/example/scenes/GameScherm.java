package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import org.example.DonkeyKong;
import org.example.entities.obstakels.aap.DK;
import org.example.entities.obstakels.tonnen.BruineTonnen;
import org.example.maps.Maps;

public class GameScherm extends DynamicScene implements TileMapContainer {
    private DonkeyKong donkeyKong;

    public GameScherm(DonkeyKong donkeyKong) {
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

        var bruineTonnen = new BruineTonnen(
                new Coordinate2D(getWidth() / 1.5 , getHeight() / 1.6)
        );

        addEntity(aap);
        addEntity(bruineTonnen);
    }

    @Override
    public void setupTileMaps() {
        var gameMap = new Maps();

        addTileMap(gameMap);
    }
}