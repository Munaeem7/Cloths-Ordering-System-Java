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

public class addJackets  {


    public void start(Stage stage) throws Exception {
        BorderPane jacketsPage = new BorderPane();

        jacketsPage.setPadding(new Insets(10));
        HBox hb = new HBox();
        hb.setStyle("-fx-background-color: #124E66;-fx-background-radius: 10px;-fx-border-radius: 10px");
        hb.setPadding(new Insets(10));
        hb.setSpacing(550);
        Button backButton=new Button("Back");

        backButton.setStyle("-fx-background-color:#333333;-fx-font-size:15;-fx-cursor:hand;-fx-text-fill: #D3D9d4;-fx-font-weight: bold");
        backButton.setOnAction(actionEvent -> {
             stage.close();
        });
        Label label = new Label("Suits");
        label.setStyle("-fx-text-fill: #D3D9d4");
        label.setFont(Font.font("sans-serif", FontWeight.BOLD, 20));
        hb.getChildren().addAll(backButton,label);
        jacketsPage.setTop(hb);

        backButton.setOnAction(actionEvent -> {
            stage.close();
        });



        GridPane jacketsGrid=new GridPane();
        jacketsGrid.setStyle("-fx-background-image: url('/hpage.png'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        jacketsGrid.setAlignment(Pos.TOP_LEFT);
        jacketsGrid.setPadding(new Insets(10));
        jacketsGrid.setHgap(10);
        jacketsGrid.setVgap(10);
        jacketsPage.setLeft(jacketsGrid);


        List<Jacket> jacketsList=new ArrayList<>();
        jacketsList.add(new Jacket(6000,"Black Leather Jacket","D:\\Images\\blackleatherJacket.jpeg"));
        jacketsList.add(new Jacket(6000,"Blue Leather Jacket","D:\\Images\\blueleatherJacket.jpeg"));
        jacketsList.add(new Jacket(6000,"Brown Leather Jacket","D:\\Images\\brownleatherJacket.jpeg"));
        jacketsList.add(new Jacket(6000,"Gray Leather Jacket","D:\\Images\\grayleatherJacket.jpeg"));
        jacketsList.add(new Jacket(4000,"Black Denim Jacket","D:\\Images\\blackdenimJacket.jpeg"));
        jacketsList.add(new Jacket(4000,"Blue Denim Jacket","D:\\Images\\bluedenimJacket.jpeg"));
        jacketsList.add(new Jacket(3000,"Black Waist coat","D:\\Images\\blackwaistCoat.jpeg"));
        jacketsList.add(new Jacket(3000,"Blue Waist coat","D:\\Images\\bluewaistCoat.jpeg"));
        jacketsList.add(new Jacket(3000,"Brown Waist coat","D:\\Images\\brownwaistCoat.jpeg"));
        jacketsList.add(new Jacket(6000,"Blue fur coat","D:\\Images\\bluefurJacket.jpg"));
        jacketsList.add(new Jacket(6000,"Black fur coat","D:\\Images\\blackfurJacket.jpeg"));
        jacketsList.add(new Jacket(6000,"Green fur coat","D:\\Images\\greenfurJacket.jpeg"));

        for (int i = 0; i < jacketsList.size(); i++) {
            Jacket jacket=jacketsList.get(i);
            jacketsGrid.add(createJacketsCard(jacket),i%6,i/6);
        }





        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(jacketsGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        jacketsPage.setCenter(scrollPane);



        Scene scene=new Scene(jacketsPage,930,550);
        stage.setFullScreen(true);
        stage.setTitle("Jackets");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createJacketsCard(Jacket jacket) throws FileNotFoundException {
        VBox jacketCard = new VBox();
        jacketCard.setAlignment(Pos.CENTER);
        jacketCard.setSpacing(10);
        jacketCard.setPadding(new Insets(5));
        jacketCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand");
        Image image = new Image(new FileInputStream(jacket.getImagePath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setStyle("-fx-border-radius: 10px;-fx-background-radius: 10px");


        Label productName = new Label(jacket.getName());
        productName.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
        productName.setStyle("-fx-text-fill: Black");

        Label pricelabel = new Label("price:" + jacket.getPrice());
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
            OrdersDataStore.addOrders(new Order(jacket.getName(), jacket.getPrice(), 1));
            addToCartButton.setText("Added!");
            addToCartButton.setStyle("-fx-background-color: #1bc41b");
        });
        jacketCard.setOnMouseEntered(event -> {
            jacketCard.setStyle("-fx-border-width: 1px;-fx-border-color: #333333;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: #f0f0f0");
        });
        jacketCard.setOnMouseExited(event -> {
            jacketCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: white");
        });
        jacketCard.getChildren().addAll(productName, imageView, pricelabel, addToCartButton);


        return jacketCard;
    }
}
