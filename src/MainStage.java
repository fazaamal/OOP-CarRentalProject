import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MainStage extends Application {
    //Initialising car objects
    private Car teslaSObj = new ElectricCar("C1", "Tesla", "Model S", "Sedan", "Grey", "Electric", ".\\images\\teslaS.jpg", 2020,
            5, 70, 21, 2000, 99000, 8, 400);
    private Car leafObj = new ElectricCar("C2", "Nissan", "Leaf", "Hatchback", "Grey", "Electric", ".\\images\\nissanLeaf.jpg", 2019,
            5, 45, 17, 1580, 50000, 6, 200);
    private Car kiaObj = new ElectricCar("C3", "Kia", "EV6", "Hatchback", "Red", "Electric", ".\\images\\kia.jpg", 2021,
            5, 55, 17, 2500, 82500, 6, 400);
    private Car mercObj = new FuelCar("C4", "Mercedes", "E Class", "Sedan", "White", "Manual", "Diesel", ".\\images\\mercE.png",
            2021, 5, 80, 18, 1750, 80, 45);
    private Car x70Obj = new FuelCar("C5", "Proton", "X70", "SUV", "Red", "Automatic", "Petrol", ".\\images\\protonX70.jpg",
            2019, 7, 50, 19, 1650, 60, 20.5);
    private Car peroduaObj = new FuelCar("C6", "Perodua", "Myvi", "Hatchback", "Blue", "Automatic", "Petrol", ".\\images\\myvi.jpg",
            2018, 5, 30, 16, 1300, 40, 20.5);
    private Car fordObj = new FuelCar("C7", "Ford", "F150", "Truck", "Black", "Manual", "Diesel" , ".\\images\\f150.jpg",
            2021, 6, 65, 31, 4500, 120, 20);
    private Car corsaObj = new FuelCar("C8", "Ford", "Corsa", "Hatchback", "Red", "Automatic", "Petrol", ".\\images\\corsa.png",
            2019, 5, 38, 16, 1100, 45, 22);
    private Car teslaXObj = new ElectricCar("C9", "Tesla", "Model X", "SUV", "Blue", "Electric", ".\\images\\teslaX.png", 2018,
            7, 90, 21, 2500, 120000, 8, 380);

    private Car[] cars = {teslaSObj, leafObj, mercObj, x70Obj, kiaObj, peroduaObj, fordObj, corsaObj, teslaXObj};
    private int currPage = 0;
    private boolean filtered = false;
    private int buttonClicked = 0;

    private ArrayList<Car> carFilteredList = new ArrayList<Car>();
    private ArrayList<String> filters = new ArrayList<String>();

    private Booking[] bookings = new Booking[cars.length];
    @Override
    public void start(Stage mainStage) throws Exception{

        /*
        DESIGN OF PRIMARY STAGE
         */

        GridPane gridpane1 = new GridPane(); //create gridpane
        gridpane1.setStyle("-fx-background-color: #b2dcf7");
        gridpane1.setPadding(new Insets(10, 10 ,10 ,10));
        gridpane1.getColumnConstraints().add(new ColumnConstraints(200)); //col 0
        gridpane1.getColumnConstraints().add(new ColumnConstraints(200)); //col 1
        gridpane1.getColumnConstraints().add(new ColumnConstraints(200)); //col 2
        gridpane1.getRowConstraints().add(new RowConstraints(30)); //row 0
        gridpane1.getRowConstraints().add(new RowConstraints(260)); //row 1
        gridpane1.getRowConstraints().add(new RowConstraints(260)); //row 2
        gridpane1.getRowConstraints().add(new RowConstraints(40)); //row 3
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

        Button buttonRent1 = new Button("Rent now!");
        buttonRent1.setAlignment(Pos.CENTER);
        HBox hboxBtn1 = new HBox(buttonRent1);
        hboxBtn1.setPadding(new Insets(0 , 0, 0 ,65));

        VBox vbox1 = new VBox();
        vbox1.setPrefWidth(200);
        vbox1.setPrefHeight(235);
        vbox1.setPadding(new Insets(55, 0, 0 ,0));
        vbox1.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vbox1.getChildren().addAll(img1, lbl1, hboxBtn1);

        //Top right lsting
        ImageView img2 = new ImageView();
        img2.setFitHeight(125);
        img2.setFitWidth(200);
        img2.setPreserveRatio(false);

        Label lbl2 = new Label();
        lbl2.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        Button buttonRent2 = new Button("Rent now!");
        buttonRent2.setAlignment(Pos.CENTER);
        HBox hboxBtn2 = new HBox(buttonRent2);
        hboxBtn2.setPadding(new Insets(0 , 0, 0 ,65));

        VBox vbox2 = new VBox();
        vbox2.setPrefWidth(200);
        vbox2.setPrefHeight(235);
        vbox2.setPadding(new Insets(55, 0, 0 ,0));
        vbox2.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vbox2.getChildren().addAll(img2, lbl2, hboxBtn2);

        //Bottom left listing
        ImageView img3 = new ImageView();
        img3.setFitHeight(125);
        img3.setFitWidth(200);
        img3.setPreserveRatio(false);

        Label lbl3 = new Label();
        lbl3.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        Button buttonRent3 = new Button("Rent now!");
        buttonRent3.setAlignment(Pos.CENTER);
        HBox hboxBtn3 = new HBox(buttonRent3);
        hboxBtn3.setPadding(new Insets(0 , 0, 0 ,65));

        VBox vbox3 = new VBox();
        vbox3.setPrefWidth(200);
        vbox3.setPrefHeight(235);
        vbox3.setPadding(new Insets(55, 0, 0 ,0));
        vbox3.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vbox3.getChildren().addAll(img3, lbl3, hboxBtn3);

        //Bottom right listing
        ImageView img4 = new ImageView();
        img4.setFitHeight(125);
        img4.setFitWidth(200);
        img4.setPreserveRatio(false);

        Label lbl4 = new Label();
        lbl4.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        Button buttonRent4 = new Button("Rent now!");
        buttonRent4.setAlignment(Pos.CENTER);
        HBox hboxBtn4 = new HBox(buttonRent4);
        hboxBtn4.setPadding(new Insets(0 , 0, 0 ,65));

        VBox vbox4 = new VBox();
        vbox4.setPrefWidth(200);
        vbox4.setPrefHeight(235);
        vbox4.setPadding(new Insets(55, 0, 0 ,0));
        vbox4.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vbox4.getChildren().addAll(img4, lbl4, hboxBtn4);

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
        for(CheckBox checkBox: checkFuels){
            checkBox.setSelected(true);
        }

        Label lblMake = new Label("Make:");
        lblMake.setFont(Font.font("Courier", FontWeight.BOLD,
                10));
        CheckBox checkTesla = new CheckBox("Tesla");
        CheckBox checkProton = new CheckBox("Proton");
        CheckBox checkNissan = new CheckBox("Nissan");
        CheckBox checkMercedes = new CheckBox("Mercedes");
        CheckBox checkPerodua = new CheckBox("Perodua");
        CheckBox checkKia = new CheckBox("Kia");
        CheckBox checkFord = new CheckBox("Ford");

        CheckBox[] checkMakes = {checkMercedes, checkNissan, checkTesla, checkProton, checkPerodua, checkKia, checkFord};
        for(CheckBox checkBox: checkMakes){
            checkBox.setSelected(true);
        }

        Label lblTransmission = new Label("Transmission:");
        lblTransmission.setFont(Font.font("Courier", FontWeight.BOLD,
                10));
        CheckBox checkAutomatic = new CheckBox("Automatic");
        CheckBox checkManual = new CheckBox("Manual");

        CheckBox[] checkTransmissions = {checkAutomatic, checkManual};
        for(CheckBox checkBox: checkTransmissions){
            checkBox.setSelected(true);
        }

        VBox vbox6 = new VBox();
        vbox6.setSpacing(1);
        vbox6.setPrefWidth(200);
        vbox6.setPrefHeight(235);
        vbox6.setPadding(new Insets(0, 0, 0 ,0));
        vbox6.getChildren().addAll(lblCostInfo, lblCarFuel, checkElectric, checkPetrol, checkDiesel, lblMake, checkMercedes, checkNissan, checkTesla, checkProton, checkPerodua, checkKia, checkFord,
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
        CheckBox checkBlack = new CheckBox("Black");
        CheckBox checkBlue = new CheckBox("Blue");

        CheckBox[] checkColours = {checkWhite, checkRed, checkGrey, checkBlack, checkBlue};
        for(CheckBox checkBox: checkColours){
            checkBox.setSelected(true);
        }

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
        CheckBox checkTruck = new CheckBox("Truck");

        CheckBox[] checkTypes = {checkSedan, checkSuv, checkHatchback, checkTruck};
        for(CheckBox checkBox: checkTypes){
            checkBox.setSelected(true);
        }

        VBox vbox7 = new VBox();
        vbox7.setSpacing(1);
        vbox7.setPrefWidth(200);
        vbox7.setPrefHeight(235);
        vbox7.setPadding(new Insets(0, 0, 0 ,0));
        vbox7.getChildren().addAll(lblSpacer, lblColour, checkWhite, checkRed, checkGrey, checkBlack, checkBlue, lblPrice, textPrice, lblType, checkSedan, checkSuv, checkHatchback, checkTruck);

        Button buttonApply = new Button("Apply");
        buttonApply.setAlignment(Pos.CENTER);
        Button buttonReset = new Button("Reset");
        buttonReset.setAlignment(Pos.CENTER);

        HBox hboxFilterBtns = new HBox(buttonApply, buttonReset);
        hboxFilterBtns.setSpacing(40);
        hboxFilterBtns.setPadding(new Insets(10 , 0, 0 ,35));

        //Page buttons
        Button buttonPrev = new Button("Previous page");
        buttonPrev.setAlignment(Pos.CENTER);
        buttonPrev.setDisable(true);
        HBox hboxBtnPrev = new HBox(buttonPrev);
        hboxBtnPrev.setPadding(new Insets(10 , 0, 0 ,65));

        Button buttonNext = new Button("Next page");
        buttonNext.setAlignment(Pos.CENTER);
        HBox hboxBtnNext = new HBox(buttonNext);
        hboxBtnNext.setPadding(new Insets(10 , 0, 0 ,65));

        VBox[] vboxes = {vbox1, vbox2, vbox3, vbox4};
        Label[] lbls = {lbl1, lbl2, lbl3, lbl4};
        ImageView[] imgs = {img1, img2, img3, img4};


        //Add gridpane children
        gridpane1.add(logo, 1, 0);
        gridpane1.add(vbox5, 2, 1);
        gridpane1.add(gridpane2, 2, 2);
        gridpane1.add(hboxFilterBtns, 2, 3);
        gridpane1.add(hboxBtnPrev, 0, 3);
        gridpane1.add(hboxBtnNext, 1, 3);

        gridpane2.add(vbox6, 0, 0);
        gridpane2.add(vbox7, 1, 0);

        loadListings(cars, gridpane1, vboxes, lbls, imgs);

        Scene scene1 = new Scene(gridpane1, 660, 630);

        mainStage.setTitle("IIUM Car Rental"); // Set the stage title
        mainStage.setScene(scene1); // Place the scene in the stage
        mainStage.setResizable(false);


        /*
        DESIGN OF CUSTOMER RENTAL FORM STAGE
         */

        //Customer enters details into these text fields
        GridPane gridpane3 = new GridPane();

        gridpane3.setStyle("-fx-background-color: #b2dcf7");
        gridpane3.setPadding(new Insets(10, 10 ,10 ,10));
        gridpane3.getColumnConstraints().add(new ColumnConstraints(20));
        gridpane3.getColumnConstraints().add(new ColumnConstraints(400));
        gridpane3.getColumnConstraints().add(new ColumnConstraints(200));
        gridpane3.getRowConstraints().add(new RowConstraints(40));
        gridpane3.getRowConstraints().add(new RowConstraints(350));
        gridpane3.setHgap(15);
        gridpane3.setVgap(10);

        Label formHeader = new Label("Customer Rental Form");
        formHeader.setFont(Font.font("Courier", FontWeight.BOLD,
                35));

        TextField textName = new TextField();
        textName.setPrefWidth(280);
        Label lblName = new Label("Full name");
        lblName.setPrefWidth(120);
        HBox hboxName = new HBox(lblName, textName);
        hboxName.setPrefHeight(15);
        hboxName.setPadding(new Insets(20, 0, 0, 0));

        TextField textIC = new TextField();
        textIC.setPrefWidth(280);
        Label lblIC = new Label("IC/Passport Number");
        lblIC.setPrefWidth(120);
        HBox hboxIC = new HBox(lblIC, textIC);
        hboxIC.setPrefHeight(15);

        TextField textPhone = new TextField();
        textPhone.setPrefWidth(280);
        Label lblPhone = new Label("Phone Number");
        lblPhone.setPrefWidth(120);
        HBox hboxPhone = new HBox(lblPhone, textPhone);
        hboxPhone.setPrefHeight(15);

        TextField textAddress = new TextField();
        textAddress.setPrefWidth(280);
        Label lblAddress = new Label("Address");
        lblAddress.setPrefWidth(120);
        HBox hboxAddress = new HBox(lblAddress, textAddress);
        hboxAddress.setPrefHeight(15);

        TextField textDays = new TextField();
        textDays.setPrefWidth(50);
        Label lblDays = new Label("No. of days renting");
        lblDays.setPrefWidth(120);
        HBox hboxDays = new HBox(lblDays, textDays);
        hboxDays.setPrefHeight(15);

        Label lblPaymentDetails = new Label("Payment Details");
        lblPaymentDetails.setFont(Font.font("Courier", FontWeight.BOLD,
                18));
        lblPaymentDetails.setPrefWidth(200);

        Label lblTotal = new Label("Total is RM");
        lblTotal.setFont(Font.font("Courier",
                18));

        HBox hboxPaymentDetails = new HBox(lblPaymentDetails, lblTotal);

        TextField textCardNo = new TextField();
        textCardNo.setPrefWidth(280);
        Label lblCardNo = new Label("Card number");
        lblCardNo.setPrefWidth(120);
        HBox hboxCardNo = new HBox(lblCardNo, textCardNo);
        hboxCardNo.setPrefHeight(15);

        TextField textExpiryMonth = new TextField();
        textExpiryMonth.setPrefWidth(30);
        Label lblForwardSlash = new Label(" / ");
        lblForwardSlash.setFont(Font.font("Courier", 15));
        TextField textExpiryYear = new TextField();
        textExpiryYear.setPrefWidth(30);
        Label lblExpiryDate = new Label("Expiry Date");
        lblExpiryDate.setPrefWidth(120);
        HBox hboxExpiryDate = new HBox(lblExpiryDate, textExpiryMonth, lblForwardSlash, textExpiryYear);
        hboxExpiryDate.setPrefHeight(15);

        Button buttonSubmit = new Button("Submit");
        HBox hboxSubmit= new HBox(buttonSubmit);
        hboxSubmit.setPadding(new Insets(20, 0, 0, 170));

        VBox vboxForm = new VBox(hboxName, hboxPhone, hboxIC, hboxAddress, hboxDays, hboxPaymentDetails, hboxCardNo, hboxExpiryDate, hboxSubmit);
        vboxForm.setSpacing(10);

        ImageView imgCarSelected = new ImageView();
        imgCarSelected.setFitHeight(125);
        imgCarSelected.setFitWidth(200);
        imgCarSelected.setPreserveRatio(false);

        Label lblCarSelected = new Label("HEllo");
        lblCarSelected.setFont(Font.font("Courier", FontWeight.BOLD,
                18));

        VBox vboxCarSelected = new VBox();
        vboxCarSelected.setPrefWidth(200);
//        vboxCarSelected.setPrefHeight(100);
        vboxCarSelected.setPadding(new Insets(65, 0, 0 ,0));
        vboxCarSelected.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 2px");
        vboxCarSelected.getChildren().addAll(imgCarSelected, lblCarSelected);

        gridpane3.add(formHeader, 1, 0);
        gridpane3.add(vboxForm, 1, 1);
        gridpane3.add(vboxCarSelected, 2, 1);

        TextField[] textFields = {textName, textPhone, textIC, textAddress, textDays, textCardNo, textExpiryMonth, textExpiryYear};

        Scene sceneForm = new Scene(gridpane3, 700, 470);

        Stage customerFormStage = new Stage();
        customerFormStage.setScene(sceneForm);
        customerFormStage.setTitle("Customer Rental Form");
        customerFormStage.setResizable(false);

        /*
        ONCHANGE EVENT HANDLING
         */

        textDays.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(filtered){
                    System.out.println(filtered);
                    lblTotal.setText("Total is RM" + parseInt(textDays.getText())*carFilteredList.get(currPage*4+buttonClicked).getCostPerDay());
                }else{
                    System.out.println(filtered);
                    lblTotal.setText("Total is RM" + parseInt(textDays.getText())*cars[currPage*4+buttonClicked].getCostPerDay());
                }
            }
        });

        /*
        CLICK EVENT HANDLING
         */

        vbox1.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            if(source == vbox1) {
                if(filtered){
                    displayInfo(carSpecs, carFilteredList.get(currPage*4+0));
                }else{
                    displayInfo(carSpecs, cars[currPage*4+0]);
                }
            }
        });

        vbox2.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            if(source == vbox2) {
                if(filtered){
                    displayInfo(carSpecs, carFilteredList.get(currPage*4+1));
                }else {
                    displayInfo(carSpecs, cars[currPage * 4 + 1]);
                }
            }
        });

        vbox3.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            if(source == vbox3) {
                if(filtered){
                    displayInfo(carSpecs, carFilteredList.get(currPage*4+2));
                }else {
                    displayInfo(carSpecs, cars[currPage * 4 + 2]);
                }
            }
        });

        vbox4.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            if(source == vbox4) {
                if(filtered){
                    displayInfo(carSpecs, carFilteredList.get(currPage*4+3));
                }else {
                    displayInfo(carSpecs, cars[currPage * 4 + 3]);
                }
            }
        });

        buttonSubmit.setOnMouseClicked((event) -> {
            javafx.scene.Node source1 = (javafx.scene.Node) event.getSource();
            if(source1==buttonSubmit){
                if(filtered){
                    for(int i=0; i<cars.length; i++){
                        if(bookings[i]==null){
                            bookings[i] = new Booking(("B"+(i+1)), carFilteredList.get(currPage*4+buttonClicked).getCarId(), parseInt(textDays.getText()), textName.getText(), textIC.getText(), textAddress.getText(), textPhone.getText(), textCardNo.getText(),
                                    parseInt(textExpiryMonth.getText()), parseInt(textExpiryYear.getText()), parseInt(textDays.getText())*carFilteredList.get(currPage*4+buttonClicked).getCostPerDay());
                            carFilteredList.get(currPage*4+buttonClicked).setBookingID(("B"+(i+1)));
                        }else{
                            continue;
                        }
                    }
                }else{
                    for(int i=0; i<cars.length; i++){
                        if(bookings[i]==null){
                            bookings[i] = new Booking(("B"+(i+1)), cars[currPage*4+buttonClicked].getCarId(), parseInt(textDays.getText()), textName.getText(), textIC.getText(), textAddress.getText(), textPhone.getText(), textCardNo.getText(),
                                    parseInt(textExpiryMonth.getText()), parseInt(textExpiryYear.getText()), parseInt(textDays.getText())*cars[currPage*4+buttonClicked].getCostPerDay());
                            cars[currPage*4+buttonClicked].setBookingID(("B"+(i+1)));
                        }else{
                            continue;
                        }
                    }
                }
//                System.out.println(bookings[0].getBookingID() +" " + bookings[0].getName());

                for(TextField textField: textFields){
                    textField.setText("");
                }

                customerFormStage.close();
            }
        });

        buttonRent1.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            try{
                if(source == buttonRent1) {
                    buttonClicked = 0;
                    customerFormStage.show();
                    if(filtered){
                        loadForm(carFilteredList.get(currPage*4+0), imgCarSelected, lblCarSelected);
                    }else{
                        loadForm(cars[currPage*4+0], imgCarSelected, lblCarSelected);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        buttonRent2.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            try{
                if(source == buttonRent2) {
                    buttonClicked = 1;
                    customerFormStage.show();
                    if(filtered){
                        loadForm(carFilteredList.get(currPage*4+1), imgCarSelected, lblCarSelected);
                    }else{
                        loadForm(cars[currPage*4+1], imgCarSelected, lblCarSelected);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        buttonRent3.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            try{
                if(source == buttonRent3) {
                    buttonClicked = 2;
                    customerFormStage.show();
                    if(filtered){
                        loadForm(carFilteredList.get(currPage*4+2), imgCarSelected, lblCarSelected);
                    }else{
                        loadForm(cars[currPage*4+2], imgCarSelected, lblCarSelected);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        buttonRent4.setOnMouseClicked((event) -> {    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            try{
                if(source == buttonRent4) {
                    buttonClicked = 3;
                    customerFormStage.show();
                    if(filtered){
                        loadForm(carFilteredList.get(currPage*4+3), imgCarSelected, lblCarSelected);
                    }else{
                        loadForm(cars[currPage*4+3], imgCarSelected, lblCarSelected);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        //Go to next page
        buttonNext.setOnMouseClicked((event) ->{    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            try{
                if(source == buttonNext) {
                    currPage += 1;

                    if((currPage*4-4)<0){
                        buttonPrev.setDisable(true);
                    }else{
                        buttonPrev.setDisable(false);
                    }

                    if(filtered){
                        if((currPage+1)*4>=carFilteredList.size()){
                            buttonNext.setDisable(true);
                        }else{
                            buttonNext.setDisable(false);
                        }

                        loadListings(carFilteredList, gridpane1, vboxes, lbls, imgs, currPage);
                    }else{
                        if((currPage+1)*4>=cars.length){
                            buttonNext.setDisable(true);
                        }else{
                            buttonNext.setDisable(false);
                        }

                        loadListings(cars, gridpane1, vboxes, lbls, imgs, currPage);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        //Go to previous page
        buttonPrev.setOnMouseClicked((event) ->{    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            try{
                if(source == buttonPrev) {
                    currPage -= 1;
                    buttonNext.setDisable(false);

                    if((currPage*4-4)<0){
                        buttonPrev.setDisable(true);
                    }else{
                        buttonPrev.setDisable(false);
                    }

                    if(filtered){
                        loadListings(carFilteredList, gridpane1, vboxes, lbls, imgs, currPage);
                    }else{
                        loadListings(cars, gridpane1, vboxes, lbls, imgs, currPage);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        //Apply filters
        buttonApply.setOnMouseClicked((event) ->{    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            try{
                if(source == buttonApply) {
                    filters.clear();
                    carFilteredList.clear();

                    for(CheckBox check: checkFuels){
                        if(check.isSelected()){
                            filters.add(check.getText());
                        }else{
                            filters.add(null);
                        }
                    }

                    for(CheckBox check: checkMakes){
                        if(check.isSelected()){
                            filters.add(check.getText());
                        }else{
                            filters.add(null);
                        }
                    }

                    for(CheckBox check: checkColours){
                        if(check.isSelected()){
                            filters.add(check.getText());
                        }else{
                            filters.add(null);
                        }
                    }

                    for(CheckBox check: checkTransmissions){
                        if(check.isSelected()){
                            filters.add(check.getText());
                        }else{
                            filters.add(null);
                        }
                    }


                    for(CheckBox check: checkTypes){
                        if(check.isSelected()){
                            filters.add(check.getText());
                        }else{
                            filters.add(null);
                        }
                    }

                    if(textPrice.getText() == ""){
                        filters.add("99999999");
                    }else{
                        filters.add(textPrice.getText());
                    }


                    for(Car car: cars){

                        if(car instanceof FuelCar){
                            if(filters.contains(car.getFuel()) && filters.contains(car.getMake()) && filters.contains(((FuelCar) car).getTransmission()) &&
                                    filters.contains(car.getColour()) && filters.contains(car.getType()) && (Double.parseDouble(filters.get(filters.size()-1)) >= car.getCostPerDay())){
                                carFilteredList.add(car);
                            }
                        }else{
                            if(filters.contains(car.getFuel()) && filters.contains(car.getMake()) && filters.contains(car.getColour()) && filters.contains(car.getType()) &&
                                    (Double.parseDouble(filters.get(filters.size()-1)) >= car.getCostPerDay())){
                                carFilteredList.add(car);
                            }
                        }
                    }

                    filtered = true;
                    currPage = 0;

                    if((currPage+1)*4>=carFilteredList.size()){
                        buttonNext.setDisable(true);
                    }else{
                        buttonNext.setDisable(false);
                    }

                    buttonPrev.setDisable(true);

//                    if((currPage*4-4)<0){
//                        buttonPrev.setDisable(true);
//                    }else{
//                        buttonPrev.setDisable(false);
//                    }

                    loadListings(carFilteredList, gridpane1, vboxes, lbls, imgs, currPage);

                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        //Resets filters
        buttonReset.setOnMouseClicked((event) ->{    // lambda expression
            javafx.scene.Node source = (javafx.scene.Node) event.getSource();
            try{
                if(source == buttonReset) {
                    currPage = 0;
                    filtered = false;

                    for(CheckBox check: checkFuels){
                        check.setSelected(true);
                    }

                    for(CheckBox check: checkMakes){
                        check.setSelected(true);
                    }

                    for(CheckBox check: checkColours){
                        check.setSelected(true);
                    }

                    for(CheckBox check: checkTypes){
                        check.setSelected(true);
                    }

                    textPrice.setText("");

                    if((currPage+1)*4>=cars.length){
                        buttonNext.setDisable(true);
                    }else{
                        buttonNext.setDisable(false);
                    }

                    buttonPrev.setDisable(true);

                    loadListings(cars, gridpane1, vboxes, lbls, imgs);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        mainStage.show(); // Display the stage
//        customerFormStage.show();
    }

    //Load listings when app launched or when filter is reset
    public void loadListings(Car[] cars, GridPane gridpane, VBox[] vboxes, Label[] lbls, ImageView[] imgs) throws FileNotFoundException {
        int len = cars.length;
        if(len>4){
            len = 4;
        }

        for(int i=0; i<4; i++){
            gridpane.getChildren().remove(vboxes[i]);
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

    //Load listings when next page or previous page buttons are clicked
    public void loadListings(Car[] cars, GridPane gridpane, VBox[] vboxes, Label[] lbls, ImageView[] imgs, int currPage) throws FileNotFoundException{

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

    //Load listings when filter is applied
    public void loadListings(ArrayList<Car> cars, GridPane gridpane, VBox[] vboxes, Label[] lbls, ImageView[] imgs, int currPage) throws FileNotFoundException{
        int max, len = cars.size();
        if((currPage*4 + 4) < len){
            max = currPage*4 + 4;
        }else{
            max = len;
        }

        for(int i=0; i<4; i++){
            gridpane.getChildren().remove(vboxes[i]);
        }

        for(int i=(currPage*4); i<(max); i++){
            imgs[i-currPage*4].setImage(new Image(new FileInputStream(cars.get(i).getImgPath())));
            lbls[i-currPage*4].setText(cars.get(i).getMake() + " " + cars.get(i).getModel());

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

    public void loadForm(Car car, ImageView img, Label lbl) throws FileNotFoundException{
        img.setImage(new Image(new FileInputStream(car.getImgPath())));
        lbl.setText(car.getMake() + " " +car.getModel() + "\nRM" + car.getCostPerDay() + " /Day");
    }

    //Displays car info in the Text Area node
    public void displayInfo(TextArea textArea, Car car){
        if (car instanceof FuelCar) {
            String str = "Cost per day - RM" + car.getCostPerDay() + "\n\nMake - " + car.getMake() +"\n" + "Model - " + car.getModel() +"\n" + "Type - " +car.getType() + "\n" + "Fuel - " + ((FuelCar) car).getFuel() + "\n" +
                    "Transmission - " + ((FuelCar) car).getTransmission() + "\n" + "Fuel tank capacity (L)- " + ((FuelCar) car).getFuelCapacity() + "\n" +
                    "MPG - " + ((FuelCar) car).getMpg() +"\n" + "Year - " + car.getYear()+"\n" + "Colour - " + car.getColour() + "\n" + "Weight (kg) - " + car.getWeight() + "\n" + "Tyre (inch) - " + car.getTyreSize() +"\n\n";
            textArea.setText(str);
        }else{
            String str = "Cost per day - RM" + car.getCostPerDay() + "\n\nMake - " + car.getMake() +"\n" + "Model - " + car.getModel() +"\n" + "Type - " +car.getType() + "\n" + "Fuel - Electric" + "\n" +
                    "Battery capacity (Wh) - " + ((ElectricCar) car).getBatteryCapacity() + "\n" + "Charge time (hr) - " + ((ElectricCar) car).getChargeTime() +"\n" + "Driving range (km) - " + ((ElectricCar) car).getDrivingRange() +
                    "\n" + "Year - " + car.getYear()+"\n" + "Colour - " + car.getColour() + "\n" + "Weight (kg) - " + car.getWeight() + "\n" + "Tyre (inch) - " + car.getTyreSize();
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
