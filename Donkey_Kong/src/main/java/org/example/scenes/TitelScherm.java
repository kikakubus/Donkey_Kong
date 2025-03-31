package org.example.scenes;

import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.DonkeyKong;

public class TitelScherm extends StaticScene {
   private DonkeyKong donkeyKong;

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

    }
}
