package com.techelevator.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class Money {

    private BigDecimal balance = BigDecimal.ZERO;
    private BigDecimal quarter = new BigDecimal(0.25);
    private BigDecimal dime = new BigDecimal(0.10);
    private BigDecimal nickel = new BigDecimal(0.05);


    public void addToBalance(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void decreaseBalance(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public BigDecimal getBalance() {
        return balance.setScale(2, RoundingMode.HALF_UP);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal boGoDo(BigDecimal price){
        return price.subtract(BigDecimal.ONE);
    }

    public BigDecimal stringToBigDecimal (String balance) {
        double finalBalanceNum = Double.parseDouble(balance);
        BigDecimal bd = new BigDecimal(finalBalanceNum).setScale(2, RoundingMode.HALF_UP);
        return bd;
    }

    public int[] getChange() {

        int[] coinArray = new int[4];
        double changeDue = balance.doubleValue();


        int change = (int) (Math.ceil(changeDue * 100));
        int dollars = Math.round((int) change / 100);
        change = change % 100;
        int quarters = Math.round((int) change / 25);
        change = change % 25;
        int dimes = Math.round((int) change / 10);
        change = change % 10;
        int nickels = Math.round((int) change / 5);
        change = change % 5;

        coinArray[0] = dollars;
        coinArray[1] = quarters;
        coinArray[2] = dimes;
        coinArray[3] = nickels;

        return coinArray;
    }

//    public void getChange(BigDecimal balance) {
//        //int[] array = new int[4];
//        double changeDue = balance.doubleValue();
//
//
//        int change = (int) (Math.ceil(changeDue * 100));
//        int dollars = Math.round((int) change / 100);
//        change = change % 100;
//        int quarters = Math.round((int) change / 25);
//        change = change % 25;
//        int dimes = Math.round((int) change / 10);
//        change = change % 10;
//        int nickels = Math.round((int) change / 5);
//        change = change % 5;
//        // int pennies = Math.round((int) change / 1);
//
////        array[0] = dollars;
////        array[1] = quarters;
////        array[2] = dimes;
////        array[3] = nickels;
//
//        System.out.println("Dollars: " + dollars);
//        System.out.println("Quarters: " + quarters);
//        System.out.println("Dimes: " + dimes);
//        System.out.println("Nickels: " + nickels);
//        // System.out.println("Pennies: " + pennies);
//
//    }
}






    /*    public BigDecimal getCurrentBalance(String startingBalance, String moneyAdded) {
        BigDecimal startBalanceBD = BigDecimal.valueOf(0);
        BigDecimal addedBalanceBD = BigDecimal.
        addedBalanceBD.add(startBalanceBD);
        return addedBalanceBD;
    }*/


