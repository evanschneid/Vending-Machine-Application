package com.techelevator.ui;

import com.techelevator.models.Inventory;
import com.techelevator.models.Item;
import com.techelevator.models.Money;
import com.techelevator.models.Munchy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public String getUserInput(){
        String selectedOption = scanner.nextLine();
        return selectedOption;
    }

    public static String getHomeScreenOption() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D")) {
            return "display";
        }
        else if (option.equals("P")) {
            return "purchase";
        }
        else if (option.equals("E")) {
            return "exit";
        }
        else {
            return "";
        }

    }

    public static String getPurchaseScreen() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("M")) {
            return "Feed Money";
        }
        else if (option.equals("S")) {
            return "Select Item";
        }
        else if (option.equals("F")) {
            return "Finish Transaction";
        }
        return "";
    }

    public static String getFeedMoneyScreen() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("1")) {
            return "1";
        }
        else if (option.equals("5")) {
            return "5";
        }
        else if (option.equals("10")) {
            return "10";
        }
        else if (option.equals("20")) {
            return "20";
        }
        else if (option.equals("E")) {
            return "Exit";
        }
        return "";

    }

    public static String getSelectItemScreen() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        return option;
    }

//             BigDecimal currentNum = BigDecimal.valueOf(0);
//            Money test = new Money();
//
//            UserOutput.getFeedMoney();
//            selectedOption = scanner.nextLine();
//            option = selectedOption.trim().toUpperCase();
//            test.getCurrentBalance(option);
//
//
//            System.out.println("Current Money Provided: " + currentNum);
//
//        }
//        else if (option.equals("S")) {
//            selectedOption = scanner.nextLine();
//            option = selectedOption.trim().toUpperCase();
//        }
//        else if (option.equals("F")) {
//            selectedOption = scanner.nextLine();
//            option = selectedOption.trim().toUpperCase();
}
