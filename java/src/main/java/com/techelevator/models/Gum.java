package com.techelevator.models;

public class Gum extends Item{

    private String message;

    public Gum(String idName, String name, String price, String type, int inventory) {
        super(idName, name, price, type, inventory);
    }

    public String getMessage() {return "Chewy, Chewy, Lots O Bubbles!";}
}
