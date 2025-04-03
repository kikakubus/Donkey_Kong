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

/**
 * Represents a scene where players can submit their score with their name.
 * Players can enter their name using keyboard input and submit their score.
 */
public class EindScherm extends StaticScene {
    private DonkeyKong donkeyKong;
    private TextEntity inputDisplay;
    private StringBuilder input;

    public EindScherm(DonkeyKong donkeyKong) {
        this.donkeyKong = donkeyKong;
        this.input = new StringBuilder();
    }

    /**
     * Sets up the visual background color of the score submission form scene.
     */
    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    /**
     * Sets up the entities (title, input display, submit button) displayed on the score submission form scene.
     * Handles keyboard input for entering player's name and updates the input display accordingly.
     */
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

        // Setup keyboard input handling
        setupInputHandling();

        // Submit score button
        //Button submitScoreButton = new SubmitScoreButton(new Coordinate2D(getWidth() / 2, 660), pacman);
        //addEntity(submitScoreButton);
    }

    /**
     * Sets up keyboard input handling for entering player's name.
     * Updates the input display and stores the player's name in globals.playerName.
     */
    private void setupInputHandling() {
        getScene().setOnKeyPressed(event -> handleKeyPress(event));
    }

    /**
     * Handles key press events for entering player's name.
     * Allows alphanumeric characters and space for input.
     * Updates the input display and stores the player's name in globals.playerName.
     *
     * @param event The KeyEvent representing the key press event.
     */
    private void handleKeyPress(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        if (keyCode.isLetterKey() || keyCode.isDigitKey() || keyCode == KeyCode.SPACE) {
            input.append(event.getText());
        } else if (keyCode == KeyCode.BACK_SPACE && input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
        }
        inputDisplay.setText(input.toString());
        //globals.playerName = input.toString();
    }
}