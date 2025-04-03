package org.example.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.example.DonkeyKong;
import org.example.globals.Globals;

import java.io.FileWriter;
import java.io.IOException;

public class SubmitKnop extends Knop {
    private DonkeyKong donkeyKong;

    public SubmitKnop(Coordinate2D initialLocation, DonkeyKong donkeyKong) {
        super(initialLocation, donkeyKong, "Submit");
        this.donkeyKong = donkeyKong;
    }

    /**
     * Handles the mouse button press event.
     * Submits the score if the player's name is not null or empty, and then navigates to the end scene (scene index 3).
     *
     * @param button       The MouseButton that was pressed (not used in this implementation).
     * @param coordinate2d The coordinates of the mouse click (not used in this implementation).
     */
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
        if (Globals.playerName != null && !Globals.playerName.isEmpty()) {
            submitScore("scores.txt");
            donkeyKong.setActiveScene(0); // Navigate to the end scene
        }
    }

    /**
     * Submits the player's score to a specified file.
     * Appends the player's name and score to the file.
     *
     * @param fileName The name of the file to which the score will be saved.
     */
    public void submitScore(String fileName) {
        // Save the score to a file
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(Globals.playerName + " - " + Globals.SCORE + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}