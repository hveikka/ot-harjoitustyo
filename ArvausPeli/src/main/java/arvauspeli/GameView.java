package arvauspeli;

import java.util.ArrayList;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameView extends Questions {
    private Questions kyss;
    private Question kys;
    private int nbr;

    public GameView() {
        this.kyss = new Questions();
        this.nbr = 0;
        this.kys = kyss.rollQuest();

    }

    public Parent getGameview() {


        GridPane asettelu = new GridPane();
        VBox questionsBox = new VBox();

        Label q1 = new Label(this.kys.getQuest());
        Label q2 = new Label(this.kys.getA());
        Label q3 = new Label(this.kys.getB());
        Label q4 = new Label(this.kys.getC());

        questionsBox.getChildren().addAll(q1, q2, q3, q4);

        TextField ansField = new TextField();

        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(10, 10, 10, 10));

        Label ansButton = new Label("Kirjoita vastauksesi ja paina 'Enter'");
        Label right = new Label("");
        Label counter = new Label("Oikeita vastauksia: " + nbr);
        asettelu.add(questionsBox, 2, 0);
        asettelu.add(ansField, 2, 1);
        asettelu.add(ansButton, 2, 2);
        asettelu.add(right, 0, 2);
        asettelu.add(counter, 0, 0);

        ansField.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {

            String kaannos = ansField.getText();

            if (ansField.getText().equals(kys.getOikea())) {

                nbr++;


                this.kys = kyss.rollQuest();
                ansField.clear();
                q1.setText(kys.getQuest());
                q2.setText(kys.getA());
                q3.setText(kys.getB());
                q4.setText(kys.getC());
                counter.setText("Oikeita vastauksia: " + nbr);
                right.setText("");

            } else {
                
                right.setText("Väärin! Aloita uudestaan.");
                nbr = 0;
                counter.setText("Oikeita vastauksia: " + nbr);
                ansField.clear();
                return;
            }
            
            }

            

        });

        return asettelu;

    }

}
