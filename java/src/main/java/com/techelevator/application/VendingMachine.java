package com.techelevator.application;

import com.techelevator.models.Inventory;
import com.techelevator.models.Item;
import com.techelevator.models.Money;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachine
{
    private UserInput userInput = new UserInput();
    private UserOutput userOutput = new UserOutput();
    private Money money = new Money();
    private Inventory inventory = new Inventory();

    public void run() {

        List<Item> invList = inventory.getInventoryList();
        Map<String, String> invMap = inventory.inventoryListToMap();

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                UserOutput.displayInventoryOutput();
                UserOutput.displayMessage("Press ENTER to continue");
                UserInput.getDisplayInventoryOption();
            }
             else if (choice.equals("purchase")) {
                    // make a purchase
                    UserOutput.displayPurcahseScreen();
                    choice = UserInput.getPurchaseScreen();
                    while (!choice.equals("Finish Transaction")) {
                        if (choice.equals("Feed Money")) {
                            UserOutput.displayFeedMoney();
                            UserOutput.displayMessage("Current money provided: " + money.getBalance());
                            choice = UserInput.getFeedMoneyScreen();
                            BigDecimal inputNumber = money.stringToBigDecimal(choice);
                            money.addToBalance(inputNumber);
                            UserOutput.displayMessage("New balance: " + "$" + money.getBalance());
                            UserOutput.displayMessage("Press ENTER to continue");
                            choice = UserInput.getFeedMoneyScreen();
                            UserOutput.displayPurcahseScreen();
                            choice = UserInput.getPurchaseScreen();
                        }
                        if (choice.equals("Select Item")) {
                            UserOutput.displaySelectItem();
                            choice = UserInput.getSelectItemScreen();

                           // while (!choice.equals("Finish Transaction")) {


                                int counter = 0;
                            if (invMap.containsKey(choice)) {
                                for (Item item : invList) {
                                    if (choice.contains(item.getIdName())) {
                                        BigDecimal itemPriceBD = money.stringToBigDecimal(item.getPrice());
                                        if (money.getBalance().compareTo(itemPriceBD) >= 0) {
                                            if (item.getInventory() == 0) {
                                                UserOutput.displayMessage("NO LONGER AVAILABLE");
                                            } else {


                                                if (counter % 2 != 0) {
                                                    //alerts user they save 1 dollar
                                                    UserOutput.displayMessage("BOGODO! - you save $1");
                                                    //displays new big decimal price
                                                    UserOutput.displayMessage("Discouted Price: $" + money.boGoDo(itemPriceBD));
                                                    //decreases discounted price from the balance
                                                    money.decreaseBalance(money.boGoDo(itemPriceBD));

                                                } else {
                                                    money.decreaseBalance(itemPriceBD);
                                                }
                                                item.decreaseInventory();
                                                UserOutput.displayMessage("current item inventory " + item.getInventory());
                                                UserOutput.displayMessage(item.toString());
                                                UserOutput.displayMessage(item.getMessage());
                                                UserOutput.displayMessage("Remaining Balance: $" + money.getBalance());
                                                counter++;
                                            }
                                        } else {
                                            UserOutput.displayMessage("Insufficient Funds-Please add money to continue");
                                        }
                                        UserOutput.displayMessage("Press ENTER to continue");
                                        choice = UserInput.getSelectItemScreen();
                                        UserOutput.displayPurcahseScreen();
                                        choice = UserInput.getPurchaseScreen();

                                    }
                                }
                            } else {
                                UserOutput.displayMessage("Option not found! Please choose another.");
                                UserOutput.displayMessage("Press ENTER to continue");
                                choice = UserInput.getSelectItemScreen();
                                UserOutput.displaySelectItem();
                                choice = UserInput.getSelectItemScreen();
                            }
                        }
                    }
                    if (choice.equals("Finish Transaction")) {
                        UserOutput.displayMessage("Change to Receive: $" + money.getBalance());
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
                        break;
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
