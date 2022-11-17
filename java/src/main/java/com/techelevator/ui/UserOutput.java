package com.techelevator.ui;

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
    }

    public static void getFeedMoney() {
        System.out.println("Please input whole dollar whole-amounts only.");
        System.out.println("Whole dollar amounts: $1=(1), $5, $10, or $20");
    }

    public static void displayPurcahseScreen() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: ");

        System.out.println();
        System.out.print("Please select an option: ");
    }

}
