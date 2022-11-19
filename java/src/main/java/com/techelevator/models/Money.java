package com.techelevator.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class Money {

    private String startingBalance;
    private String finalBalance;
    private BigDecimal quarter = new BigDecimal(0.25);
    private BigDecimal dime = new BigDecimal(0.10);
    private BigDecimal nickel = new BigDecimal(0.05);

    private BigDecimal balance = BigDecimal.ZERO;

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

    public void boGoDo(BigDecimal price){
        BigDecimal newPrice = price.subtract(BigDecimal.ONE);
        this.balance = this.balance.subtract(newPrice);
    }
    // method for make change



//    public int getCurrentBalance(String currentBalance, String moneyAdded) {
//        int startBalString = Integer.parseInt(currentBalance);
//        int moneyAddString = Integer.parseInt(moneyAdded);
//        return startBalString + moneyAddString;
//    }

    public BigDecimal getNewBalance(String currentBalance, String itemPrice) {
        double startDouble = Double.parseDouble(currentBalance);
        double itemPriceDouble = Double.parseDouble(itemPrice);
        BigDecimal startBalBD = BigDecimal.valueOf(startDouble);
        BigDecimal itemPriceBD = BigDecimal.valueOf(itemPriceDouble);
        BigDecimal newBalanceBD = startBalBD.subtract(itemPriceBD);
        return newBalanceBD;
    }


    public BigDecimal stringToBigDecimal (String balance) {
        double finalBalanceNum = Double.parseDouble(balance);
        BigDecimal bd = new BigDecimal(finalBalanceNum).setScale(2, RoundingMode.HALF_UP);
        return bd;
    }

    public void getChange() {
        BigInteger dollars = balance.toBigInteger();
        BigDecimal cents = balance.remainder(BigDecimal.ONE);

        BigDecimal Quarters = (cents.remainder(quarter).multiply(BigDecimal.valueOf(100))).divide(BigDecimal.valueOf(100.0)) ;
        BigDecimal Dimes = (Quarters.remainder(dime).multiply(BigDecimal.valueOf(100))).divide(BigDecimal.valueOf(100.0));
        BigDecimal Nickels = (Dimes.remainder(nickel).multiply(BigDecimal.valueOf(100))).divide(BigDecimal.valueOf(100.0));

        BigDecimal numQuarters = (cents.subtract(Quarters)).divide(quarter);
        BigDecimal numDimes = (Quarters.subtract(Dimes)).divide(dime);
        BigDecimal numNickels = (Dimes.subtract(Nickels)).divide(nickel);

            BigInteger intQuarter = numQuarters.toBigInteger();
            BigInteger intDimes = numDimes.toBigInteger();
            BigInteger intNickels = numNickels.toBigInteger();

//        BigDecimal quarter = cents.multiply(BigDecimal.valueOf(100)).remainder(BigDecimal.valueOf(25));
//        cents = cents.subtract(quarter.multiply(BigDecimal.valueOf(25)));
//        BigDecimal dime = cents.remainder(BigDecimal.valueOf(10));
//        cents = cents.subtract(dime.multiply(BigDecimal.valueOf(10)));
//        BigDecimal nickle = cents.remainder(BigDecimal.valueOf(5));
//        cents = cents.subtract(nickle.multiply(BigDecimal.valueOf(5)));


        try {
            System.out.println("Number of dollars: " + dollars);
            System.out.println("Number of quarters: " + intQuarter);
            System.out.println("Number of dimes: " + intDimes);
            System.out.println("Number of nickels: " + intNickels);

        } catch(NullPointerException e) {

        }
    }






    /*    public BigDecimal getCurrentBalance(String startingBalance, String moneyAdded) {
        BigDecimal startBalanceBD = BigDecimal.valueOf(0);
        BigDecimal addedBalanceBD = BigDecimal.
        addedBalanceBD.add(startBalanceBD);
        return addedBalanceBD;
    }*/

}
