package arvauspeli.gui;

import arvauspeli.logics.Question;
import arvauspeli.logics.Questions;
import arvauspeli.logics.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GameView extends MainView {

    private Questions questions;
    private Question question;

    public GameView() {
        this.questions = new Questions();

        questions.addQuestion("Mikä numeroista on isoin?", "13", "6", "1", "13");
        questions.addQuestion("Mikä ruuista on paras?", "Palanut grillimakkara",
                "Pitsa", "Pettuleipä", "Pitsa");
        questions.addQuestion("Monta munaa on tiussa", "26", "22", "12", "12");
        questions.addQuestion("Minä vuonna Suomi itsenäistyi?", "2011", "1995", "1917", "1917");
        questions.addQuestion("Mikä maa voitti jalkapallon" + "\n" + " maailmanmestaruuden"
                + " vuonna 2014?", "Italia", "Saksa", "Brasilia", "Saksa");
        questions.addQuestion("Minä päivänä Exactumin Unicafesta saa pitsaa?",
                "Perjantaina", "Keskiviikkona", "Maanantaina", "Perjantaina");
        questions.addQuestion("Minkä ikäisenä saat ostaa yli 22% alkoholia?", "18", "21", "20", "20");
        questions.addQuestion("Mikä on Australian pääkaupunki?", "Sydney", "Canberra", "Melbourne", "Canberra");
        questions.addQuestion("Kuka on Led Zeppelinin laulaja?", "Robert Plant", "Jimmy Page", "John Paul Jones", "Robert Plant");
        questions.addQuestion("Mikä on Suomen pisin joki?", "Vantaanjoki", "Kalajoki", "Kemijoki", "Kemijoki");
        questions.addQuestion("Mikä seuraavaista ei ole tietotyyppi Javassa?", "Boolean", "Integer", "Letter", "Letter");

        this.question = questions.rollQuest();

    }

    public Parent getGameview() {

        BorderPane main1 = new BorderPane();

        GridPane components = new GridPane();
        VBox questionsBox = new VBox();

        EndView endW = new EndView();

        Button k1 = new Button(this.question.getA());
        Button k2 = new Button(this.question.getB());
        Button k3 = new Button(this.question.getC());

        Label q1 = new Label(this.question.getQuest());
        Label q2 = new Label(this.question.getA());
        Label q3 = new Label(this.question.getB());
        Label q4 = new Label(this.question.getC());

        questionsBox.getChildren().addAll(q1, k1, k2, k3);
        questionsBox.setSpacing(10);

        components.setAlignment(Pos.CENTER);
        components.setVgap(10);
        components.setHgap(10);
        components.setPadding(new Insets(10, 10, 10, 10));

        Label ansButton = new Label("Klikkaa oikeaa vastausta");
        Label right = new Label("");
        Label counter = new Label("Oikeita vastauksia: " + User.getScore());
        components.add(questionsBox, 2, 0);
        components.add(ansButton, 2, 2);
        components.add(right, 0, 2);
        components.add(counter, 0, 0);

        main1.setCenter(components);

        k1.setOnMouseClicked((event) -> {
            if (k1.getText().equals(question.getOikea())) {
                User.setScore(User.getScore() + 1);
                this.question = questions.rollQuest();
                q1.setText(question.getQuest());
                k1.setText(question.getA());
                k2.setText(question.getB());
                k3.setText(question.getC());
                counter.setText("Oikeita vastauksia: " + User.getScore());
                right.setText("");
            } else {
                main1.setCenter(null);
                try {
                    main1.setCenter(endW.getEndView());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        k2.setOnMouseClicked((event) -> {
            if (k2.getText().equals(question.getOikea())) {
                User.setScore(User.getScore() + 1);
                this.question = questions.rollQuest();
                q1.setText(question.getQuest());
                k1.setText(question.getA());
                k2.setText(question.getB());
                k3.setText(question.getC());
                counter.setText("Oikeita vastauksia: " + User.getScore());
                right.setText("");

            } else {
                main1.setCenter(null);
                try {
                    main1.setCenter(endW.getEndView());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        k3.setOnMouseClicked((event) -> {
            if (k3.getText().equals(question.getOikea())) {
                User.setScore(User.getScore() + 1);
                this.question = questions.rollQuest();
                q1.setText(question.getQuest());
                k1.setText(question.getA());
                k2.setText(question.getB());
                k3.setText(question.getC());
                counter.setText("Oikeita vastauksia: " + User.getScore());
                right.setText("");
            } else {
                main1.setCenter(null);
                try {
                    main1.setCenter(endW.getEndView());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        return main1;

    }

}
