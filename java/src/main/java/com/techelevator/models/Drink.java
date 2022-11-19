package com.techelevator.models;

public class Drink extends Item{

    private String message;

//    public Drink(String idName, String name, String price, String type) {
//        super(idName, name, price, type);
//    }


    public Drink(String idName, String name, String price, String type, int inventory) {
        super(idName, name, price, type, inventory);
        //this.message = message;
    }

    public String getMessage() {return "Drinky, Drinky, Slurp Slurp!";}
}
