package org.example.scenes;


import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.AnchorPoint;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.DonkeyKong;
import org.example.buttons.Knop;
import org.example.buttons.SubmitKnop;
import org.example.globals.Globals;

public class EindScherm extends StaticScene {
    private DonkeyKong donkeyKong;
    private TextEntity inputDisplay;
    private StringBuilder input;

    public EindScherm(DonkeyKong donkeyKong) {
        this.donkeyKong = donkeyKong;
        this.input = new StringBuilder();
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        // Title "Enter name:"
        var title = new TextEntity(new Coordinate2D(getWidth() / 2, 100), "Enter name:");
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 50));
        addEntity(title);

        // Display for player's name input
        inputDisplay = new TextEntity(new Coordinate2D(getWidth() / 3, 300), "");
        inputDisplay.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        inputDisplay.setFill(Color.WHITE);
        inputDisplay.setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        addEntity(inputDisplay);

        setupInputHandling();

        // Submit score button
        Knop submitScoreButton = new SubmitKnop(new Coordinate2D(getWidth() / 2, 400), donkeyKong);
        addEntity(submitScoreButton);
    }

    private void setupInputHandling() {
        getScene().setOnKeyPressed(event -> handleKeyPress(event));
    }

    private void handleKeyPress(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        if (keyCode.isLetterKey() || keyCode.isDigitKey() || keyCode == KeyCode.SPACE) {
            input.append(event.getText());
        } else if (keyCode == KeyCode.BACK_SPACE && input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
        }
        inputDisplay.setText(input.toString());
        Globals.playerName = input.toString();
    }
}