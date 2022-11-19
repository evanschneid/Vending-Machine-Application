package com.techelevator.application;

import com.techelevator.models.Inventory;
import com.techelevator.models.Item;
import com.techelevator.models.Money;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachine
{
    private UserInput userInput = new UserInput();
    private UserOutput userOutput = new UserOutput();
    private Money money = new Money();

    public void run() {

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                UserOutput.displayInventoryOutput();
                System.out.println("Press ENTER to continue");
                choice = UserInput.getDisplayInventoryOption();
            }
             else if (choice.equals("purchase")) {
                    // make a purchase
                    UserOutput.displayPurcahseScreen();
                    choice = UserInput.getPurchaseScreen();
                    while (!choice.equals("Finish Transaction")) {
                        if (choice.equals("Feed Money")) {
                            UserOutput.displayFeedMoney();
                            System.out.println("Current money provided: " + money.getBalance());
                            choice = UserInput.getFeedMoneyScreen();
                            BigDecimal inputNumber = money.stringToBigDecimal(choice);
                            //while (choice.equals("1") || choice.equals("5") || choice.equals("10") || choice.equals("20")) {
//                            while (!choice.equals("purchase")) {
//                                UserOutput.displayFeedMoney();
//                                //System.out.println(money.getBalance());

                            money.addToBalance(inputNumber);
                            System.out.println("New balance: " + "$" + money.getBalance());
                            System.out.println();
                            System.out.println("Press ENTER to continue");
                            choice = UserInput.getFeedMoneyScreen();
//                                if (money.getBalance().equals(0)) {
//                                    System.out.println(money.getBalance());
//                                    money.addToBalance(inputNumber);
////                                    System.out.println(UserOutput.displayCurrentBalance(0));
////                                    int currentBalance = money.getCurrentBalance(startingBalance, choice);
////                                    String curBal = String.valueOf(currentBalance);
////                                    startingBalance = curBal;
//                                } else if (!money.getBalance().equals(0)) {
//                                    int currentBalance = money.getCurrentBalance(startingBalance, choice);
//                                    System.out.println(UserOutput.displayCurrentBalance(currentBalance));
//                                    String curBal = String.valueOf(currentBalance);
//                                    startingBalance = curBal;
//                                }
//                                choice = UserInput.getFeedMoneyScreen();
//
//                            //}
                            UserOutput.displayPurcahseScreen();
                            choice = UserInput.getPurchaseScreen();
                        }
                        if (choice.equals("Select Item")) {
                            UserOutput.displaySelectItem();
                            choice = UserInput.getSelectItemScreen();

                           // while (!choice.equals("Finish Transaction")) {
                                Inventory inventory = new Inventory();
                                List<Item> invList = inventory.getInventoryList();
                                int counter = 0;
                                for (int i = 0; i < invList.size(); i++) {
                                    if (choice.equals(invList.get(i).getIdName())) {
                                        BigDecimal itemPriceBD = money.stringToBigDecimal(invList.get(i).getPrice());
                                        if (invList.get(i).getInventory() == 0) {
                                            System.out.println("NO LONGER AVAILABLE");
                                        } else {
                                            if (counter % 2 != 0){
                                                money.boGoDo(itemPriceBD);
                                                System.out.println("BOGODO! - you save $1");
                                                invList.get(i).decreaseInventory();
                                                System.out.println("current item inventory " + invList.get(i).getInventory());
                                                //BigDecimal itemPriceBD = money.stringToBigDecimal(invList.get(i).getPrice());
                                               // money.decreaseBalance(itemPriceBD);
                                            } else {
                                                invList.get(i).decreaseInventory();
                                                System.out.println("current item inventory " + invList.get(i).getInventory());
                                                //BigDecimal itemPriceBD = money.stringToBigDecimal(invList.get(i).getPrice());
                                                money.decreaseBalance(itemPriceBD);
                                            }
                                            System.out.println();
                                            System.out.println(invList.get(i).toString());
                                            System.out.println(invList.get(i).getMessage());
                                            System.out.println();
                                            System.out.println("Remaining Balance: $" + money.getBalance());
                                            System.out.println();
                                            counter++;
                                            //                                        BigDecimal inputNumber = money.stringToBigDecimal(choice);
//                                        money.decreaseBalance(inputNumber);
//                                        String currentBalanceAsString = newCurrentBalance.toString();
//                                        startingBalance = currentBalanceAsString;
////                                        break;
                                        }
                                        System.out.println("Press ENTER to continue");
                                        choice = UserInput.getSelectItemScreen();
                                        UserOutput.displayPurcahseScreen();
                                        choice = UserInput.getPurchaseScreen();

                                    }
                                }
//                                choice = UserInput.getPurchaseScreen();
//                                if (choice.equals("Finish Transaction")) {
//                                    BigDecimal toChange = money.getFinalBalanceBD(startingBalance);
//                                    System.out.println("Amount to change: " + toChange);
//                                    UserOutput.displayFinalTransaction();
//
//                                }
                            //}

                        }

                    }
                    if (choice.equals("Finish Transaction")) {
//                        BigDecimal toChange = money.getBalance();
//                        int scale = 2;
//                        BigDecimal coins = toChange.setScale(scale);

                        System.out.println("Change to Receive: $" + money.getBalance());
                        UserOutput.displayFinalTransaction();
                        //toChange.toBigIntegerExact();
                        if(money.getBalance().remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                           // System.out.println(money.getBalance() + " dollars");
                            money.getChange();
                        }  else {
//                            BigInteger dollars = money.getBalance().toBigInteger();
//                            BigDecimal change = money.getBalance().remainder(BigDecimal.ONE);
//                            System.out.println("$" + dollars + " dollars");
                            money.getChange();


//                            MathContext mathContext = new MathContext(1);
//                            //BigDecimal dollars = toChange.round(mathContext);
//                            BigInteger dollarsInt = toChange.toBigInteger();
//                            BigDecimal change = toChange.remainder(BigDecimal.valueOf(1));
//                            BigDecimal cents = change.multiply(BigDecimal.valueOf(100)).stripTrailingZeros();
//                            //int scale2 = 0;
//                            //BigDecimal cents2 = cents.setScale(scale2);
//                            //System.out.println(dollars + " dollars " + cents + " cents");
//                             toChange = toChange.setScale(2, RoundingMode.HALF_UP);
//                            System.out.println(toChange);
////                            System.out.println(dollarsInt + " dollars " + cents + " cents");
                        }
                    }
                }
            //}
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    
}

/*                        BigDecimal currentBalance = money.getCurrentBalance(startingBalance, choice);
                        BigDecimal startBalBD = BigDecimal.valueOf();
                        System.out.println(UserOutput.displayCurrentBalance(currentBalance));
                        startingBalance = currentBalance;*/