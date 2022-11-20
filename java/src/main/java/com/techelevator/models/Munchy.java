package com.techelevator.models;

public class Munchy extends Item{

    private String message;

    public Munchy(String idName, String name, String price, String type, int inventory) {
        super(idName, name, price, type, inventory);
    }

    public String getMessage() {return "Munchy, Munchy, so Good!";}
}
