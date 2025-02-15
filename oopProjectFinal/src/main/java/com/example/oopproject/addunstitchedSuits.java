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

public class addunstitchedSuits{

    public void start(Stage stage) throws Exception {
        BorderPane unstitchedSuitsPage = new BorderPane();

        unstitchedSuitsPage.setPadding(new Insets(10));
        HBox hb = new HBox();
        Button backButton=new Button("Back");

        backButton.setStyle("-fx-background-color:#333333;-fx-font-size:15;-fx-cursor:hand;-fx-text-fill: #D3D9d4;-fx-font-weight: bold");
        backButton.setOnAction(actionEvent -> {
            stage.close();
        });
        hb.setStyle("-fx-background-color: #124E66;-fx-background-radius: 10px;-fx-border-radius: 10px");
        hb.setPadding(new Insets(10));
        hb.setSpacing(550);
        Label label = new Label("unstitched Suits");
        label.setStyle("-fx-text-fill: #D3D9d4");
        label.setFont(Font.font("sans-serif", FontWeight.BOLD, 20));
        hb.getChildren().addAll(backButton,label);
        unstitchedSuitsPage.setTop(hb);


        GridPane unstitchedSuitsGrid=new GridPane();
        unstitchedSuitsGrid.setStyle("-fx-background-image: url('/hpage.png'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        unstitchedSuitsGrid.setAlignment(Pos.TOP_LEFT);
        unstitchedSuitsGrid.setPadding(new Insets(10));
        unstitchedSuitsGrid.setHgap(10);
        unstitchedSuitsGrid.setVgap(10);
        unstitchedSuitsPage.setLeft(unstitchedSuitsGrid);


        List<unstitchedSuits> unstitchedSuitsList=new ArrayList<>();
        unstitchedSuitsList.add(new unstitchedSuits(2500,"Black wash and wear","D:\\Images\\blackusSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"Blue wash and wear","D:\\Images\\blueusSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"Brown wash and wear","D:\\Images\\brownusSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"Skin wash and wear","D:\\Images\\skinusSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"Cream wash and wear","D:\\Images\\creamusSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"Blue embrioded wash and wear","D:\\Images\\blueembriodedkurtausSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"White embrioded wash and wear","D:\\Images\\whiteembriodedkurtausSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"White wash and wear","D:\\Images\\whiteusSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"Dark green wash and wear","D:\\Images\\greenusSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"Light purple wash and wear","D:\\Images\\lightpurpleusSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"Black cotton","D:\\Images\\blackcottonusSuit.jpeg"));
        unstitchedSuitsList.add(new unstitchedSuits(2500,"White cotton","D:\\Images\\whitecottonusSuit.jpeg"));


        for (int i = 0; i < unstitchedSuitsList.size(); i++) {
            unstitchedSuits usuits=unstitchedSuitsList.get(i);
            unstitchedSuitsGrid.add(createunstitchedSuitsCard(usuits),i%6,i/6);
        }



        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(unstitchedSuitsGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        unstitchedSuitsPage.setCenter(scrollPane);

        Scene scene=new Scene(unstitchedSuitsPage,930,550);
        stage.setTitle("Unstitched Suits");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }

    private VBox createunstitchedSuitsCard(unstitchedSuits suit) throws FileNotFoundException {
        VBox unstitchedSuitsCard = new VBox();
        unstitchedSuitsCard.setAlignment(Pos.CENTER);
        unstitchedSuitsCard.setSpacing(10);
        unstitchedSuitsCard.setPadding(new Insets(5));
        unstitchedSuitsCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand");
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
        unstitchedSuitsCard.setOnMouseEntered(event -> {
            unstitchedSuitsCard.setStyle("-fx-border-width: 1px;-fx-border-color: #333333;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: #f0f0f0");
        });
        unstitchedSuitsCard.setOnMouseExited(event -> {
            unstitchedSuitsCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: white");
        });
        unstitchedSuitsCard.getChildren().addAll(productName, imageView, pricelabel, addToCartButton);


        return unstitchedSuitsCard;
    }
}
