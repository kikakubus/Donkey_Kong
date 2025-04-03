package org.example;

import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.EindScherm;
import org.example.scenes.GameScherm;
import com.github.hanyaeger.api.Size;
import org.example.scenes.HighScoreScherm;
import org.example.scenes.TitelScherm;

public class DonkeyKong extends YaegerGame
{
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Donkey Kong");
        setSize(new Size(500, 500));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitelScherm(this));
        addScene(1, new GameScherm(this));
        addScene(2, new EindScherm(this));
        addScene(3, new HighScoreScherm(this));
    }
}
