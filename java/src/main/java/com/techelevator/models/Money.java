package com.techelevator.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private BigDecimal balance = BigDecimal.ZERO;
    private BigDecimal quarter = new BigDecimal(0.25);
    private BigDecimal dime = new BigDecimal(0.10);
    private BigDecimal nickel = new BigDecimal(0.05);
    private BigDecimal totalSales = BigDecimal.ZERO;


    public void addToBalance(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void decreaseBalance(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public BigDecimal getBalance() {
        return balance.setScale(2, RoundingMode.HALF_UP);
    }

    public void balanceAfterChangeMade() {
        this.balance = this.balance.subtract(this.balance);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal boGoDo(BigDecimal price){
        return price.subtract(BigDecimal.ONE);
    }

    public BigDecimal getTotalSales() {return totalSales;}

    public void setTotalSales(BigDecimal totalSales) {this.totalSales = totalSales;}

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

    public void addToTotalSales(BigDecimal itemPrice) { // ****
        this.totalSales = this.totalSales.add(itemPrice);
    }

}



