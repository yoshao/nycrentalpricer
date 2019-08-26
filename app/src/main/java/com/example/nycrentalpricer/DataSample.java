package com.example.nycrentalpricer;


public class DataSample {
    private String features;
    private String price;
    private String medianprice;

    public String getFeatures() {
        return features;
    }

    public String getMedianprice() {
        return medianprice;
    }

    public void setMedianprice(String medianprice) {
        this.medianprice = medianprice;
    }

    public String getPrice() {
        return price;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DataSample{" +
                "features='" + features + '\'' +
                ", price='" + price + '\'' +
                ", medianprice='" + medianprice + '\'' +
                '}';
    }
}