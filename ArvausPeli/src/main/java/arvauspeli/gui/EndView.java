
package arvauspeli.gui;

import arvauspeli.logics.User;
import javafx.geometry.Insets;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color; 


public class EndView {
    
    Parent getEndView() {
        
        GridPane endGrid = new GridPane();
        endGrid.setVgap(10);
        endGrid.setHgap(10);
        endGrid.setPadding(new Insets(10, 10, 10, 10));
        Text endText1 = new Text("Hävisit pelin!");
        endText1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        endText1.setFill(Color.BLUE); 

        endGrid.add(endText1, 1, 0);
        
        VBox vBox = new VBox(); 
        vBox.setSpacing(20);
        Text endText2 = new Text("Pisteesi: " + User.getScore());
        endText2.setFont(Font.font("verdana", 20));
        Text endText3 = new Text("Paina 'Lopeta peli' päästäksesi alkuun.");
        endText3.setFont(Font.font("verdana", 20));
        vBox.getChildren().addAll(endText2, endText3);
        
        
        endGrid.add(vBox, 1, 2);
        User.setScore(0);
        
        return endGrid;
    }
    
}
