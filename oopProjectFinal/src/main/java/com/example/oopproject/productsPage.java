package com.example.oopproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class productsPage  {
GridPane productsGrid;

    public void start(Stage primaryStage) throws FileNotFoundException {
        BorderPane productsPage = new BorderPane();
        productsPage.setPadding(new Insets(10));



        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: #124E66;-fx-background-radius: 10px;-fx-border-radius: 10px");
        hbox.setPadding(new Insets(10));

        Label label = new Label("Products");
        label.setStyle("-fx-text-fill: #D3D9d4");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        Button backButton=new Button("Back");

        backButton.setStyle("-fx-background-color:#333333;-fx-font-size:15;-fx-cursor:hand;-fx-text-fill: #D3D9d4;-fx-font-weight: bold");
        backButton.setOnAction(actionEvent -> {
            //primaryStage.close();
            UserHomePage userHomePage = new UserHomePage();
            userHomePage.start(primaryStage);

        });
        hbox.setSpacing(550);
        hbox.getChildren().addAll(backButton,label);
        productsPage.setTop(hbox);



        productsGrid = new GridPane();
        productsGrid.setStyle("-fx-background-image: url('/hpage.png'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        productsGrid.setAlignment(Pos.TOP_LEFT);
        productsGrid.setHgap(10);
        productsGrid.setVgap(30);
        productsGrid.setPadding(new Insets(20));
        productsPage.setLeft(productsGrid);

        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product("Shirts","D:\\Images\\shirt.jpg"));
        productsList.add(new Product("Pants","D:\\Images\\pants.jpg"));
        productsList.add(new Product("Suits","D:\\Images\\\\suit.jpg"));
        productsList.add(new Product("Unstitched Suits","D:\\Images\\Unstitched.jpg"));
        productsList.add(new Product("Jackets","D:\\Images\\Jacket.jpg"));
        productsList.add(new Product("Shoes","D:\\Images\\shoes.jpg"));
        productsList.add(new Product("Others","D:\\Images\\others.png"));

        for(int i=0;i<productsList.size();i++){
            Product product=productsList.get(i);
            productsGrid.add(createProductCard(product),i%6,i/6);
        }


        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setContent(productsGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        productsPage.setCenter(scrollPane);


        Scene scene = new Scene(productsPage, 930, 550);
        primaryStage.setScene(scene);
        primaryStage.setTitle("User Homepage");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }



    private static VBox createProductCard(Product product) throws FileNotFoundException {
       // Product product=new Product(name,imagepath);
        VBox productCard = new VBox();
        productCard.setAlignment(Pos.CENTER);
        productCard.setSpacing(10);
        productCard.setPadding(new Insets(5));
        productCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand");
        Image image=new Image(new FileInputStream(product.getImagePath()));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);
        imageView.setStyle("-fx-border-radius: 10px;-fx-background-radius: 10px");



        Label productName = new Label(product.getName());
        productName.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
        productName.setStyle("-fx-text-fill: Black");

//        Label pricelabel=new Label("price:"+product.getPrice());
//        pricelabel.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
//        pricelabel.setStyle("-fx-text-fill: Black");

//        Label discriptionlabel=new Label("discription 1");
//        discriptionlabel.setStyle("-fx-text-fill: Black");
//        discriptionlabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));

        Button visitmoreButton = new Button("Visit more");
        visitmoreButton.setOnAction(actionEvent -> {
            if(product.getName()=="Shirts"){
            try {
                addShirts addShirtsPage=new addShirts();
                Stage detailStage=new Stage();
                addShirtsPage.start(detailStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }}
            else if(product.getName()=="Pants"){
                try {
                    addPants addPantsPage=new addPants();
                    Stage detailStage=new Stage();
                    addPantsPage.start(detailStage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }}
            else if(product.getName()=="Suits"){
                try {
                    addSuits addSuitsPage=new addSuits();
                    Stage detailStage=new Stage();
                    addSuitsPage.start(detailStage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }}
            else if(product.getName()=="Unstitched Suits"){
                try {
                    addunstitchedSuits addunstitchedSuitsPage=new addunstitchedSuits();
                    Stage detailStage=new Stage();
                    addunstitchedSuitsPage.start(detailStage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }}
            else if(product.getName()=="Jackets"){
                try {
                    addJackets addjacketsPage=new addJackets();
                    Stage detailStage=new Stage();
                    addjacketsPage.start(detailStage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }}
            else if(product.getName()=="Shoes"){
                try {
                    addShoes addshoesPage=new addShoes();
                    Stage detailStage=new Stage();
                    addshoesPage.start(detailStage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }}
            else if(product.getName()=="Others"){
                try {
                    addOthers addothersPage=new addOthers();
                    Stage detailStage=new Stage();
                    addothersPage.start(detailStage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }}
        });
        visitmoreButton.setStyle("-fx-background-color: #124E66;-fx-text-fill: #D3D9d4;-fx-cursor: hand");
        visitmoreButton.setFont(Font.font("sans-serif", FontWeight.BOLD, 15));
        visitmoreButton.setPrefSize(150, 40);
        //addToCartButton.setAlignment(Pos.CENTER);
        visitmoreButton.setOnMouseEntered(actionEvent -> {
            visitmoreButton.setStyle("-fx-background-color: #333333;-fx-text-fill: white;-fx-cursor: hand");
        });
        visitmoreButton.setOnMouseExited(actionEvent -> {
            visitmoreButton.setStyle("-fx-background-color: #124E66;-fx-text-fill: #D3D9d4;-fx-cursor: hand");
        });
        productCard.setOnMouseEntered(event -> {
            productCard.setStyle("-fx-border-width: 1px;-fx-border-color: #333333;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: #f0f0f0");
        });
        productCard.setOnMouseExited(event ->{
            productCard.setStyle("-fx-border-width: 1px;-fx-border-color: #124E66;-fx-border-radius: 10px;-fx-background-radius: 10px;-fx-cursor: hand;-fx-background-color: white");
        });
        productCard.getChildren().addAll(productName,imageView,visitmoreButton);


        return productCard;
    }





}
