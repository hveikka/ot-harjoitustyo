package arvauspeli;

import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) {
        Questions kyssarit = new Questions();

        StartWindow startW = new StartWindow();
        GameView gameW = new GameView();

        BorderPane mainComp = new BorderPane();

        HBox mainbox = new HBox();

        mainbox.setPadding(new Insets(20, 20, 20, 20));

        mainbox.setSpacing(10);

        Button startButton = new Button("Aloita peli");
        Button endButton = new Button("Lopeta peli");
        endButton.setVisible(false);
        mainbox.getChildren().addAll(endButton);
        mainComp.setTop(mainbox);
        mainComp.setBottom(startButton);
        mainComp.setAlignment(startButton, Pos.BOTTOM_CENTER);
        mainComp.setStyle("-fx-padding: 50;");

        startButton.setOnMouseClicked((event) -> {
            mainComp.setCenter(gameW.getGameview());
            startButton.setVisible(false);
            endButton.setVisible(true);
            gameW.getGameview();

        });

        endButton.setOnMouseClicked((event) -> {
            mainComp.setCenter(startW.getStart());
            startButton.setVisible(true);
            endButton.setVisible(false);

        });

        Scene mainView = new Scene(mainComp, 600, 480);

        mainComp.setCenter(startW.getStart());
        stage.setScene(mainView);

        stage.show();

    }

    public static void main(String[] args) {
        launch(MainWindow.class);
    }
}
