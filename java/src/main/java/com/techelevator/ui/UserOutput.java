package com.techelevator.ui;

import com.techelevator.models.Inventory;
import com.techelevator.models.Item;
import com.techelevator.models.Money;

import java.math.BigDecimal;
import java.util.Scanner;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{
    private static Scanner scanner = new Scanner(System.in);
    private Money money = new Money();

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();

        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void displayInventoryOutput() {
        Inventory itemList = new Inventory();
        for (Item invItemList: itemList.getInventoryList()){
            System.out.println(invItemList.toString());
        }
    }


    public static void displayPurcahseScreen() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();

        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void displayFeedMoney() {
        System.out.println();
        System.out.println("Please input whole dollar whole-amounts only.");
        System.out.println("Whole dollar amounts: $1=(1), $5=(5), $10=(10), or $20=(20)");
        System.out.println("E) Select to go back to Purchase menu.");
        System.out.println();
    }

    public static String displayCurrentBalance(int number) {
        return "Current Balance: $" + number;
    }

    public static void displaySelectItem() {
        Inventory itemList = new Inventory();
        for (Item invItemList: itemList.getInventoryList()){
            System.out.println(invItemList.toString());
        }
        System.out.println();
        System.out.println("Please select an item to order by item code (B4 or A3).");
        System.out.println();
    }

}
