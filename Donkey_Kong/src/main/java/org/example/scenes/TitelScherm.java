package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.DonkeyKong;
import org.example.buttons.Knop;
import org.example.buttons.StartKnop;

public class TitelScherm extends StaticScene {
    private DonkeyKong donkeyKong = new DonkeyKong();

    public TitelScherm(DonkeyKong donkeyKong) {
        this.donkeyKong = donkeyKong;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("Backgrounds/background_DK.jpg");
        setBackgroundAudio("Sound/Title_BGM.mp3");
        setBackgroundAudioVolume(0.10);
    }

    @Override
    public void setupEntities() {
        Knop startKnop = new StartKnop(new Coordinate2D(getWidth() / 2, 300), donkeyKong);
        addEntity(startKnop);
    }
}
