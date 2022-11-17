package com.techelevator.models;

import java.math.BigDecimal;

public abstract class Item {

    private String idName;
    private String name;
    private String price;
    private String type;

    public Item(String idName, String name, String price, String type) {
        this.idName = idName;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return idName + ", "+ name + ", $" + price + ", " + type;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPrice() {return price;}
    public void setPrice(String price) {this.price = price;}

    public String getIdName() {return idName;}
    public void setIdName(String idName) {this.idName = idName;}

    public BigDecimal getPriceBD() {
        double priceDouble = Double.parseDouble(price);
        BigDecimal priceBD = new BigDecimal(priceDouble);
        return priceBD;}
}
