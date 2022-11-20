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
    private Inventory inventory = new Inventory();

    public void run() {

        List<Item> invList = inventory.getInventoryList();

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
                            money.addToBalance(inputNumber);
                            System.out.println("New balance: " + "$" + money.getBalance());
                            System.out.println();
                            System.out.println("Press ENTER to continue");
                            choice = UserInput.getFeedMoneyScreen();

                            UserOutput.displayPurcahseScreen();
                            choice = UserInput.getPurchaseScreen();
                        }
                        if (choice.equals("Select Item")) {
                            UserOutput.displaySelectItem();
                            choice = UserInput.getSelectItemScreen();

                           // while (!choice.equals("Finish Transaction")) {


                                int counter = 0;
                                for (int i = 0; i < invList.size(); i++) {
                                     if (choice.equals(invList.get(i).getIdName())) {
                                        BigDecimal itemPriceBD = money.stringToBigDecimal(invList.get(i).getPrice());
                                        if(money.getBalance().compareTo(itemPriceBD) >= 0){
                                        if (invList.get(i).getInventory() == 0) {
                                            System.out.println("NO LONGER AVAILABLE");
                                        } else {

                                            //tracks every other purchase selection using a counter the updates at the end of the for loop
                                            if (counter % 2 != 0) {
                                                //alerts user they save 1 dollar
                                                System.out.println("BOGODO! - you save $1");
                                                //displays new big decimal price
                                                System.out.println("Discouted Price: $" + money.boGoDo(itemPriceBD));
                                                //decreases discounted price from the balance
                                                money.decreaseBalance(money.boGoDo(itemPriceBD));

                                            } else {
                                                money.decreaseBalance(itemPriceBD);
                                            }
                                            //invList.get(i).setInventory(invList.get(i).getInventory() - 1);
                                            invList.get(i).decreaseInventory();
                                            System.out.println("current item inventory " + invList.get(i).getInventory());
                                            //money.decreaseBalance(itemPriceBD);
                                            System.out.println();
                                            System.out.println(invList.get(i).toString());
                                            System.out.println(invList.get(i).getMessage());
                                            System.out.println();
                                            System.out.println("Remaining Balance: $" + money.getBalance());
                                            System.out.println();
                                            counter++;
                                        }
                                        } else {
                                            System.out.println("Insufficient Funds-Please add money to continue");
                                        }
                                        System.out.println("Press ENTER to continue");
                                        choice = UserInput.getSelectItemScreen();
                                        UserOutput.displayPurcahseScreen();
                                        choice = UserInput.getPurchaseScreen();

                                    } //else if (!choice.equals(invList.get(i).getIdName())) {
//                                        System.out.println("Option not found! Please choose another.");
//                                        System.out.println("Press ENTER to continue");
//                                        choice = UserInput.getSelectItemScreen();
//                                        UserOutput.displaySelectItem();
//                                        choice = UserInput.getSelectItemScreen();
//                                    }
                                }

                        }
                    }
                    if (choice.equals("Finish Transaction")) {
                        System.out.println("Change to Receive: $" + money.getBalance());
                        UserOutput.displayFinalTransaction();
                        int[] array = new int[4];
                        array = money.getChange();
                        System.out.println("Dollars: " + array[0]);
                        System.out.println("Quarters: " + array[1]);
                        System.out.println("Dimes: " + array[2]);
                        System.out.println("Nickels: " + array[3]);
//                        if(money.getBalance().remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
//                            money.getChange(money.getBalance());
//                        }  else {
//                            money.getChange(money.getBalance());
//                        }
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
