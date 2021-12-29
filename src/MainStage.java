import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.*;

import java.io.FileInputStream;

public class MainStage extends Application {
    Car teslaObj = new ElectricCar("Tesla", "Model S", "Sedan", "Grey", ".\\images\\teslaS.jpg", 2020,
            5, 70, 21, 2000, 99000, 8, 400);
    Car leafObj = new ElectricCar("Nissan", "Leaf", "Hatchback", "Grey", ".\\images\\nissanLeaf.jpg", 2019,
            5, 45, 17, 1580, 50000, 6, 200);
    Car mercObj = new FuelCar("Mercedes", "E Class", "Sedan", "White", "Manual", "Diesel", ".\\images\\mercE.png",
            2021, 5, 80, 18, 1750, 80, 45);
    Car x70Obj = new FuelCar("Proton", "X70", "SUV", "Red", "Automatic", "Petrol", ".\\images\\protonX70.jpg",
            2019, 7, 50, 19, 1650, 60, 20.5);

    Car[] cars = {teslaObj, leafObj, mercObj, x70Obj};

    @Override
    public void start(Stage mainStage) throws Exception {

        GridPane gridpane1 = new GridPane(); //create gridpane
        gridpane1.setStyle("-fx-background-color: #b2dcf7");
        gridpane1.setPadding(new Insets(10, 10 ,10 ,10));
        gridpane1.getColumnConstraints().add(new ColumnConstraints(200)); //col 0
        gridpane1.getColumnConstraints().add(new ColumnConstraints(200)); //col 1
        gridpane1.getColumnConstraints().add(new ColumnConstraints(200)); //col 2
        gridpane1.getRowConstraints().add(new RowConstraints(30)); //row 0
        gridpane1.getRowConstraints().add(new RowConstraints(235)); //row 1
        gridpane1.getRowConstraints().add(new RowConstraints(235)); //row 2
        gridpane1.getRowConstraints().add(new RowConstraints(20)); //row 0
        gridpane1.setHgap(15);
        gridpane1.setVgap(10);

        GridPane gridpane2 = new GridPane();
        gridpane2.getColumnConstraints().add(new ColumnConstraints(100));
        gridpane2.getColumnConstraints().add(new ColumnConstraints(100));

        ImageView logo = new ImageView(new Image(new FileInputStream(".\\images\\logo.png")));
        logo.setFitWidth(200);

        logo.setPreserveRatio(true);
//        Text header1 = new Text(260, 28, "IIUM Car Rental");
//        header1.setFont(Font.font("Courier", FontWeight.BOLD,
//                26));

        //X70
        ImageView img1 = new ImageView(new Image(new FileInputStream(cars[0].getImgPath())));
        img1.setFitHeight(125);
        img1.setFitWidth(200);
        img1.setPreserveRatio(false);

        Label lbl1 = new Label(cars[0].getMake() + " " + cars[0].getModel());
        lbl1.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        VBox vbox1 = new VBox();
        vbox1.setPrefWidth(200);
        vbox1.setPrefHeight(235);
        vbox1.setPadding(new Insets(55, 0, 0 ,0));
        vbox1.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vbox1.getChildren().addAll(img1, lbl1);

        //leaf
        ImageView img2 = new ImageView(new Image(new FileInputStream(cars[1].getImgPath())));
        img2.setFitHeight(125);
        img2.setFitWidth(200);
        img2.setPreserveRatio(false);

        Label lbl2 = new Label(cars[1].getMake() + " " + cars[1].getModel());
        lbl2.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        VBox vbox2 = new VBox();
        vbox2.setPrefWidth(200);
        vbox2.setPrefHeight(235);
        vbox2.setPadding(new Insets(55, 0, 0 ,0));
        vbox2.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vbox2.getChildren().addAll(img2, lbl2);

        //merc
        ImageView img3 = new ImageView(new Image(new FileInputStream(cars[2].getImgPath())));
        img3.setFitHeight(125);
        img3.setFitWidth(200);
        img3.setPreserveRatio(false);

        Label lbl3 = new Label(cars[2].getMake() + " " + cars[2].getModel());
        lbl3.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        VBox vbox3 = new VBox();
        vbox3.setPrefWidth(200);
        vbox3.setPrefHeight(235);
        vbox3.setPadding(new Insets(55, 0, 0 ,0));
        vbox3.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vbox3.getChildren().addAll(img3, lbl3);

        //tesla
        ImageView img4 = new ImageView(new Image(new FileInputStream(cars[3].getImgPath())));
        img4.setFitHeight(125);
        img4.setFitWidth(200);
        img4.setPreserveRatio(false);

        Label lbl4 = new Label(cars[3].getMake() + " " + cars[3].getModel());
        lbl4.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        VBox vbox4 = new VBox();
        vbox4.setPrefWidth(200);
        vbox4.setPrefHeight(235);
        vbox4.setPadding(new Insets(55, 0, 0 ,0));
        vbox4.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vbox4.getChildren().addAll(img4, lbl4);

        //Car specs text area
        Label lblCarSpecs = new Label("Car Information");
        lblCarSpecs.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        TextArea carSpecs = new TextArea();
        carSpecs.setPrefWidth(170);
        carSpecs.setPrefHeight(190);
        carSpecs.setEditable(false);
        carSpecs.setStyle("-fx-border-color: grey; -fx-border-width: 1px");

        VBox vbox5 = new VBox();
        vbox5.setPrefWidth(200);
        vbox5.setPrefHeight(235);
        vbox5.setPadding(new Insets(0, 0, 0 ,0));
        vbox5.getChildren().addAll(lblCarSpecs, carSpecs);
//        vbox5.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");

        // Filters
        Label lblCostInfo = new Label("Filters");
        lblCostInfo.setFont(Font.font("Courier", FontWeight.BOLD,
                15));

        Label lblCarFuel = new Label("Car fuel:");
        lblCarFuel.setFont(Font.font("Courier", FontWeight.BOLD,
                10));

        CheckBox checkElectric = new CheckBox("Electric");
        CheckBox checkPetrol = new CheckBox("Petrol");
        CheckBox checkDiesel = new CheckBox("Diesel");
        CheckBox[] checkFuels = {checkDiesel, checkPetrol, checkElectric};

        Label lblMake = new Label("Make:");
        lblMake.setFont(Font.font("Courier", FontWeight.BOLD,
                10));
        CheckBox checkTesla = new CheckBox("Tesla");
        CheckBox checkProton = new CheckBox("Proton");
        CheckBox checkNissan = new CheckBox("Nissan");
        CheckBox checkMercedes = new CheckBox("Mercedes");
        CheckBox[] checkMakes = {checkMercedes, checkNissan, checkTesla, checkProton};

        Label lblTransmission = new Label("Transmission:");
        lblTransmission.setFont(Font.font("Courier", FontWeight.BOLD,
                10));
        CheckBox checkAutomatic = new CheckBox("Automatic");
        CheckBox checkManual = new CheckBox("Manual");
        CheckBox[] checkTransmissions = {checkAutomatic, checkManual};

        VBox vbox6 = new VBox();
        vbox6.setSpacing(1);
        vbox6.setPrefWidth(200);
        vbox6.setPrefHeight(235);
        vbox6.setPadding(new Insets(0, 0, 0 ,0));
        vbox6.getChildren().addAll(lblCostInfo, lblCarFuel, checkElectric, checkPetrol, checkDiesel, lblMake, checkMercedes, checkNissan, checkTesla, checkProton,
                lblTransmission, checkAutomatic, checkManual);

        // Filter right side
        Label lblSpacer = new Label("          ");
        lblSpacer.setFont(Font.font("Courier", FontWeight.BOLD,
                15));

        Label lblColour = new Label("Colour:");
        lblColour.setFont(Font.font("Courier", FontWeight.BOLD,
                10));

        CheckBox checkWhite = new CheckBox("White");
        CheckBox checkRed = new CheckBox("Red");
        CheckBox checkGrey = new CheckBox("Grey");

        Label lblYear = new Label("Year:");
        lblYear.setFont(Font.font("Courier", FontWeight.BOLD,
                10));
        TextField textYear = new TextField();
        textYear.setPromptText("Enter year");

        Label lblType = new Label("Type:");
        lblType.setFont(Font.font("Courier", FontWeight.BOLD,
                10));
        CheckBox checkSedan = new CheckBox("Sedan");
        CheckBox checkSuv = new CheckBox("SUV");
        CheckBox checkHatchback = new CheckBox("Hatchback");
        CheckBox[] checkTypes = {checkSedan, checkSuv, checkHatchback};

        VBox vbox7 = new VBox();
        vbox7.setSpacing(1);
        vbox7.setPrefWidth(200);
        vbox7.setPrefHeight(235);
        vbox7.setPadding(new Insets(0, 0, 0 ,0));
        vbox7.getChildren().addAll(lblSpacer, lblColour, checkWhite, checkRed, checkGrey, lblYear, textYear, lblType, checkSedan, checkSuv, checkHatchback);

        Button button = new Button("Confirm");
        button.setAlignment(Pos.CENTER);
        HBox hboxBtn = new HBox(button);
        hboxBtn.setPadding(new Insets(0 , 0, 0 ,65));

//        StackPane headerPane = new StackPane();
//        gridpane.getChildren().add(header1);
//        headerPane.setAlignment(header1, Pos.TOP_CENTER);
        gridpane1.add(logo, 1, 0);
        gridpane1.add(vbox1, 0, 1);
        gridpane1.add(vbox2, 1, 1);
        gridpane1.add(vbox3, 0, 2);
        gridpane1.add(vbox4, 1, 2);
        gridpane1.add(vbox5, 2, 1);
        gridpane1.add(gridpane2, 2, 2);
        gridpane1.add(hboxBtn, 2, 3);

        gridpane2.add(vbox6, 0, 0);
        gridpane2.add(vbox7, 1, 0);

        Scene scene1 = new Scene(gridpane1, 650, 570);

        mainStage.setTitle("IIUM Car Rental"); // Set the stage title
        mainStage.setScene(scene1); // Place the scene in the stage
        mainStage.setResizable(false);
        mainStage.show(); // Display the stage
    }
}
