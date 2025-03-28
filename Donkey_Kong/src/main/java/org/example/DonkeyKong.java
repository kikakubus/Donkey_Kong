package org.example;

import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.TitelScherm;
import com.github.hanyaeger.api.Size;

public class DonkeyKong extends YaegerGame
{
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Donkey Kong");
        setSize(new Size(800, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitelScherm(this));
        //addScene(1, new GameScherm());
        //addScene(2, new EindScherm());
        //addScene(3, new ScoreLijst());
    }
}
