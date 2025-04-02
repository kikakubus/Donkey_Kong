package org.example.entities.tekst;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreText extends DynamicTextEntity {

    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 20));
        setFill(Color.WHITE);
    }

    public void setScoreText(int Score) {
        setText("Score: " + Score);
    }
}