package com.techelevator.models;

import java.math.BigDecimal;
import java.util.function.BiFunction;

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

    // within vending machine, we get the idname and then this will return price
    public BigDecimal getPriceOfItem(String idName) {
        this.price = price;
        double priceDouble = Double.parseDouble(price);
        BigDecimal itemPriceBD = BigDecimal.valueOf(priceDouble);
        return itemPriceBD;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPrice() {return price;}
    public void setPrice(String price) {this.price = price;}

    public String getIdName() {return idName;}
    public void setIdName(String idName) {this.idName = idName;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public abstract String getMessage();

    public BigDecimal getPriceBD() {
        double priceDouble = Double.parseDouble(price);
        BigDecimal priceBD = new BigDecimal(priceDouble);
        return priceBD;}

}
