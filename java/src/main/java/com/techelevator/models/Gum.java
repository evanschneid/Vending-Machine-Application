package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends Item{

    private String message;

//    public Gum(String idName, String name, String price, String type) {
//        super(idName, name, price, type);
//    }

    public Gum(String idName, String name, String price, String type, int inventory) {
        super(idName, name, price, type, inventory);
        //this.message = message;
    }

    public String getMessage() {return "Chewy, Chewy, Lots O Bubbles!";}
}
