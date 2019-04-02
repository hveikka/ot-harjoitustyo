package arvauspeli.gui;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HelpView {

    Parent getHelpView() {

        GridPane helpGrid = new GridPane();
        Text helpText = new Text("Arvauspelin ideana on valita oikein kolmesta\n"
                + "vaihtoehdosta. Kun olet valinnut vastauksesi \n"
                + "kirjoita se tekstikenttään ja paina 'Enter'. \n"
                + "\n"
                + "Ennen pelin aloittamista muista kirjoittaa \n"
                + "alussa olevaan kenttään nimesi ja painaa 'Enter'. \n"
                + "\n"
                + "Voit käydä vertailemassa tuloksia painamalla \n"
                + "'Pisteet'  aloitusnäkymässä. \n"
                + "\n"
                + "Onnea matkaan!");
        helpText.setFont(Font.font("Verdana", 15));

        helpGrid.setAlignment(Pos.CENTER);
        helpGrid.setVgap(20);
        helpGrid.setHgap(20);

        helpGrid.add(helpText, 1, 1);

        return helpGrid;
    }

}
