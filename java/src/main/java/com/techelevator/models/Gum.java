package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends Item{

    private String message;

    public Gum(String idName, String name, String price, String type) {
        super(idName, name, price, type);
        this.message = "Chewy, Chewy, Lots O Bubbles!";
    }

    public String getMessage() {return message;}
}
