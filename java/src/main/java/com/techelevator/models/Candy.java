package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Item{

    private String message;

    public Candy(String idName, String name, String price, String type) {
        super(idName, name, price, type);
       this.message = "Sugar, Sugar, so Sweet!";
    }

    public String getMessage() {return message;}
}
