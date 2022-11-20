package com.techelevator.models;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public abstract class Item {

    private String idName;
    private String name;
    private String price;
    private String type;
    private int inventory = 6;
    private int startingSaleAmount = 0;
    private int startingBOGODOSaleAmount = 0;

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

    public int getStartingSaleAmount() {return startingSaleAmount;}

    public void increaseSalesAmount() {this.startingSaleAmount = this.startingSaleAmount + 1;}

    public int getStartingBOGODOSaleAmount() {return startingBOGODOSaleAmount;}

    public void increaseBOGODOSalesAmount() {this.startingBOGODOSaleAmount = this.startingBOGODOSaleAmount + 1;}

    public int getInventory() {
        return inventory;
    }

    public String getName() {return name;}

    public String getPrice() {return price;}

    public String getIdName() {return idName;}

    public String getType() {return type;}

    public abstract String getMessage();

    public void setStartingSaleAmount(int startingSaleAmount) {this.startingSaleAmount = startingSaleAmount;}

    public void setStartingBOGODOSaleAmount(int startingBOGODOSaleAmount) {this.startingBOGODOSaleAmount = startingBOGODOSaleAmount;}
}
