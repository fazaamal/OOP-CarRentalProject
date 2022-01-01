import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.*;
import org.w3c.dom.Node;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class MainStage extends Application {
    //Initialising car objects
    private Car teslaObj = new ElectricCar("Tesla", "Model S", "Sedan", "Grey", ".\\images\\teslaS.jpg", 2020,
            5, 70, 21, 2000, 99000, 8, 400);
    private Car leafObj = new ElectricCar("Nissan", "Leaf", "Hatchback", "Grey", ".\\images\\nissanLeaf.jpg", 2019,
            5, 45, 17, 1580, 50000, 6, 200);
    private Car kiaObj = new ElectricCar("Kia", "EV6", "Hatchback", "Red", ".\\images\\kia.jpg", 2021,
            5, 55, 17, 2500, 82500, 6, 400);
    private Car mercObj = new FuelCar("Mercedes", "E Class", "Sedan", "White", "Manual", "Diesel", ".\\images\\mercE.png",
            2021, 5, 80, 18, 1750, 80, 45);
    private Car x70Obj = new FuelCar("Proton", "X70", "SUV", "Red", "Automatic", "Petrol", ".\\images\\protonX70.jpg",
            2019, 7, 50, 19, 1650, 60, 20.5);
    private Car peroduaObj = new FuelCar("Perodua", "Myvi", "Subcompact", "Blue", "Automatic", "Petrol", ".\\images\\myvi.jpg",
            2018, 5, 30, 16, 1300, 40, 20.5);
    private Car fordObj = new FuelCar("Ford", "F150", "4x4 Pickup Truck", "Black", "Manual", "Diesel" , ".\\images\\f150.jpg",
            2021, 6, 65, 31, 4500, 120, 20);

    private Car[] cars = {teslaObj, leafObj, mercObj, x70Obj, kiaObj, peroduaObj, fordObj};
    private int currPage = 0;

    @Override
    public void start(Stage mainStage) throws Exception{

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

        //Top left listing
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

        //Top right lsting
        ImageView img2 = new ImageView();
        img2.setFitHeight(125);
        img2.setFitWidth(200);
        img2.setPreserveRatio(false);

        Label lbl2 = new Label();
        lbl2.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        VBox vbox2 = new VBox();
        vbox2.setPrefWidth(200);
        vbox2.setPrefHeight(235);
        vbox2.setPadding(new Insets(55, 0, 0 ,0));
        vbox2.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vbox2.getChildren().addAll(img2, lbl2);

        //Bottom left listing
        ImageView img3 = new ImageView();
        img3.setFitHeight(125);
        img3.setFitWidth(200);
        img3.setPreserveRatio(false);

        Label lbl3 = new Label();
        lbl3.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        VBox vbox3 = new VBox();
        vbox3.setPrefWidth(200);
        vbox3.setPrefHeight(235);
        vbox3.setPadding(new Insets(55, 0, 0 ,0));
        vbox3.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vbox3.getChildren().addAll(img3, lbl3);

        //Bottom right listing
        ImageView img4 = new ImageView();
        img4.setFitHeight(125);
        img4.setFitWidth(200);
        img4.setPreserveRatio(false);

        Label lbl4 = new Label();
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
        carSpecs.setPrefHeight(210);
        carSpecs.setEditable(false);
        carSpecs.setStyle("-fx-border-color: grey; -fx-border-width: 1px");

        VBox vbox5 = new VBox();
        vbox5.setPrefWidth(200);
        vbox5.setPrefHeight(235);
        vbox5.setPadding(new Insets(0, 0, 0 ,0));
        vbox5.getChildren().addAll(lblCarSpecs, carSpecs);

        // Filter left side
        Label lblCostInfo = new Label("Filters");
        lblCostInfo.setFont(Font.font("Courier", FontWeight.BOLD,
                15));

        Label lblCarFuel = new Label("Fuel:");
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

        Label lblPrice = new Label("Max. price (RM):");
        lblPrice.setFont(Font.font("Courier", FontWeight.BOLD,
                10));

        TextField textPrice = new TextField();
        textPrice.setPromptText("Enter max price");

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
        vbox7.getChildren().addAll(lblSpacer, lblColour, checkWhite, checkRed, checkGrey, lblPrice, textPrice, lblType, checkSedan, checkSuv, checkHatchback);

        Button buttonConfirm = new Button("Confirm");
        buttonConfirm.setAlignment(Pos.CENTER);
        HBox hboxBtnConfirm = new HBox(buttonConfirm);
        hboxBtnConfirm.setPadding(new Insets(0 , 0, 0 ,65));

        //Page buttons
        Button buttonPrev = new Button("Previous page");
        buttonPrev.setAlignment(Pos.CENTER);
        buttonPrev.setDisable(true);
        HBox hboxBtnPrev = new HBox(buttonPrev);
        hboxBtnPrev.setPadding(new Insets(0 , 0, 0 ,65));

        Button buttonNext = new Button("Next page");
        buttonNext.setAlignment(Pos.CENTER);
        HBox hboxBtnNext = new HBox(buttonNext);
        hboxBtnNext.setPadding(new Insets(0 , 0, 0 ,65));

        //Click event handling

        vbox1.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            if(source == vbox1) {
                displayInfo(carSpecs, cars[currPage+0]);
            }
        });

        vbox2.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            if(source == vbox2) {
                displayInfo(carSpecs, cars[currPage+1]);
            }
        });

        vbox3.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            if(source == vbox3) {
                displayInfo(carSpecs, cars[currPage+2]);
            }
        });

        vbox4.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            if(source == vbox4) {
                displayInfo(carSpecs, cars[currPage+3]);
            }
        });

        VBox[] vboxes = {vbox1, vbox2, vbox3, vbox4};
        Label[] lbls = {lbl1, lbl2, lbl3, lbl4};
        ImageView[] imgs = {img1, img2, img3, img4};

        buttonNext.setOnMouseClicked((event) ->{    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            try{
                if(source == buttonNext) {
                    currPage += 1;
                    System.out.println(currPage);
                    if((currPage+1)*4>=cars.length){
                        buttonNext.setDisable(true);
                    }else{
                        buttonNext.setDisable(true);
                    }
                    if((currPage*4-4)<0){
                        buttonPrev.setDisable(true);
                    }else{
                        buttonPrev.setDisable(false);
                    }
                    loadListingsOnPageChange(gridpane1, vboxes, lbls, imgs);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        buttonPrev.setOnMouseClicked((event) ->{    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            try{
                if(source == buttonPrev) {
                    currPage -= 1;
                    buttonNext.setDisable(false);
                    System.out.println(currPage);

                    if((currPage*4-4)<0){
                        buttonPrev.setDisable(true);
                    }else{
                        buttonPrev.setDisable(false);
                    }

                    loadListingsOnPageChange(gridpane1, vboxes, lbls, imgs);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        //Add gridpane children
        gridpane1.add(logo, 1, 0);
        gridpane1.add(vbox5, 2, 1);
        gridpane1.add(gridpane2, 2, 2);
        gridpane1.add(hboxBtnConfirm, 2, 3);
        gridpane1.add(hboxBtnPrev, 0, 3);
        gridpane1.add(hboxBtnNext, 1, 3);

        gridpane2.add(vbox6, 0, 0);
        gridpane2.add(vbox7, 1, 0);

        loadListings(cars, gridpane1, vboxes, lbls, imgs);

        Scene scene1 = new Scene(gridpane1, 660, 570);

        mainStage.setTitle("IIUM Car Rental"); // Set the stage title
        mainStage.setScene(scene1); // Place the scene in the stage
        mainStage.setResizable(false);
        mainStage.show(); // Display the stage
    }

    public void loadListings(Car[] cars, GridPane gridpane, VBox[] vboxes, Label[] lbls, ImageView[] imgs) throws FileNotFoundException {
        int len = cars.length;
        if(len>4){
            len = 4;
        }


        for(int i=0; i<len; i++){
            imgs[i].setImage(new Image(new FileInputStream(cars[i].getImgPath())));
            lbls[i].setText(cars[i].getMake() + " " + cars[i].getModel());
            if(i==0){
                gridpane.add(vboxes[i], 0, 1);
            }else if(i==1){
                gridpane.add(vboxes[i], 1, 1);
            }else if(i==2){
                gridpane.add(vboxes[i], 0, 2);
            }else{
                gridpane.add(vboxes[i], 1, 2);
            }
        }
    }

    public void loadListingsOnPageChange(GridPane gridpane, VBox[] vboxes, Label[] lbls, ImageView[] imgs) throws FileNotFoundException{

        int max, len = cars.length;
        if((currPage*4 + 4) < len){
            max = currPage*4 + 4;
        }else{
            max = len;
        }

        for(int i=0; i<4; i++){
            gridpane.getChildren().remove(vboxes[i]);
        }

        for(int i=(currPage*4); i<(max); i++){
            imgs[i-currPage*4].setImage(new Image(new FileInputStream(cars[i].getImgPath())));
            lbls[i-currPage*4].setText(cars[i].getMake() + " " + cars[i].getModel());


            if(i-currPage*4==0){
                gridpane.add(vboxes[i-currPage*4], 0, 1);
            }else if(i-currPage*4==1){
                gridpane.add(vboxes[i-currPage*4], 1, 1);
            }else if(i-currPage*4==2){
                gridpane.add(vboxes[i-currPage*4], 0, 2);
            }else if(i-currPage*4==3){
                gridpane.add(vboxes[i-currPage*4], 1, 2);
            }
        }

    }

    public void displayInfo(TextArea textArea, Car car){
        if (car instanceof FuelCar) {
            String str = "Make - " + car.getMake() +"\n" + "Model - " + car.getModel() +"\n" + "Type - " +car.getType() + "\n" + "Fuel - " + ((FuelCar) car).getFuel() + "\n" +
                    "Transmission - " + ((FuelCar) car).getTransmission() + "\n" + "Fuel tank capacity (L)- " + ((FuelCar) car).getFuelCapacity() + "\n" +
                    "MPG - " + ((FuelCar) car).getMpg() +"\n" + "Year - " + car.getYear()+"\n" + "Colour - " + car.getColour() + "\n" + "Weight (kg) - " + car.getWeight() + "\n\n" +
                    "Cost per day - RM" + car.getCostPerDay();
            textArea.setText("Hey");
            textArea.setText(str);
        }else{
            String str = "Make - " + car.getMake() +"\n" + "Model - " + car.getModel() +"\n" + "Type - " +car.getType() + "\n" + "Fuel - Electric" + "\n" +
                    "Battery capacity (Wh) - " + ((ElectricCar) car).getBatteryCapacity() + "\n" + "Charge time (hr) - " + ((ElectricCar) car).getChargeTime() +"\n" + "Driving range (km) - " + ((ElectricCar) car).getDrivingRange() + "\n" + "Year - " + car.getYear()+"\n" + "Colour - " + car.getColour() + "\n" + "Weight (kg) - " + car.getWeight() + "\n\n" +
                    "Cost per day - RM" + car.getCostPerDay();
            textArea.setText("Hey");
            textArea.setText(str);
        }
    }

    public static Car[] getSlice(Car[] array, int startIndex, int endIndex)
    {

        Car[] slicedArray = new Car[endIndex - startIndex];

        for (int i = 0; i < slicedArray.length; i++)
        {
            slicedArray[i] = array[startIndex + i];
        }

        return slicedArray;
    }
}
