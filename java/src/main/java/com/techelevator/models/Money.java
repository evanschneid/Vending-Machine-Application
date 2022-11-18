package com.techelevator.models;

import com.techelevator.ui.UserInput;

import java.math.BigDecimal;
import java.util.Scanner;

public class Money {

    private int startingBalance;
    private int finalBalance;
    private static Scanner scanner = new Scanner(System.in);

    // method for make change
    // for feed money

    public int getCurrentBalance(String startingBalance, String moneyAdded) {
        int startBalString = Integer.parseInt(startingBalance);
        int moneyAddString = Integer.parseInt(moneyAdded);
        return startBalString + moneyAddString;
    }

    public BigDecimal getNewBalance(String startingBalance, String itemPrice) {
        double startDouble = Double.parseDouble(startingBalance);
        double itemPriceDouble = Double.parseDouble(itemPrice);
        BigDecimal startBalBD = BigDecimal.valueOf(startDouble);
        BigDecimal itemPriceBD = BigDecimal.valueOf(itemPriceDouble);
        BigDecimal newBalanceBD = startBalBD.subtract(itemPriceBD);
        return newBalanceBD;
    }

/*    public BigDecimal getCurrentBalance(String startingBalance, String moneyAdded) {
        BigDecimal startBalanceBD = BigDecimal.valueOf(0);
        BigDecimal addedBalanceBD = BigDecimal.
        addedBalanceBD.add(startBalanceBD);
        return addedBalanceBD;
    }*/

}
