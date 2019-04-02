package arvauspeli;

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

public class GameView extends StartWindow {

    private Questions questions;
    private Question question;
    private int score;

    public GameView() {
        this.questions = new Questions();
        this.score = 0;

        questions.addQuestion("Mikä numeroista on isoin?", "2", "3", "1", "3");
        questions.addQuestion("Mikä ruuista on paras?", "Pulla", "Pitsa", "Nauris", "Pitsa");
        questions.addQuestion("Kuinka vanha olen?", "26", "22", "1", "22");
        questions.addQuestion("Minä vuonna Suomi itsenäistyi?", "2011", "1995", "1917", "1917");

        this.question = questions.rollQuest();

    }

    public Parent getGameview() {

        GridPane components = new GridPane();
        VBox questionsBox = new VBox();

        Label q1 = new Label(this.question.getQuest());
        Label q2 = new Label(this.question.getA());
        Label q3 = new Label(this.question.getB());
        Label q4 = new Label(this.question.getC());

        questionsBox.getChildren().addAll(q1, q2, q3, q4);

        TextField ansField = new TextField();

        components.setAlignment(Pos.CENTER);
        components.setVgap(10);
        components.setHgap(10);
        components.setPadding(new Insets(10, 10, 10, 10));

        String lol = StartWindow.getNimi();
        Label ansButton = new Label("Kirjoita vastauksesi ja paina 'Enter'");
        Label right = new Label("");
        Label counter = new Label("Oikeita vastauksia: " + score);
        components.add(questionsBox, 2, 0);
        components.add(ansField, 2, 1);
        components.add(ansButton, 2, 2);
        components.add(right, 0, 2);
        components.add(counter, 0, 0);

        ansField.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {

                String kaannos = ansField.getText();

                if (ansField.getText().equals(question.getOikea())) {

                    score++;

                    this.question = questions.rollQuest();
                    ansField.clear();
                    q1.setText(question.getQuest());
                    q2.setText(question.getA());
                    q3.setText(question.getB());
                    q4.setText(question.getC());
                    counter.setText("Oikeita vastauksia: " + score);
                    right.setText("");

                } else {

                    right.setText("Väärin! Aloita uudestaan.");
                    score = 0;
                    counter.setText("Oikeita vastauksia: " + score);
                    ansField.clear();
                    return;
                }

            }

        });

        return components;

    }

}
