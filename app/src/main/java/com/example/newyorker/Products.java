package com.example.newyorker;

import android.graphics.Bitmap;

public class Products {
    //The fields must match the names in the database
    private String Brand, Price;

    public Products() {}

    public Products(String brand, String price) {
        Brand = brand;
        Price = price;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
