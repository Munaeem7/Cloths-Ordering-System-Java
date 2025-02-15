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

public class addPants {

    public void start(Stage stage) throws FileNotFoundException {
        BorderPane pantsPage = new BorderPane();

        pantsPage.setPadding(new Insets(10));
        HBox hb = new HBox();
        Button backButton=new Button("Back");

        backButton.setStyle("-fx-background-color:#333333;-fx-font-size:15;-fx-cursor:hand;-fx-text-fill: #D3D9d4;-fx-font-weight: bold");
        backButton.setOnAction(actionEvent -> {
            stage.close();
        });
        hb.setStyle("-fx-background-color: #124E66;-fx-background-radius: 10px;-fx-border-radius: 10px");
        hb.setPadding(new Insets(10));
        hb.setSpacing(550);
        Label label = new Label("Pants");
        label.setStyle("-fx-text-fill: #D3D9d4");
        label.setFont(Font.font("sans-serif", FontWeight.BOLD, 20));
        hb.getChildren().addAll(backButton,label);
        pantsPage.setTop(hb);

        GridPane pantsGrid=new GridPane();
        pantsGrid.setStyle("-fx-background-image: url('/hpage.png'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        pantsGrid.setAlignment(Pos.TOP_LEFT);
        pantsGrid.setPadding(new Insets(10));
        pantsGrid.setHgap(10);
        pantsGrid.setVgap(10);
        pantsPage.setLeft(pantsGrid);

        List<Pants> pantsList=new ArrayList<>();
        pantsList.add(new Pants(1500,"Blue jeans","D:\\Images\\bluepant.jpeg"));
        pantsList.add(new Pants(1500,"Gray jeans","D:\\Images\\graypant.jpeg"));
        pantsList.add(new Pants(1500,"Brown jeans","D:\\Images\\brownPant.jpeg"));
        pantsList.add(new Pants(1500,"Black jeans","D:\\Images\\black.jpeg"));
        pantsList.add(new Pants(1500,"Sky blue jeans","D:\\Images\\skybluePant.jpeg"));
        pantsList.add(new Pants(1500,"Black cargo ","D:\\Images\\blackcargoPant.jpeg"));
        pantsList.add(new Pants(1500,"Gray Trousers","D:\\Images\\grayTrousers.jpeg"));


        for (int i = 0; i < pantsList.size(); i++) {
            Pants pants=pantsList.get(i);
            pantsGrid.add(createPantsCard(pants),i%6,i/6);

        }

        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(pantsGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        pantsPage.setCenter(scrollPane);

        Scene scene=new Scene(pantsPage,930,550);
        stage.setFullScreen(true);
        stage.setTitle("Pants");
        stage.setScene(scene);
        stage.show();
    }
    private VBox createPantsCard(Pants pant) throws FileNotFoundException {
        VBox pantsCard = new VBox();
        pantsCard.setAlignment(Pos.CENTER);
        pantsCard.setSpacing(10);
        pantsCard.setPadding(new Insets(5));
        pantsCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand");
        Image image = new Image(new FileInputStream(pant.getImagePath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setStyle("-fx-border-radius: 10px;-fx-background-radius: 10px");


        Label productName = new Label(pant.getName());
        productName.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
        productName.setStyle("-fx-text-fill: Black");

        Label pricelabel = new Label("price:" + pant.getPrice());
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
            OrdersDataStore.addOrders(new Order(pant.getName(), pant.getPrice(), 1));
            addToCartButton.setText("Added!");
            addToCartButton.setStyle("-fx-background-color: #1bc41b");
        });
        pantsCard.setOnMouseEntered(event -> {
            pantsCard.setStyle("-fx-border-width: 1px;-fx-border-color: #333333;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: #f0f0f0");
        });
        pantsCard.setOnMouseExited(event -> {
            pantsCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: white");
        });
        pantsCard.getChildren().addAll(productName, imageView, pricelabel, addToCartButton);


        return pantsCard;
    }
}
