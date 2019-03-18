import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class BattleEncounter{
    public static void display(String title, String message){
        Stage window = new Stage();
        //Sets title
        window.setTitle(title);
        //Sets the width of the title
        window.setMinWidth(640);

        //For some reason I need to button to compile
        Label lable = new Label();
        lable.setText(message);
        Button closeButton = new Button("close the window");
        closeButton.setOnAction(e -> window.close());

        //New VBox
        VBox layout = new VBox(640);
        layout.getChildren().addAll(lable, closeButton);

        //creates the new scene
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        //The bug I encountered is that when I open a new scene, the previous scene still functions for some reason
    }
}