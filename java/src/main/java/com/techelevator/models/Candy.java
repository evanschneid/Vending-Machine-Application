package com.techelevator.models;

public class Candy extends Item{

    private String message;

    public Candy(String idName, String name, String price, String type, int inventory) {
        super(idName, name, price, type, inventory);
    }

    public String getMessage() {return "Sugar, Sugar, so Sweet!";}
}


