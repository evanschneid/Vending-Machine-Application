package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends Item{

    private String message;

    public Munchy(String idName, String name, String price, String type) {
        super(idName, name, price, type);
    }

    public String getMessage() {return "Munchy, Munchy, so Good!";}
}
