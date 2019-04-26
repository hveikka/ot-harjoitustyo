package arvauspeli.gui;

import arvauspeli.logics.User;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import arvauspeli.logics.Score;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

/**
 * Tämä luokka pitää huolen lopetusnäkmästä.
 */
public class EndView {

    Parent getEndView() throws FileNotFoundException, IOException, Exception {

        GridPane endGrid = new GridPane();
        endGrid.setVgap(10);
        endGrid.setHgap(10);
        endGrid.setPadding(new Insets(10, 10, 10, 10));
        Text endText1 = new Text("Hävisit pelin!");
        endText1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        endText1.setFill(Color.BLUE);

        endGrid.add(endText1, 1, 0);

        VBox vBox = new VBox();
        vBox.setSpacing(20);
        Text endText2 = new Text("Pisteesi: " + User.getScore());
        endText2.setFont(Font.font("verdana", 20));
        Text endText3 = new Text("Paina 'Lopeta peli' päästäksesi alkuun.");
        endText3.setFont(Font.font("verdana", 20));
        Text scoreText = new Text("Tuloksia");
        scoreText.setFont(Font.font("verdana", 20));
        Text score = new Text("Pisteet");
        vBox.getChildren().addAll(endText2, endText3, scoreText, score);

        endGrid.add(vBox, 1, 2);

        Score.writeScore(User.getName(), User.getScore());

        score.setText(Score.getScores(5));

        User.setScore(0);

        return endGrid;
    }

}
