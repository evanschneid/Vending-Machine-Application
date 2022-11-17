package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends Item{

    private String message;

    public Munchy(String idName, String name, String price, String type) {
        super(idName, name, price, type);
        this.message = "Munchy, Munchy, so Good!";
    }

    public String getMessage() {return message;}
}
