package com.example.oopproject;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class seeOrders{
    private Label totalAmountLabel;

    public void start(Stage stage) {

        BorderPane seeOrdersPage = new BorderPane();
        seeOrdersPage.setStyle("-fx-background-image: url('/hpage.png'); " +
                "-fx-background-size: cover; " +
                "-fx-background-position: center center;");
        seeOrdersPage.setPadding(new Insets(10));

        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: #124E66;-fx-background-radius: 10px;-fx-border-radius: 10px");
        hbox.setPadding(new Insets(10));

        Label label = new Label("See Orders");
        label.setStyle("-fx-text-fill: #D3D9d4");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        Button backButton = new Button("Back");

        backButton.setStyle("-fx-background-color:#333333;-fx-font-size:15;-fx-cursor:hand;-fx-text-fill: #D3D9d4;-fx-font-weight: bold");
        backButton.setOnAction(actionEvent -> {
            UserHomePage userHomePage = new UserHomePage();
            userHomePage.start(stage);
        });

        hbox.setSpacing(550);
        hbox.getChildren().addAll(backButton, label);
        seeOrdersPage.setTop(hbox);

        Button addButton = new Button("Add product");
        addButton.setStyle("-fx-background-color: #124E66;-fx-text-fill: #D3D9d4;-fx-cursor: hand;-fx-font-weight: bold;-fx-font-size: 13px");
        addButton.setOnAction(actionEvent -> {
            productsPage page = new productsPage();
            try {
                page.start(stage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        Button deleteAllButton = new Button("Delete all products");
        deleteAllButton.setStyle("-fx-background-color: #124E66;-fx-text-fill: #D3D9d4;-fx-cursor: hand;-fx-font-weight: bold;-fx-font-size: 13px");

        TableView<Order> tableView = new TableView<>();

        TableColumn<Order, Integer> productPriceCol = new TableColumn<>("Product Price");
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Order, String> productNameCol = new TableColumn<>("Product Name");
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));

        TableColumn<Order, Integer> productQuantityCol = new TableColumn<>("Product Quantity");
        productQuantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Order, Void> deleteCol = new TableColumn<>("Delete Product");
        deleteCol.setCellFactory(param -> new TableCell<>() {
            private final Button deleteButton = new Button("Delete");

            {
                deleteButton.setOnAction(actionEvent -> {
                    Order order = getTableView().getItems().get(getIndex());

                    Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    deleteAlert.setTitle("Delete Order");
                    deleteAlert.setHeaderText(null);
                    deleteAlert.setContentText("Are you sure you want to delete this order?");

                    deleteAlert.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            tableView.getItems().remove(order);
                            OrdersDataStore.deleteOrder(order);

                            Alert deletionAlert = new Alert(Alert.AlertType.INFORMATION);
                            deletionAlert.setTitle("Order deleted");
                            deletionAlert.setHeaderText(null);
                            deletionAlert.setContentText("Order deleted successfully");
                            deletionAlert.showAndWait();
                            updateTotalAmount();
                        }
                    });
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        });

        TableColumn<Order, Void> quantityCol = new TableColumn<>("Adjust Quantity");
        quantityCol.setCellFactory(param -> new TableCell<>() {
            private final Button increaseButton = new Button("+");
            private final Button decreaseButton = new Button("-");

            {
                increaseButton.setOnAction(actionEvent -> {
                    Order order = getTableView().getItems().get(getIndex());
                    order.setQuantity(order.getQuantity() + 1);
                    getTableView().refresh();
                    OrdersDataStore.saveOrders();
                    updateTotalAmount();
                });

                decreaseButton.setOnAction(actionEvent -> {
                    Order order = getTableView().getItems().get(getIndex());
                    if (order.getQuantity() > 1) {
                        order.setQuantity(order.getQuantity() - 1);
                        getTableView().refresh();
                        OrdersDataStore.saveOrders();
                        updateTotalAmount();
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox hbox = new HBox(5, increaseButton, decreaseButton);
                    setGraphic(hbox);
                }
            }
        });

        tableView.getColumns().addAll(productNameCol, productPriceCol, productQuantityCol, quantityCol, deleteCol);

        ObservableList<Order> orders = OrdersDataStore.getOrders();
        tableView.setItems(orders);

        totalAmountLabel = new Label();
        totalAmountLabel.setStyle("-fx-text-fill: #124E66;-fx-font-weight: bold;-fx-font-size: 16px");
        updateTotalAmount();
        Button confirmButton = new Button("Confirm Order");
        confirmButton.setStyle("-fx-background-color: #124E66;-fx-text-fill: #D3D9d4;-fx-cursor: hand;-fx-font-weight: bold;-fx-font-size: 13px");

        confirmButton.setOnAction(actionEvent -> {
            tableView.getItems().clear();
            OrdersDataStore.deleteAllOrders();
            updateTotalAmount();
            UserHomePage page=new UserHomePage();
            page.start(stage);
        });
        VBox vbox = new VBox(10, addButton, deleteAllButton, tableView, totalAmountLabel,confirmButton);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(50, 50, 100, 100));
        seeOrdersPage.setCenter(vbox);

        stage.setOnCloseRequest(windowEvent -> OrdersDataStore.saveOrders());

        deleteAllButton.setOnAction(actionEvent -> {
            if (tableView.getItems().isEmpty()) {
                Alert nullAlert = new Alert(Alert.AlertType.INFORMATION);
                nullAlert.setTitle("Empty");
                nullAlert.setHeaderText(null);
                nullAlert.setContentText("Table is empty");
                nullAlert.showAndWait();
            } else {
                Alert deleteData = new Alert(Alert.AlertType.CONFIRMATION);
                deleteData.setTitle("Delete All Product");
                deleteData.setHeaderText(null);
                deleteData.setContentText("Are you really want to delete all data?");

                deleteData.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        tableView.getItems().clear();
                        OrdersDataStore.deleteAllOrders();
                        updateTotalAmount();
                        Alert confirmationDelete = new Alert(Alert.AlertType.INFORMATION);
                        confirmationDelete.setTitle("Orders Deleted");
                        confirmationDelete.setContentText("All orders deleted successfully");
                        confirmationDelete.showAndWait();
                    }
                });
            }
        });

        Scene scene = new Scene(seeOrdersPage, 930, 550);
        stage.setTitle("See Orders");
        stage.setScene(scene);
        stage.show();
    }

    private void updateTotalAmount() {
        double total = OrdersDataStore.getOrders().stream()
                .mapToDouble(order -> order.getPrice() * order.getQuantity())
                .sum();
        totalAmountLabel.setText("Total Amount: " + total + " Rs");
    }

}
