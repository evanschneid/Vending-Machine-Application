package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Item{

    private String message;

//    //public Candy(String idName, String name, String price, String type) {
//        super(idName, name, price, type);
//    }

    public String getMessage() {
        return "Sugar, Sugar, so Sweet!";
    }

    public Candy(String idName, String name, String price, String type, int inventory) {
        super(idName, name, price, type, inventory);
        //this.message = message;
    }
}


