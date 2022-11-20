package com.techelevator.models;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public abstract class Item {

    private String idName;
    private String name;
    private String price;
    private String type;
    private int inventory = 6;

    public Item(String idName, String name, String price, String type, int inventory) {
        this.idName = idName;
        this.name = name;
        this.price = price;
        this.type = type;
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return idName + ", "+ name + ", $" + price + ", " + type;
    }

    public void decreaseInventory() {
        this.inventory = this.inventory - 1;
    }

    public int getInventory() {
        return inventory;
    }


    // within vending machine, we get the idname and then this will return price
    public BigDecimal getPriceOfItem(String idName) {
        this.price = price;
        double priceDouble = Double.parseDouble(price);
        BigDecimal itemPriceBD = BigDecimal.valueOf(priceDouble);
        return itemPriceBD;
    }

    public BigDecimal getPriceBD() {
        double priceDouble = Double.parseDouble(price);
        BigDecimal priceBD = new BigDecimal(priceDouble);
        return priceBD;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
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

}
