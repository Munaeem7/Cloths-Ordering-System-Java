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

public class addShoes {

    public void start(Stage stage) throws Exception {
        BorderPane shoesPage = new BorderPane();

        shoesPage.setPadding(new Insets(10));
        HBox hb = new HBox();
        Button backButton=new Button("Back");
        backButton.setStyle("-fx-background-color:#333333;-fx-font-size:15;-fx-cursor:hand;-fx-text-fill: #D3D9d4;-fx-font-weight: bold");
        backButton.setOnAction(actionEvent -> {
            stage.close();
        });
        hb.setStyle("-fx-background-color: #124E66;-fx-background-radius: 10px;-fx-border-radius: 10px");
        hb.setPadding(new Insets(10));
        hb.setSpacing(550);
        Label label = new Label("Shoes");
        label.setStyle("-fx-text-fill: #D3D9d4");
        label.setFont(Font.font("sans-serif", FontWeight.BOLD, 20));
        hb.getChildren().addAll(backButton,label);
        shoesPage.setTop(hb);

        GridPane shoesGrid=new GridPane();
        shoesGrid.setStyle("-fx-background-image: url('/hpage.png'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        shoesGrid.setAlignment(Pos.TOP_LEFT);
        shoesGrid.setPadding(new Insets(10));
        shoesGrid.setHgap(10);
        shoesGrid.setVgap(10);
        shoesPage.setLeft(shoesGrid);

        List<Shoes> shoesList=new ArrayList<>();
        shoesList.add(new Shoes(5000,"Black formal Shoes","D:\\Images\\blackformalShoes.jpeg"));
        shoesList.add(new Shoes(5000,"Brown formal Shoes","D:\\Images\\brownformalShoes.jpeg"));
        shoesList.add(new Shoes(5000,"Blue formal Shoes","D:\\Images\\blueformalShoes.jpeg"));
        shoesList.add(new Shoes(5000,"White formal Shoes","D:\\Images\\whiteformalShoes.jpeg"));
        shoesList.add(new Shoes(5000,"Gray formal Shoes","D:\\Images\\grayformalShoes.jpeg"));
        shoesList.add(new Shoes(5000,"White Sneakers","D:\\Images\\whiteSneakers.jpeg"));
        shoesList.add(new Shoes(5000,"Brown Sneakers","D:\\Images\\brownSneakers.jpeg"));
        shoesList.add(new Shoes(5500,"Blue Sneakers","D:\\Images\\blueSneakers.jpeg"));
        shoesList.add(new Shoes(5500,"Black Sneakers","D:\\Images\\blackSneakers.jpeg"));

        for (int i = 0; i < shoesList.size(); i++) {
            Shoes shoes=shoesList.get(i);
            shoesGrid.add(createShoesCard(shoes),i%6,i/6);

        }


        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(shoesGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        shoesPage.setCenter(scrollPane);

        Scene scene=new Scene(shoesPage,930,550);
        stage.setScene(scene);
        stage.setTitle("Shoes");
        stage.setFullScreen(true);
        stage.show();
    }

    private VBox createShoesCard(Shoes shoes) throws FileNotFoundException {
        VBox ShoesCard = new VBox();
        ShoesCard.setAlignment(Pos.CENTER);
        ShoesCard.setSpacing(10);
        ShoesCard.setPadding(new Insets(5));
        ShoesCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand");
        Image image = new Image(new FileInputStream(shoes.getImagePath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setStyle("-fx-border-radius: 10px;-fx-background-radius: 10px");


        Label productName = new Label(shoes.getName());
        productName.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
        productName.setStyle("-fx-text-fill: Black");

        Label pricelabel = new Label("price:" + shoes.getPrice());
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
            OrdersDataStore.addOrders(new Order(shoes.getName(), shoes.getPrice(), 1));
            addToCartButton.setText("Added!");
            addToCartButton.setStyle("-fx-background-color: #1bc41b");
        });
        ShoesCard.setOnMouseEntered(event -> {
            ShoesCard.setStyle("-fx-border-width: 1px;-fx-border-color: #333333;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: #f0f0f0");
        });
        ShoesCard.setOnMouseExited(event -> {
            ShoesCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: white");
        });
        ShoesCard.getChildren().addAll(productName, imageView, pricelabel, addToCartButton);


        return ShoesCard;
    }
}
