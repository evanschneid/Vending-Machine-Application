package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends Item{

    private String message;

//    public Munchy(String idName, String name, String price, String type) {
//        super(idName, name, price, type);
//    }

    public Munchy(String idName, String name, String price, String type, int inventory) {
        super(idName, name, price, type, inventory);
        //this.message = message;
    }

    public String getMessage() {return "Munchy, Munchy, so Good!";}
}
