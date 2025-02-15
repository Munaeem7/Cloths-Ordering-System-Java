package com.example.oopproject;

import java.util.ArrayList;
import java.util.List;

public class Pants {
    int price;
    String name;
    String imagePath;

    public Pants(int price, String name,String imagePath) {
        this.price = price;
        this.name = name;
        this.imagePath = imagePath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // List to store all pants
    public static List<Pants> pantsList = new ArrayList<>();

    // Method to add a pant to the list
    public static void addPant(Pants pant) {
        pantsList.add(pant);
    }
}
