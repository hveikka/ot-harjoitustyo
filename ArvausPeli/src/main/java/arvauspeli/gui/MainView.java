package arvauspeli.gui;

import arvauspeli.logics.User;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage stage) {

        StartView startW = new StartView();
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
        BorderPane.setAlignment(startButton, Pos.BOTTOM_CENTER);
        mainComp.setStyle("-fx-padding: 50;");

        startButton.setOnMouseClicked((event) -> {
            if (User.getName() == null) {
                return;
            }
            mainComp.setCenter(gameW.getGameview());
            startButton.setVisible(false);
            endButton.setVisible(true);

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
        launch(MainView.class);
    }
}
