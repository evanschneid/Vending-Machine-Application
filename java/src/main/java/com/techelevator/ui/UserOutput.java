package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.Inventory;
import com.techelevator.models.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println(message);
    }
    public static void displayEmptyLine()
    {
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
        System.out.println();
        Inventory itemList = new Inventory();
        for (Item invItemList: itemList.getInventoryList()){
            System.out.println(invItemList.toString());
        }
        System.out.println();
    }


    public static void displayPurcahseScreen() {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void displayFeedMoney() {
        System.out.println();
        System.out.println("Please input whole dollar whole-amounts only.");
        System.out.println("Whole dollar amounts: $1=(1), $5=(5), $10=(10), or $20=(20)");
        System.out.println();
        System.out.println("P) Select to go back to Purchase menu.");
        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void displaySelectItem() {
        System.out.println();
        Inventory itemList = new Inventory();
        for (Item invItemList: itemList.getInventoryList()){
            System.out.println(invItemList.toString());
        }
        System.out.println();
        System.out.println("Please select an item to order by item code.");
        System.out.println("Letter followed by number. Example:(A4 or C2)");
        System.out.println();
        System.out.println("F) if finished selecting");
        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void displayFinalTransaction() {
        System.out.println();
        System.out.println("********Dispensing Change*********");

//        int[] array = new int[4];
//        array = money.getChange();
//        System.out.println("Dollars: " + array[0]);
//        System.out.println("Quarters: " + array[1]);
//        System.out.println("Dimes: " + array[2]);
//        System.out.println("Nickels: " + array[3]);

    }

    public static void displaySalesReport() {
        File salesReport = new File("SalesReport.txt");
        try (Scanner reportReader = new Scanner(salesReport)) {
            System.out.println();
            while (reportReader.hasNextLine()) {
                String line = reportReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            System.out.println(salesReport.getName() + " had an error.");
        }
    }

}
