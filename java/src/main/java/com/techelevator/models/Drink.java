package com.techelevator.models;

public class Drink extends Item{

    private String message;

    public Drink(String idName, String name, String price, String type) {
        super(idName, name, price, type);
        this.message = "Drinky, Drinky, Slurp Slurp!";
    }

    public String getMessage() {return message;}
}
