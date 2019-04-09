package arvauspeli.gui;

import arvauspeli.logics.User;
import arvauspeli.gui.MainView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartView extends MainView { 

    public static String nimi;
    User user = new User();

    public StartView() {

    }

    public Parent getStart() {

        BorderPane main1 = new BorderPane();

        Label nameLabel = new Label("Kirjoita nimesi ja paina Enter");
        TextField nameField = new TextField();

        Button help = new Button("Ohjeet");
        Button score = new Button("Pisteet");
        GridPane components = new GridPane();
        Text scenetitle = new Text("Arvauspeli");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        components.add(scenetitle, 0, 0, 2, 1);
        components.add(nameLabel, 0, 3);
        components.add(nameField, 0, 4);
        components.add(help, 0, 2);
        components.add(score, 1, 2);

        components.setAlignment(Pos.CENTER);
        components.setHgap(20);
        components.setVgap(20);
        components.setPadding(new Insets(25, 25, 25, 25));

        main1.setCenter(components);

        nameField.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                user.setUser(nameField.getText());
                scenetitle.setText("Hei " + user.getName() + "!");

            }
        });
        Button back = new Button("Takaisin");
        HelpView helpW = new HelpView();
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
            score.setText("Ei toimi vielä");

        });

        return main1;
    }

    public static String getNimi() {
        return nimi;
    }
}
