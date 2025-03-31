package org.example.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;

import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.DonkeyKong;

/**
 * Represents a custom Button object with specific behavior and appearance.
 * This button is designed to interact with a Pacman object.
 */
public abstract class Knop extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private DonkeyKong donkeyKong;

    /**
     * Constructs a new Button object with the specified initial location, Pacman object,
     * and text to display on the button.
     *
     * @param initialLocation The initial location (Coordinate2D) of the button.
     * @param donkeyKong          The Pacman object associated with the button.
     * @param tekst           The text to display on the button.
     */
    public Knop(Coordinate2D initialLocation, DonkeyKong donkeyKong, String tekst) {
        super(initialLocation, tekst);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.YELLOW);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        this.donkeyKong = donkeyKong;
    }

    /**
     * {@inheritDoc}
     * This method is intended for polymorphic use and should be overridden by subclasses.
     */
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
        // For override
    }

    /**
     * {@inheritDoc}
     * Changes the color of the button to red and sets the cursor to a hand cursor
     * when the mouse pointer enters the button's area.
     */
    @Override
    public void onMouseEntered() {
        setFill(Color.RED);
        setCursor(Cursor.HAND);
    }

    /**
     * {@inheritDoc}
     * Changes the color of the button back to yellow and sets the cursor to the default cursor
     * when the mouse pointer exits the button's area.
     */
    @Override
    public void onMouseExited() {
        setFill(Color.YELLOW);
        setCursor(Cursor.DEFAULT);
    }
}