import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.*;

public class MainStage extends Application {

    @Override
    public void start(Stage mainStage) throws Exception {
        Text header1 = new Text(260, 28, "IIUM Car Rental");
        header1.setFont(Font.font("Courier", FontWeight.BOLD,
                 26));

        StackPane headerPane = new StackPane();
        headerPane.getChildren().add(header1);
        headerPane.setAlignment(header1, Pos.TOP_CENTER);


        Scene scene1 = new Scene(headerPane, 700, 500);

        mainStage.setTitle("IIUM Car Rental"); // Set the stage title
        mainStage.setScene(scene1); // Place the scene in the stage
        mainStage.show(); // Display the stage

    }
}
