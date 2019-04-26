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

/**
 * Luokka pyörittää peliä sen pelaamisen aikana. Kysymysten lisäys tapahtuu myös
 * tässä luokassa.
 */
public class GameView extends MainView {

    private Questions questions;
    private Question question;
    private int diff = 1;

    /**
     *
     */
    public GameView() {
        this.questions = new Questions();

        questions.addQuestion("Mikä numeroista on isoin?", "13", "6", "1", "13", 1);
        questions.addQuestion("Minkä värinen oli Napoleonin" + "\n"
                + "valkoinen hevonen?", "Sininen", "Valkoinen", "Musta", "Valkoinen", 1);
        questions.addQuestion("Mikä ruuista on paras?", "Palanut grillimakkara",
                "Pitsa", "Pettuleipä", "Pitsa", 1);
        questions.addQuestion("Mikä seuraavista on Suomen pääkaupunki?", "Helsinki",
                "Tampere", "Lappeenranta", "Helsinki", 1);
        questions.addQuestion("Onko kuu tehty juustosta?", "On", "Ehkä", "Ei", "Ei", 1);
        questions.addQuestion("Onko tämä peli hyvä peli?", "On", "Ei", "Tää on paras", "Tää on paras", 1);
        questions.addQuestion("Minä vuonna Suomi itsenäistyi?", "2011", "1995", "1917", "1917", 2);
        questions.addQuestion("Paljonko on 365 + 420?", "785", "675", "805", "785", 2);
        questions.addQuestion("Minä vuonna iPhone julkaistiin?", "2005", "2007", "2009", "2007", 2);
        questions.addQuestion("Minä vuonna Suomi liittyi EU:hun?", "1992", "2001", "1995", "1995", 2);
        questions.addQuestion("Monta jääkiekon maailmanmestaruutta" + "\n"
                + "Suomi on voittanut?", "2", "1", "3", "2", 2);
        questions.addQuestion("Kuinka moni suomalainen on voittanut " + "\n"
                + " Nobel-palkinnon?", "2", "4", "0", "4", 2);
        questions.addQuestion("Monta rajanaapuria Suomella on?", "4", "2", "3", "3", 2);
        questions.addQuestion("Miten pitkä on maili?", "1,6km", "2km", "1,2km", "1,6km", 2);
        questions.addQuestion("Kuka on Suomen myydyin artisti?", "J.Karjalainen",
                "Kari Tapio", "Jari Sillanpää", "J.Karjalainen", 3);
        questions.addQuestion("Missä maakunnassa Kurikka sijaitsee?",
                "Pohjois-Karjala", "Etelä-Pohjanmaa", "Keski-Suomi", "Etelä-Pohjanmaa", 3);
        questions.addQuestion("Mikä maa voitti jalkapallon" + "\n" + " maailmanmestaruuden"
                + " vuonna 2014?", "Italia", "Saksa", "Brasilia", "Saksa", 2);
        questions.addQuestion("Minä päivänä Exactumin Unicafesta saa pitsaa?",
                "Perjantaina", "Keskiviikkona", "Maanantaina", "Perjantaina", 1);
        questions.addQuestion("Minkä ikäisenä saat ostaa yli 22% alkoholia?", "18", "21", "20", "20", 2);
        questions.addQuestion("Mikä on Australian pääkaupunki?", "Sydney", "Canberra", "Melbourne", "Canberra", 2);
        questions.addQuestion("Kuka on Led Zeppelinin laulaja?", "Robert Plant", "Jimmy Page", "John Paul Jones", "Robert Plant", 3);
        questions.addQuestion("Mikä on Suomen pisin joki?", "Vantaanjoki", "Kalajoki", "Kemijoki", "Kemijoki", 3);
        questions.addQuestion("Mikä seuraavaista ei ole tietotyyppi Javassa?", "Boolean", "Integer", "Letter", "Letter", 2);
        questions.addQuestion("Minkä ikäisenä Jimi Hendrix kuoli?", "23", "32", "27", "27", 3);

        this.question = questions.rollQuest(1);

    }

    /**
     *
     * @return
     */
    public Parent getGameview() {

        BorderPane main1 = new BorderPane();

        GridPane components = new GridPane();
        VBox questionsBox = new VBox();

        EndView endW = new EndView();

        Button k1 = new Button(this.question.getA());
        Button k2 = new Button(this.question.getB());
        Button k3 = new Button(this.question.getC());

        Label q1 = new Label(this.question.getQuest());

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
                this.question = questions.rollQuest(diff);
                q1.setText(question.getQuest());
                k1.setText(question.getA());
                k2.setText(question.getB());
                k3.setText(question.getC());
                counter.setText("Oikeita vastauksia: " + User.getScore());
                right.setText("");
                if (User.getScore() == 5) {
                    diff++;
                }
                if (User.getScore() == 15) {
                    diff++;
                }
                if (User.getScore() == 25) {
                    diff++;
                }
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
                this.question = questions.rollQuest(diff);
                q1.setText(question.getQuest());
                k1.setText(question.getA());
                k2.setText(question.getB());
                k3.setText(question.getC());
                counter.setText("Oikeita vastauksia: " + User.getScore());
                right.setText("");
                if (User.getScore() == 5) {
                    diff++;
                }
                if (User.getScore() == 15) {
                    diff++;
                }
                if (User.getScore() == 25) {
                    diff++;
                }
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
                this.question = questions.rollQuest(diff);
                q1.setText(question.getQuest());
                k1.setText(question.getA());
                k2.setText(question.getB());
                k3.setText(question.getC());
                counter.setText("Oikeita vastauksia: " + User.getScore());
                right.setText("");
                if (User.getScore() == 5) {
                    diff++;
                }
                if (User.getScore() == 15) {
                    diff++;
                }
                if (User.getScore() == 25) {
                    diff++;
                }
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
