package com.example.oopproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class addOthers{

    public void start(Stage stage) throws Exception {
        BorderPane othersPage = new BorderPane();

        othersPage.setPadding(new Insets(10));
        HBox hb = new HBox();
        hb.setSpacing(550);
        hb.setStyle("-fx-background-color: #124E66;-fx-background-radius: 10px;-fx-border-radius: 10px");
        hb.setPadding(new Insets(10));
        Button backButton=new Button("Back");
        backButton.setStyle("-fx-background-color:#333333;-fx-font-size:15;-fx-cursor:hand;-fx-text-fill: #D3D9d4;-fx-font-weight: bold");
        backButton.setOnAction(actionEvent -> {
            stage.close();

        });
        Label label = new Label("Others");
        label.setStyle("-fx-text-fill: #D3D9d4");
        label.setFont(Font.font("sans-serif", FontWeight.BOLD, 20));
        hb.getChildren().addAll(backButton,label);
        othersPage.setTop(hb);

        GridPane othersGrid=new GridPane();
        othersGrid.setStyle("-fx-background-image: url('/hpage.png'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        othersGrid.setAlignment(Pos.TOP_LEFT);
        othersGrid.setPadding(new Insets(10));
        othersGrid.setHgap(10);
        othersGrid.setVgap(10);
        othersPage.setLeft(othersGrid);

        List<Others> othersList=new ArrayList<>();
        othersList.add(new Others(1000,"Plain Black NeckTie","D:\\Images\\plainblackNecktie.jpeg"));
        othersList.add(new Others(1000,"Plain Blue NeckTie","D:\\Images\\plainblueNecktie.jpeg"));
        othersList.add(new Others(1000,"Designed Black NeckTie","D:\\Images\\designedblackNecktie.jpeg"));
        othersList.add(new Others(1000,"Designed Blue NeckTie","D:\\Images\\designedblueNecktie.jpeg"));
        othersList.add(new Others(1000,"Black Leather Belt","D:\\Images\\blackleatherBelt.jpg"));
        othersList.add(new Others(1000,"Blue Leather Belt","D:\\Images\\blueleatherBelt.jpeg"));
        othersList.add(new Others(1000,"Brown Leather Belt","D:\\Images\\brownleatherBelt.jpeg"));
        othersList.add(new Others(1000,"Black Leather clip Belt","D:\\Images\\blackclipBelt.jpeg"));
        othersList.add(new Others(1000,"Brown Leather clip Belt","D:\\Images\\brownclipBelt.jpeg"));
        othersList.add(new Others(1000,"Blue Leather clip Belt","D:\\Images\\blueclipBelt.jpeg"));
        othersList.add(new Others(2500,"Brown Leather Watch","D:\\Images\\brownleatherWatch.jpeg"));
        othersList.add(new Others(2500,"Black Leather Watch","D:\\Images\\blackleatherWatch.jpeg"));
        othersList.add(new Others(2500,"Black Chain Watch","D:\\Images\\blackchainWatch.jpeg"));
        othersList.add(new Others(2500,"White Chain Watch","D:\\Images\\whitechainWatch.jpeg"));
        othersList.add(new Others(1000,"Black Metal Glasses","D:\\Images\\blackmetalSunglasses.jpeg"));
        othersList.add(new Others(1000,"Brown Metal Glasses","D:\\Images\\brownmetalSunglasses.jpeg"));


        for (int i = 0; i < othersList.size(); i++) {
            Others other=othersList.get(i);
            othersGrid.add(createOthersCard(other),i%6,i/6);

        }




        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(othersGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        othersPage.setCenter(scrollPane);



        Scene scene=new Scene(othersPage,930,550);
        stage.setTitle("Others");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
    private VBox createOthersCard(Others other) throws FileNotFoundException {
        VBox OthersCard = new VBox();
        OthersCard.setAlignment(Pos.CENTER);
        OthersCard.setSpacing(10);
        OthersCard.setPadding(new Insets(5));
        OthersCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand");
        Image image = new Image(new FileInputStream(other.getImagePath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setStyle("-fx-border-radius: 10px;-fx-background-radius: 10px");


        Label productName = new Label(other.getName());
        productName.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
        productName.setStyle("-fx-text-fill: Black");

        Label pricelabel = new Label("price:" + other.getPrice());
        pricelabel.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
        pricelabel.setStyle("-fx-text-fill: #124E66");

//        Label discriptionlabel=new Label("discription 1");
//        discriptionlabel.setStyle("-fx-text-fill: Black");
//        discriptionlabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));

        Button addToCartButton = new Button("Add to cart");
        addToCartButton.setStyle("-fx-background-color: #124E66;-fx-text-fill: #D3D9d4;-fx-cursor: hand");
        addToCartButton.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
        addToCartButton.setPrefSize(150, 40);
        addToCartButton.setOnMouseEntered(actionEvent -> {
            addToCartButton.setStyle("-fx-background-color: #333333;-fx-text-fill: white;-fx-cursor: hand");
        });
        addToCartButton.setOnMouseExited(actionEvent -> {
            addToCartButton.setStyle("-fx-background-color: #124E66;-fx-text-fill: #D3D9d4;-fx-cursor: hand");
        });


        addToCartButton.setOnAction(actionEvent -> {
            OrdersDataStore.addOrders(new Order(other.getName(), other.getPrice(), 1));
            addToCartButton.setText("Added!");
            addToCartButton.setStyle("-fx-background-color: #1bc41b");
        });


        OthersCard.setOnMouseEntered(event -> {
            OthersCard.setStyle("-fx-border-width: 1px;-fx-border-color: #333333;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: #f0f0f0");
        });
        OthersCard.setOnMouseExited(event -> {
            OthersCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: white");
        });
        OthersCard.getChildren().addAll(productName, imageView, pricelabel, addToCartButton);


        return OthersCard;
    }

}
