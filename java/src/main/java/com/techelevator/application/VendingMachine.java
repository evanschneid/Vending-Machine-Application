package com.techelevator.application;

import com.techelevator.models.Inventory;
import com.techelevator.models.Item;
import com.techelevator.models.Money;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import javax.crypto.spec.IvParameterSpec;
import java.math.BigDecimal;
import java.util.List;

public class VendingMachine
{
    private UserInput userInput = new UserInput();
    private UserOutput userOutput = new UserOutput();
    private Money money = new Money();

    public void run() {
//        String userAnswer = userInput.getUserInput();

        String startingBalance = "0";

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                UserOutput.displayInventoryOutput();
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
                UserOutput.displayPurcahseScreen();
                choice = UserInput.getPurchaseScreen();

                if (choice.equals("Feed Money")) {
                    UserOutput.displayFeedMoney();
                    choice = UserInput.getFeedMoneyScreen();
                    while (choice.equals("1") || choice.equals("5") ||choice.equals("10") ||choice.equals("20")){
                        UserOutput.displayFeedMoney();

                        if  (startingBalance.equals(0)){
                            System.out.println(UserOutput.displayCurrentBalance(0));
                            int currentBalance = money.getCurrentBalance(startingBalance, choice);
                            String curBal = String.valueOf(currentBalance);
                            startingBalance = curBal;
                        }
                        else if (!startingBalance.equals(0)){
                            int currentBalance = money.getCurrentBalance(startingBalance, choice);
                            System.out.println(UserOutput.displayCurrentBalance(currentBalance));
                            String curBal = String.valueOf(currentBalance);
                            startingBalance = curBal;
                        }
                        choice = UserInput.getFeedMoneyScreen();


/*                        BigDecimal currentBalance = money.getCurrentBalance(startingBalance, choice);
                        BigDecimal startBalBD = BigDecimal.valueOf();
                        System.out.println(UserOutput.displayCurrentBalance(currentBalance));
                        startingBalance = currentBalance;*/

                    }
                }
                if (choice.equals("Select Item")){
                    UserOutput.displaySelectItem();
                    choice = UserInput.getSelectItemScreen();

                    Inventory inventory = new Inventory();
                    List<Item> invList = inventory.getInventoryList();

                    for (int i = 0; i < invList.size(); i++) {
                        if (choice.equals(invList.get(i).getIdName())){

                            System.out.println(invList.get(i).toString());
                            System.out.println(invList.get(i).getMessage());
                            System.out.println(money.getNewBalance(startingBalance, invList.get(i).getPrice()));
                        }
                    }
                }
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    
}