package arvauspeli.gui;

import arvauspeli.logics.Score;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Luokka joka vastaa Pisteet-ikkunasta.
 */
public class ScoreView {

    Parent getScoreView() throws FileNotFoundException {

        GridPane scoreGrid = new GridPane();
        Text scoreText = new Text("Pistetaulukko");
        scoreText.setFont(Font.font("Verdana", 25));
        Text scores = new Text(Score.getScores("users.txt", 10));

        scoreGrid.setAlignment(Pos.CENTER);
        scoreGrid.setVgap(50);
        scoreGrid.setHgap(20);

        scoreGrid.add(scoreText, 1, 1);
        scoreGrid.add(scores, 2, 1);

        return scoreGrid;
    }

}
