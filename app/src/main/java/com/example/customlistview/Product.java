package com.example.customlistview;

public class Product {
    private String title;
    private String discription;
    private String type;
    private double price;
    private boolean sale;

    public Product(String title, String discription, String type, double price, boolean sale) {
        this.title = title;
        this.discription = discription;
        this.type = type;
        this.price = price;
        this.sale = sale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
}
