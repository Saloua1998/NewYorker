package com.example.newyorker;

public class Products {
    //The fields must match the names in the database
    private String Brand, Price, Category;

    public Products() {}

    public Products(String brand, String price, String category) {
        Brand = brand;
        Price = price;
        Category = category;
    }

    public String getBrand() { return Brand; }

    public void setBrand(String brand) { Brand = brand; }

    public String getPrice() { return Price; }

    public void setPrice(String price) { Price = price; }

    public String getCategory() { return Category; }

    public void setCategory(String category) { Category = category; }

}
