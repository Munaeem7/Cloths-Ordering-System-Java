package com.example.oopproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class loginPage extends Application {


    public void start(Stage stage) throws Exception {
    BorderPane welcomePage = new BorderPane();
        welcomePage.setStyle("-fx-background-image: url('/background.png'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
    Scene scene=new Scene(welcomePage,930,550);
    welcomePage.setPadding(new Insets(10));
    HBox hb = new HBox();
    hb.setStyle("-fx-background-color: #124E66;-fx-background-radius: 10px;-fx-border-radius: 10px");
    hb.setPadding(new Insets(10));
    hb.setAlignment(Pos.CENTER);
    Label label = new Label("Welcome");
    label.setStyle("-fx-text-fill: #D3D9d4");
    label.setFont(Font.font("sans-serif", FontWeight.BOLD, 20));
    hb.getChildren().add(label);
    welcomePage.setTop(hb);

    VBox vbox=new VBox();

        TextField nameField = new TextField();
        nameField.setPromptText(" Enter your name");
    nameField.setStyle("-fx-font-size: 15;-fx-label-padding: 20");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText(" Enter your password");
        passwordField.setStyle("-fx-font-size: 15");
        Label alertlabel=new Label();
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #124E66;-fx-cursor:hand;-fx-text-fill: White;-fx-font-weight: bold");
        Label line = new Label("if don't have any account then signup,");
        line.setStyle("-fx-font-weight: bold;-fx-text-fill:#124E66 ");
      //  welcomePage.getChildren().add(line);
        Button signupButton = new Button("Signup");
    signupButton.setStyle("-fx-background-color: #124E66;-fx-cursor:hand;-fx-text-fill: White;-fx-font-weight: bold");
       // welcomePage.getChildren().add(signupButton);
    //welcomePage.setStyle("-fx-background-color: #000000; -fx-padding: 20px; -fx-hgap: 10px; -fx-vgap: 10px;");
    vbox.getChildren().addAll(nameField,passwordField,loginButton,alertlabel,line,signupButton);

    vbox.setAlignment(Pos.CENTER_LEFT);
//    vbox.setOpacity(0.0);
    vbox.setPadding(new Insets(20,350,20,350));
    vbox.setSpacing(20);
    vbox.setStyle("-fx-border-color: transparent;-fx-border-radius: 10px;-fx-background-radius: 10px;");


    vbox.setOnMouseEntered(mouseEvent -> {
        vbox.setStyle("-fx-border-color:#124E66 ;-fx-border-radius: 10px;-fx-background-radius: 10px;");
    });

    vbox.setOnMouseExited(mouseEvent -> {
        vbox.setStyle("-fx-border-color:transparent;-fx-border-radius: 10px;-fx-background-radius: 10px; ");
    });


    GridPane loginGrid=new GridPane();
    loginGrid.setAlignment(Pos.TOP_CENTER);
    loginGrid.setPadding(new Insets(10));
    loginGrid.setHgap(10);
    loginGrid.setVgap(30);
    welcomePage.setCenter(loginGrid);
    loginGrid.add(vbox,2,2);





        GridPane signupPage = new GridPane();
    signupPage.setStyle("-fx-background-color: #D3D9d4");
        signupPage.setHgap(5);
        signupPage.setVgap(15);
        Scene signupScene = new Scene(signupPage, 990, 550);
        Text signupText = new Text("Create a new account");
    signupText.setStyle("-fx-font-size: 25px; " +
            "-fx-font-weight: bold; " +
            "-fx-fill: #124E66; " +
            "-fx-font-family: 'Arial', sans-serif;");


        signupPage.add(signupText, 1, 0);
        Label signupname = new Label("Enter your name");
    signupname.setStyle("-fx-font-weight: bold;-fx-text-fill:#124E66 ");
        TextField signupnameField = new TextField();
        signupPage.add(signupname, 2, 1);
        signupPage.add(signupnameField, 3,1);
        Label emailLabel = new Label("Enter your email");
    emailLabel.setStyle("-fx-font-weight: bold;-fx-text-fill:#124E66 ");
        TextField emailField = new TextField();
        emailField.setPromptText("Optional");
        signupPage.add(emailLabel, 2, 2);
        signupPage.add(emailField, 3, 2);
        Label contactLabel = new Label("Enter your contact number");
    contactLabel.setStyle("-fx-font-weight: bold;-fx-text-fill:#124E66 ");
        TextField contactField = new TextField();
        contactField.setPromptText("Optional");
        signupPage.add(contactLabel, 2, 3);
        signupPage.add(contactField, 3, 3);
        Label signuppassword = new Label("Enter your password");
        signuppassword.setStyle("-fx-font-weight: bold;-fx-text-fill:#124E66 ");
        PasswordField signuppasswordField = new PasswordField();
        signupPage.add(signuppassword, 2, 4);
        signupPage.add(signuppasswordField, 3, 4);
        Label confirmPasswordLabel = new Label("Confirm password");
    confirmPasswordLabel.setStyle("-fx-font-weight: bold;-fx-text-fill:#124E66 ");
        PasswordField confirmPasswordField = new PasswordField();
        signupPage.add(confirmPasswordLabel, 2, 5);
        signupPage.add(confirmPasswordField, 3, 5);
        Button confirmButton = new Button("Confirm");
    confirmButton.setStyle("-fx-background-color: #124E66;-fx-text-fill: White;-fx-font-weight: bold;-fx-cursor: hand");
        signupPage.add(confirmButton, 3, 6);
        Button exitButton=new Button("  close  ");
    exitButton.setStyle("-fx-background-color: #124E66;-fx-text-fill: White;-fx-font-weight: bold;-fx-cursor: hand");
        signupPage.add(exitButton, 2, 6);

        Label accountCreatedLabel = new Label("Account created Successfully!!");
    accountCreatedLabel.setStyle("-fx-font-size: 20px; " +
            "-fx-font-weight: bold; " +
            "-fx-fill: #124E66; " +
            "-fx-font-family: 'Arial', sans-serif;");
        Label passwordMiassmatchedLabel = new Label("Password do not match!");
        passwordMiassmatchedLabel.setStyle("-fx-font-size: 20px; " +
                "-fx-font-weight: bold; " +
                "-fx-text-fill: red; " +
                "-fx-font-family: 'Arial', sans-serif;");
        Label invalidInputLabel = new Label("Incomplete Credentials!");
        invalidInputLabel.setStyle("-fx-font-size: 20px; " +
                "-fx-font-weight: bold; " +
                "-fx-text-fill: red; " +
                "-fx-font-family: 'Arial', sans-serif;");



        signupButton.setOnAction(actionEvent -> {
            signupnameField.clear();
            emailField.clear();
            contactField.clear();
            signuppasswordField.clear();
            confirmPasswordField.clear();

            stage.setScene(signupScene);
        });
        confirmButton.setOnAction(actionEvent -> {
            invalidInputLabel.setVisible(false);
            String customerName=signupnameField.getText();
            String customerEmail=emailField.getText();
            String customerContact=contactField.getText();
            String customerPassword=signuppasswordField.getText();

            if(!(customerName.isEmpty()||customerPassword.isEmpty())) {
                if (customerPassword.equals(confirmPasswordField.getText())) {
                    Customer customer = new Customer(customerName, customerEmail, customerContact, customerPassword);
                    SaveDataToFile.writeDataToFile(customerName, customerEmail, customerContact, customerPassword);
                    signupPage.add(accountCreatedLabel, 4, 7);
                    passwordMiassmatchedLabel.setVisible(false);
                    invalidInputLabel.setVisible(false);
                } else {
                    signupPage.add(passwordMiassmatchedLabel, 4, 7);
                    passwordMiassmatchedLabel.setVisible(true);
                    invalidInputLabel.setVisible(false);
                }
            }else{
                signupPage.add(invalidInputLabel,4,7);
                invalidInputLabel.setVisible(true);
            }
        });

    exitButton.setOnAction(actionEvent -> {
        accountCreatedLabel.setVisible(false);
        stage.setScene(scene);
    });

    loginButton.setOnAction(actionEvent -> {

        String customerName=nameField.getText();
        String customerPassword=passwordField.getText();
        Authentication check=new Authentication();
        boolean checkLogin=check.login(customerName, customerPassword);
        if(checkLogin){
            System.out.println("login successful");
            UserHomePage userhomePage = new UserHomePage();
            userhomePage.start(stage);
        }else{
            alertlabel.setText("invalid name or password");
            alertlabel.setStyle("-fx-font-weight: bold;-fx-text-fill:red ");
            System.out.println("login failed due to invalid credentials");
        }
    });


        Image image = new Image("file://C:\\Users\\Pc\\IdeaProjects\\oopProject\\src\\main\\java\\com\\example\\oopproject\\logo.png");
        stage.setTitle("Login Page");
        stage.getIcons().add(image);

        stage.setScene(scene);
        stage.show();


    }


}

