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

public class addShirts {


    public void start(Stage stage) throws Exception {

        BorderPane shirtsPage = new BorderPane();

        shirtsPage.setPadding(new Insets(10));
        HBox hb = new HBox();
        hb.setSpacing(550);
        hb.setStyle("-fx-background-color: #124E66;-fx-background-radius: 10px;-fx-border-radius: 10px");
        hb.setPadding(new Insets(10));
        Button backButton=new Button("Back");
        backButton.setStyle("-fx-background-color:#333333;-fx-font-size:15;-fx-cursor:hand;-fx-text-fill: #D3D9d4;-fx-font-weight: bold");
        backButton.setOnAction(actionEvent -> {
            stage.close();
        });
        Label label = new Label("Shirts");
        label.setStyle("-fx-text-fill: #D3D9d4");
        label.setFont(Font.font("sans-serif", FontWeight.BOLD, 20));
        hb.getChildren().addAll(backButton,label);
        shirtsPage.setTop(hb);

        GridPane shirtsGrid=new GridPane();
        shirtsGrid.setStyle("-fx-background-image: url('/hpage.png'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        shirtsGrid.setAlignment(Pos.TOP_LEFT);
        shirtsGrid.setPadding(new Insets(10));
        shirtsGrid.setHgap(10);
        shirtsGrid.setVgap(10);
        shirtsPage.setLeft(shirtsGrid);

        List<Shirt> shirtsList=new ArrayList<>();
        shirtsList.add(new Shirt(2000,"Blue t-shirt","D:\\Images\\blueTshirt.jpg"));
        shirtsList.add(new Shirt(2000,"Red t-shirt","D:\\Images\\redTshirt.jpg"));
        shirtsList.add(new Shirt(2000,"Black t-shirt","D:\\Images\\blackTshirt.jpg"));
        shirtsList.add(new Shirt(2000,"White t-shirt","D:\\Images\\whiteTshirt.jpeg"));
        shirtsList.add(new Shirt(2000,"Brown t-shirt","D:\\Images\\brownTshirt.jpg"));
        shirtsList.add(new Shirt(2000,"Gray t-shirt","D:\\Images\\grayTshirt.jpeg"));
        shirtsList.add(new Shirt(2000,"Orange t-shirt","D:\\Images\\orangeTshirt.jpeg"));
        shirtsList.add(new Shirt(2000,"pink-blue t-shirt","D:\\Images\\pinkblueTshirt.jpeg"));


        for (int i = 0; i < shirtsList.size(); i++) {
            Shirt shirt=shirtsList.get(i);
            shirtsGrid.add(createShirtCard(shirt),i%6,i/6);
        }

        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(shirtsGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        shirtsPage.setCenter(scrollPane);

        Scene scene=new Scene(shirtsPage,930,550);
        stage.setFullScreen(true);
        stage.setTitle("Shirts");
        stage.setScene(scene);
        stage.show();

    }


    private VBox createShirtCard(Shirt shirt) throws FileNotFoundException {
        VBox shirtCard = new VBox();
        shirtCard.setAlignment(Pos.CENTER);
        shirtCard.setSpacing(10);
        shirtCard.setPadding(new Insets(5));
        shirtCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand");
        Image image = new Image(new FileInputStream(shirt.getImagePath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setStyle("-fx-border-radius: 10px;-fx-background-radius: 10px");


        Label productName = new Label(shirt.getName());
        productName.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
        productName.setStyle("-fx-text-fill: Black");

        Label pricelabel = new Label("price:" + shirt.getPrice());
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
            OrdersDataStore.addOrders(new Order(shirt.getName(), shirt.getPrice(), 1));
            addToCartButton.setText("Added!");
            addToCartButton.setStyle("-fx-background-color: #1bc41b");
        });
        shirtCard.setOnMouseEntered(event -> {
            shirtCard.setStyle("-fx-border-width: 1px;-fx-border-color: #333333;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: #f0f0f0");
        });
        shirtCard.setOnMouseExited(event -> {
            shirtCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: white");
        });
        shirtCard.getChildren().addAll(productName, imageView, pricelabel, addToCartButton);


        return shirtCard;
    }
}

