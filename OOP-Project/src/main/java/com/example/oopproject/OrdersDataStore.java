package com.example.oopproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDataStore {

        private static final ObservableList<Order> orders= FXCollections.observableArrayList();
        private static final String file_path = "Orders.ser";

        static{
            loadOrders();
        }

        public static ObservableList<Order> getOrders(){
            return orders;
        }
        public static void addOrders(Order order){
            orders.add(order);
            saveOrders();
        }
        public static void deleteOrder(Order order){
            orders.remove(order);
            saveOrders();
        }
        public static void deleteAllOrders(){
            orders.clear();
            saveOrders();
        }



        static void saveOrders() {
            try {
                ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(file_path));
                oos.writeObject(new ArrayList<>(orders));
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private static void loadOrders(){
            File file=new File(file_path);
            if(file.exists()){
                try {
                    ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
                    List<Order> savedOrders=(List<Order>) ois.readObject();
                    orders.addAll(savedOrders);
                    ois.close();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }else{
                System.out.println("File does not exist");
            }
        }

}
