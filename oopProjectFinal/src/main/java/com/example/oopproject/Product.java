package com.example.oopproject;

public class Product {
    private String productName;
    private String imagePath;

    public Product( String productName,String imagePath) {
        this.productName = productName;
        this.imagePath = imagePath;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return  " productName='" + productName + '\''
                ;
    }

    public String getName() {
        return productName;
    }

    public String getDescription() {
        return "description";
    }
}
