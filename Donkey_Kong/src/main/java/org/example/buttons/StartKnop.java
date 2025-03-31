package org.example.buttons;

import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.input.MouseButton;
import org.example.DonkeyKong;

/**
 * Represents a custom StartButton object, which is a specific type of Button.
 * This button is designed to start the game when clicked.
 */
public class StartKnop extends Knop {

    private DonkeyKong donkeyKong;

    public StartKnop(Coordinate2D initialLocation, DonkeyKong donkeyKong) {
        super(initialLocation, donkeyKong, "Play Game");
        this.donkeyKong = donkeyKong;
    }

    /**
     * Starts the game when the start button is clicked.
     * Sets the active scene to the game scene (1).
     *
     * @param button       The MouseButton that was pressed (not used in this implementation).
     * @param coordinate2d The coordinates of the mouse click (not used in this implementation).
     */
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
        donkeyKong.setActiveScene(1);
    }

}