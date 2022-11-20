package com.techelevator.ui;

import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();
        if (option.equals("D")) {
            return "display";
        } else if (option.equals("P")) {
            return "purchase";
        } else if (option.equals("S")) {
            return "sales report";
        } else if (option.equals("E")) {
            return "exit";
        } else {
            UserOutput.displayHomeScreen();
            UserOutput.displayMessage("\n\n" + option + " is not valid. Please make another selection.");
            return getHomeScreenOption();
        }
    }

    public static String getDisplayInventoryOption() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();
        return option;
    }

    public static String getPurchaseScreen() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("M")) {
            return "Feed Money";
        } else if (option.equals("S")) {
            return "Select Item";
        } else if (option.equals("F")) {
            return "Finish Transaction";
        } else {
            UserOutput.displayPurcahseScreen();
            UserOutput.displayMessage("\n \n" + option + " is not valid. Please make another selection.");
            return getPurchaseScreen();
        }
    }

    public static String getFeedMoneyScreen() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();
        try {
            if (option.equals("1")) {
                return "1";
            } else if (option.equals("5")) {
                return "5";
            } else if (option.equals("10")) {
                return "10";
            } else if (option.equals("20")) {
                return "20";
            } else if(option.equals("P")){
                UserOutput.displayPurcahseScreen();
                return "0";
            }
            else {
                UserOutput.displayMessage("\n \n" + option + " is not valid. Please make another selection.");
                return "0";
            }
        } catch (NumberFormatException e) {
            UserOutput.displayPurcahseScreen();
            return "0";
        }
    }

    public static String getSelectItemScreen() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();
        try {
            if (option.equals("F")) {
                return "Finish Transaction";
            }
        } catch (NullPointerException e) {
            UserOutput.displayMessage("Please make another selection.");
            UserOutput.displaySelectItem();
        }
        return option;
    }

}
