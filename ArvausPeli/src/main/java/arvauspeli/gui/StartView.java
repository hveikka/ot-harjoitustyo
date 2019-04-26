package arvauspeli.gui;

import arvauspeli.logics.User;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartView extends MainView {

    public StartView() {

    }

    public Parent getStart() {

        BorderPane main1 = new BorderPane();

        Label nameLabel = new Label("Kirjoita nimesi ja paina Enter");
        Label errorLabel = new Label("");
        TextField nameField = new TextField();

        Button help = new Button("Ohjeet");
        Button score = new Button("Pisteet");
        GridPane components = new GridPane();
        Text scenetitle = new Text("Arvauspeli");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        components.add(scenetitle, 0, 0, 2, 1);
        components.add(nameLabel, 0, 3);
        components.add(nameField, 0, 4);
        components.add(errorLabel, 0, 5);
        components.add(help, 0, 2);
        components.add(score, 1, 2);

        components.setAlignment(Pos.CENTER);
        components.setHgap(20);
        components.setVgap(20);
        components.setPadding(new Insets(25, 25, 25, 25));

        main1.setCenter(components);

        nameField.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (nameField.getText().length() < 1) {
                    errorLabel.setText("Ole hyvä ja kirjoita nimesi!");
                    errorLabel.setTextFill(Color.RED);
                    return;
                }
                if (nameField.getText().length() > 15) {
                    errorLabel.setText("Nimesi on liian pitkä!");
                    errorLabel.setTextFill(Color.RED);
                    return;
                }
                if (nameField.getText().matches(".*\\d.*")) {
                    errorLabel.setText("Nimessä ei saa olla numeroita!");
                    errorLabel.setTextFill(Color.RED);
                    return;
                }
                User.setUser(nameField.getText());
                errorLabel.setText("Hei " + User.getName() + "!");
                errorLabel.setTextFill(Color.BLACK);

            }
        });
        Button back = new Button("Takaisin");
        HelpView helpW = new HelpView();
        ScoreView scoreW = new ScoreView();
        help.setOnMouseClicked((event) -> {
            main1.setCenter(null);
            main1.setCenter(helpW.getHelpView());

            main1.setRight(back);
            back.setVisible(true);

        });
        back.setOnMouseClicked((event) -> {
            main1.setCenter(null);
            main1.setCenter(components);
            back.setVisible(false);

        });
        score.setOnMouseClicked((event) -> {
            main1.setCenter(null);
            try {
                main1.setCenter(scoreW.getScoreView());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StartView.class.getName()).log(Level.SEVERE, null, ex);
            }

            main1.setRight(back);
            back.setVisible(true);

        });

        return main1;
    }

}
