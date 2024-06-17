package com.example;

public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private double purchasePrice;
    private double sellingPrice;

    public Vehicle(String brand, String model, int year, int mileage, double purchasePrice, double sellingPrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    // Getter und Setter Methoden

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
