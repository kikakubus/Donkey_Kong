package org.example.entities.tekst;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HealthText extends DynamicTextEntity {

    public HealthText(Coordinate2D initialLocation) {
        super(initialLocation, "Health: ");
        setFont(Font.font("Roboto", FontWeight.NORMAL, 20));
        setFill(Color.WHITE);
    }

    public void setHealthText(int health) {
        setText("Health: " + health);
    }
}