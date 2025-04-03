package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.DonkeyKong;
import org.example.buttons.TerugKnop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HighScoreScherm extends StaticScene {
    private DonkeyKong donkeyKong;

    public HighScoreScherm(DonkeyKong donkeyKong) {
        this.donkeyKong = donkeyKong;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        // Read scores from file and sort them in descending order
        List<String> scores = readScoresFromFile("scores.txt");
        scores.sort(new Comparator<String>() {
            public int compare(String a, String b) {
                int scoreA = Integer.parseInt(a.split("-")[1].trim());
                int scoreB = Integer.parseInt(b.split("-")[1].trim());
                return Integer.compare(scoreB, scoreA); // Sort in descending order
            }
        });

        // Display top scores on the scene
        int yOffset = 50;
        int max = 10;
        if (scores.size() < max) {
            max = scores.size();
        }
        for (int i = 0; i < max; i++) {
            TextEntity scoreText = new TextEntity(new Coordinate2D(100, yOffset), (i + 1) + ". " + scores.get(i));
            scoreText.setFill(Color.WHITE);
            scoreText.setFont(Font.font("Roboto", FontWeight.NORMAL, 45));
            addEntity(scoreText);
            yOffset += 50;
        }

        // Add back button to return to the previous scene
        TerugKnop backButton = new TerugKnop(new Coordinate2D(getWidth() / 2, 460), donkeyKong);
        addEntity(backButton);
    }

    /**
     * Reads scores from a file and returns them as a list of strings.
     *
     * @param filePath The path to the file containing scores.
     * @return A list of strings representing scores read from the file.
     */
    private List<String> readScoresFromFile(String filePath) {
        List<String> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                scores.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }
}