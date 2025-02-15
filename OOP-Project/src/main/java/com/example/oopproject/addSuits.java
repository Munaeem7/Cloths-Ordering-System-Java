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

public class addSuits {

    public void start(Stage stage) throws Exception {
        BorderPane suitsPage = new BorderPane();

        suitsPage.setPadding(new Insets(10));
        HBox hb = new HBox();
        Button backButton=new Button("Back");

        backButton.setStyle("-fx-background-color:#333333;-fx-font-size:15;-fx-cursor:hand;-fx-text-fill: #D3D9d4;-fx-font-weight: bold");
        backButton.setOnAction(actionEvent -> {
            stage.close();
        });
        hb.setStyle("-fx-background-color: #124E66;-fx-background-radius: 10px;-fx-border-radius: 10px");
        hb.setPadding(new Insets(10));
        hb.setSpacing(550);
        Label label = new Label("Suits");
        label.setStyle("-fx-text-fill: #D3D9d4");
        label.setFont(Font.font("sans-serif", FontWeight.BOLD, 20));
        hb.getChildren().addAll(backButton,label);
        suitsPage.setTop(hb);

        GridPane suitsGrid=new GridPane();
        suitsGrid.setStyle("-fx-background-image: url('/hpage.png'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        suitsGrid.setAlignment(Pos.TOP_LEFT);
        suitsGrid.setPadding(new Insets(10));
        suitsGrid.setHgap(10);
        suitsGrid.setVgap(10);
        suitsPage.setLeft(suitsGrid);

        List<Suit> suitsList=new ArrayList<>();
        suitsList.add(new Suit(5000,"Black Suit","D:\\Images\\blackSuit.jpeg"));
        suitsList.add(new Suit(5000,"Brown Suit","D:\\Images\\brownSuit.jpg"));
        suitsList.add(new Suit(5000,"Blue Suit","D:\\Images\\blueSuit.jpeg"));
        suitsList.add(new Suit(5000,"Gray Suit","D:\\Images\\graySuit.jpeg"));
        suitsList.add(new Suit(5000,"Green Suit","D:\\Images\\greenSuit.jpg"));
        suitsList.add(new Suit(5000,"White Suit","D:\\Images\\whiteSuit.jpeg"));
        suitsList.add(new Suit(5000,"Light blue Suit","D:\\Images\\lightblueSuit.jpeg"));
        suitsList.add(new Suit(5500,"Designed Suit","D:\\Images\\selfdesignedSuit.jpeg"));
        suitsList.add(new Suit(5500,"Blue designed Suit","D:\\Images\\liningblueSuit.jpeg"));
        suitsList.add(new Suit(2500,"Blue formal Coat","D:\\Images\\blueformalCoat.jpeg"));
        suitsList.add(new Suit(2500,"Black formal coat","D:\\Images\\blackformalCoat.jpeg"));
        suitsList.add(new Suit(2500,"Gray formal coat","D:\\Images\\grayformalCoat.jpeg"));
        suitsList.add(new Suit(2500,"Brown formal coat","D:\\Images\\brownformalCoat.jpeg"));
        suitsList.add(new Suit(2500,"Brown formal Pants","D:\\Images\\brownformalPant.jpeg"));
        suitsList.add(new Suit(2500,"Black formal Pants","D:\\Images\\blackformalPant.jpeg"));
        suitsList.add(new Suit(2500,"Blue formal Pants","D:\\Images\\blueformalPant.jpeg"));
        suitsList.add(new Suit(5500,"Gray formal Pants","D:\\Images\\grayformalPant.jpeg"));
        suitsList.add(new Suit(2500,"Black formal Shirt","D:\\Images\\blackformalShirt.jpeg"));
        suitsList.add(new Suit(2500,"White formal Shirt","D:\\Images\\whiteformalShirt.jpeg"));

        for (int i = 0; i < suitsList.size(); i++) {
            Suit suit=suitsList.get(i);
            suitsGrid.add(createSuitsCard(suit),i%6,i/6);

        }



        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(suitsGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        suitsPage.setCenter(scrollPane);

        Scene scene=new Scene(suitsPage,930,550);
        stage.setFullScreen(true);
        stage.setTitle("Formal Suits");
        stage.setScene(scene);
        stage.show();
    }
    private VBox createSuitsCard(Suit suit) throws FileNotFoundException {
        VBox suitsCard = new VBox();
        suitsCard.setAlignment(Pos.CENTER);
        suitsCard.setSpacing(10);
        suitsCard.setPadding(new Insets(5));
        suitsCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand");
        Image image = new Image(new FileInputStream(suit.getImagePath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setStyle("-fx-border-radius: 10px;-fx-background-radius: 10px");


        Label productName = new Label(suit.getName());
        productName.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
        productName.setStyle("-fx-text-fill: Black");

        Label pricelabel = new Label("price:" + suit.getPrice());
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
            OrdersDataStore.addOrders(new Order(suit.getName(), suit.getPrice(), 1));
            addToCartButton.setText("Added!");
            addToCartButton.setStyle("-fx-background-color: #1bc41b");
        });
        suitsCard.setOnMouseEntered(event -> {
            suitsCard.setStyle("-fx-border-width: 1px;-fx-border-color: #333333;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: #f0f0f0");
        });
        suitsCard.setOnMouseExited(event -> {
            suitsCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: white");
        });
        suitsCard.getChildren().addAll(productName, imageView, pricelabel, addToCartButton);


        return suitsCard;
    }
}
