package arvauspeli;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Arvauspeli");
        stage.show();

        //Apua osio
        Button helpBack = new Button("Takaisin");
        Text helpTitle = new Text("Ohjeet");
        helpTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        GridPane helpComp = new GridPane();
        helpComp.add(helpTitle, 0, 0, 2, 1);
        Text helpText = new Text("Ensimmäisessä näkymässä kirjoita nimesi, "
                + "ja paina 'Aloita'." + "\n" + "Sinulle annetaan kysymyksiä ja jos vastaat oikein saat jatkaa."
                + "\n" + "Peli päättyy jos vastaat väärin.");
        helpComp.add(helpText, 0, 2);
        helpComp.add(helpBack, 0, 3);
        helpComp.setAlignment(Pos.CENTER);
        helpComp.setHgap(20);
        helpComp.setVgap(20);

        Scene helpview = new Scene(helpComp, 500, 400);

        //Päänäkymä
        Label nameLabel = new Label("Kirjoita nimesi: ");
        TextField nameField = new TextField();
        Button startGame = new Button("Aloita");
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
        components.add(startGame, 0, 5);
        components.setAlignment(Pos.CENTER);
        components.setHgap(20);
        components.setVgap(20);
        components.setPadding(new Insets(25, 25, 25, 25));

        Scene view = new Scene(components, 500, 400);
        stage.setScene(view);
        stage.show();
        
        //Pelinäkymä
        GridPane gameComponents = new GridPane();

        Label qField = new Label("Kyssäri");
        TextField ansField = new TextField();
        Button stop = new Button("Takaisin");
        gameComponents.setAlignment(Pos.CENTER);
        gameComponents.add(qField, 0, 1);
        gameComponents.add(ansField, 0, 3);
        gameComponents.add(stop, 0, 4);
        Scene gameView = new Scene(gameComponents, 500, 400);
        
        //Pisteet
        GridPane scoreComp = new GridPane();

        Label scoreTitle = new Label("Tämä osio on vielä kesken :(");
        
        Button backScore = new Button("Takaisin");
        scoreComp.setAlignment(Pos.CENTER);
        scoreComp.setHgap(20);
        scoreComp.setVgap(20);
        scoreComp.add(scoreTitle, 0, 1);
        scoreComp.add(backScore, 0, 6);
        Scene scoreView = new Scene(scoreComp, 500, 400);
        

        

        //ikkunoiden välillä seikkailu
        helpBack.setOnAction((event) -> {

            stage.setScene(view);
        });
        backScore.setOnAction((event) -> {

            stage.setScene(view);
        });
        score.setOnAction((event) -> {

            stage.setScene(scoreView);
        });
        startGame.setOnAction((event) -> {

            stage.setScene(gameView);
        });
        stop.setOnAction((event) -> {

            stage.setScene(view);
        });

        help.setOnAction((event) -> {

            stage.setScene(helpview);
        });

    }

    public static void main(String[] args) {
        launch(MainWindow.class);
    }
}
