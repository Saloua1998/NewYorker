package com.example.newyorker;

public class Products {
    private String Brand, Price;

    public Products() {
    }

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
