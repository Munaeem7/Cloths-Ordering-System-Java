package com.example.oopproject;


public class Shirt {
    int price;
    String name;
    String imagePath;

    public Shirt(int price,String name,String imagePath) {
        this.price=price;
        this.name=name;
        this.imagePath=imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




}
