package arvauspeli;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartWindow {

    public String nimi;

    public StartWindow() {

    }

    public Parent getStart() {

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

        nameField.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                this.nimi = nameField.getText();
                scenetitle.setText("Hei " + nimi + "!");
                
            }
        });

        return components;
    }

    public String getNimi() {
        return nimi;
    }
}
