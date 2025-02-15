package com.example.oopproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class UserHomePage {

    public void start(Stage primaryStage) {

      BorderPane homepage = new BorderPane();
      homepage.setStyle("-fx-background-image: url('/hpage.png'); " +
              "-fx-background-size: cover; " +
              "-fx-background-position: center center;");
      HBox hbox = new HBox();
      hbox.setSpacing(50);
      hbox.setPadding(new Insets(10, 10, 10, 10));
      hbox.setStyle("-fx-background-color: #124E66;");
      homepage.setTop(hbox);
      Button homeButton=createButton("home");
      Button aboutButton=createButton("about");
      Button contactButton=createButton("contact");
      hbox.getChildren().addAll(homeButton,aboutButton,contactButton);
      hbox.setAlignment(Pos.CENTER);

      VBox vbox = new VBox();
      vbox.setSpacing(20);

      StackPane Products=createStackPane("Products");
      Products.setOnMouseClicked(event-> {
        productsPage p=new productsPage();
          try {
              p.start(primaryStage);
          } catch (FileNotFoundException e) {
              throw new RuntimeException(e);
          }
      });
      StackPane Orders=createStackPane("Orders");
      Orders.setOnMouseClicked(mouseEvent -> {
        seeOrders seeorders=new seeOrders();
        seeorders.start(primaryStage);
      });
      Button backButton=new Button("Back");

      backButton.setStyle("-fx-background-color:#333333;-fx-font-size:15;-fx-cursor:hand;-fx-text-fill: #D3D9d4;-fx-font-weight: bold");
      backButton.setOnAction(actionEvent -> {
        primaryStage.close();
        loginPage loginpage = new loginPage();
          try {
              loginpage.start(primaryStage);
          } catch (Exception e) {
              throw new RuntimeException(e);
          }

      });
      vbox.getChildren().addAll(Products,Orders,backButton);
      vbox.setAlignment(Pos.CENTER);
      vbox.setPadding(new Insets(100));
      homepage.setCenter(vbox);







        Scene scene = new Scene(homepage, 930, 550);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cloths Ordering System");
        primaryStage.show();
    }

    private Button createButton(String text){
      Button button=new Button(text);
      button.setStyle("-fx-background-color: transparent;-fx-font-size: 15px;-fx-border-radius: 30px;-fx-text-fill: #D3D9d4;-fx-font-weight: bold;");
      button.setPadding(new Insets(10,20,10,20));
      button.setOnMouseEntered(actionEvent -> {
        button.setStyle("-fx-background-color: #333333;-fx-cursor:hand;-fx-font-size: 15px;-fx-border-radius: 30px;-fx-text-fill: #D3D9d4;-fx-font-weight: bold;");
      });
      button.setOnMouseExited(actionEvent -> {
        button.setStyle("-fx-background-color: transparent;-fx-text-fill: #D3D9d4;-fx-border-radius: 30px;-fx-font-weight: bold;-fx-font-size: 15px;");
      });
      return button;
    }

    private StackPane createStackPane(String title){
      Rectangle rectangle=new Rectangle(600,150,Color.TRANSPARENT);
      rectangle.setArcHeight(100);
      rectangle.setArcWidth(100);
      rectangle.setStyle("-fx-background-color: transparent;-fx-font-size: 25px;border-radius: 30px;-fx-border-color: #124E66");

      Text text=new Text(title);
      text.setStyle("-fx-font-size: 30px;-fx-font-weight:bold;-fx-font-family:'sans-serif';-fx-text-fill: #114f68;");

      StackPane pane=new StackPane(rectangle);
      pane.getChildren().add(text);

      pane.setStyle("-fx-background-radius: 20px;-fx-cursor:hand;-fx-background-color: #D3D9d4;-fx-border-radius: 20px;-fx-border-color: #124E66;-fx-border-width: 3px");
      return pane;
    }


}
