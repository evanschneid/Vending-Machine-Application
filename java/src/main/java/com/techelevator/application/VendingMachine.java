package com.techelevator.application;

import com.techelevator.models.Inventory;
import com.techelevator.models.Item;
import com.techelevator.models.Money;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

public class VendingMachine
{
    private UserInput userInput = new UserInput();
    private UserOutput userOutput = new UserOutput();
    private Money money = new Money();
    private Inventory inventory = new Inventory();
    private List<Item> invList = inventory.getInventoryList();

    public void run() {

      //  List<Item> invList = inventory.getInventoryList();
        Map<String, String> invMap = inventory.inventoryListToMap();
        int counter = 0;

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
                            UserOutput.displayMessage("\nCurrent money provided: " + money.getBalance());
                            choice = UserInput.getFeedMoneyScreen();
                            BigDecimal inputNumber = money.stringToBigDecimal(choice);
                            money.addToBalance(inputNumber);
                            fileAuditFeedMoney(inputNumber);
                            UserOutput.displayMessage("New balance: " + "$" + money.getBalance());
                            UserOutput.displayEmptyLine();
                            UserOutput.displayMessage("Press ENTER to continue");
                            UserInput.getFeedMoneyScreen();
                            UserOutput.displayPurcahseScreen();
                            choice = UserInput.getPurchaseScreen();
                        }
                         if (choice.equals("Select Item")) {
                            UserOutput.displaySelectItem();
                            choice = UserInput.getSelectItemScreen();
                            if (invMap.containsKey(choice)) {
                                for (Item item : invList) {
                                    if (choice.contains(item.getIdName())) {
                                        BigDecimal itemPriceBD = money.stringToBigDecimal(item.getPrice());
                                        fileAuditSelectItem(item.getName(), item.getIdName(), itemPriceBD);
                                        if (money.getBalance().compareTo(itemPriceBD) >= 0) {
                                            if (item.getInventory() == 0) {
                                                UserOutput.displayMessage("NO LONGER AVAILABLE");
                                            } else {
                                                if (counter % 2 != 0) {
                                                    money.decreaseBalance(money.boGoDo(itemPriceBD));
                                                    item.decreaseInventory();
                                                    UserOutput.displayEmptyLine();
                                                    UserOutput.displayMessage(item.toString());
                                                    UserOutput.displayMessage(item.getMessage());
                                                    UserOutput.displayMessage("Current Item Inventory " + item.getInventory());
                                                    UserOutput.displayEmptyLine();
                                                    UserOutput.displayMessage("BOGODO! - you save $1");
                                                    UserOutput.displayMessage("Discounted Price: $" + money.boGoDo(itemPriceBD));
                                                    UserOutput.displayEmptyLine();
                                                    UserOutput.displayMessage("Remaining Balance: $" + money.getBalance());
                                                    item.increaseBOGODOSalesAmount();
                                                    money.addToTotalSales(money.boGoDo(itemPriceBD));
                                                    counter++;
                                                } else {
                                                    money.decreaseBalance(itemPriceBD);
                                                    item.decreaseInventory();
                                                    UserOutput.displayEmptyLine();
                                                    UserOutput.displayMessage(item.toString());
                                                    UserOutput.displayMessage(item.getMessage());
                                                    UserOutput.displayMessage("Current Item Inventory " + item.getInventory());
                                                    UserOutput.displayEmptyLine();
                                                    UserOutput.displayMessage("Remaining Balance: $" + money.getBalance());
                                                    item.increaseSalesAmount();
                                                    money.addToTotalSales(itemPriceBD);
                                                    counter++;
                                                }
                                            }
                                        } else {
                                            UserOutput.displayMessage("Insufficient Funds-Please add money to continue");
                                        }
                                        UserOutput.displayEmptyLine();
                                        UserOutput.displayMessage("Press ENTER to continue");
                                        UserInput.getSelectItemScreen();
                                        UserOutput.displayPurcahseScreen();
                                        choice = UserInput.getPurchaseScreen();
                                    }
                                }
                            }
                        }
                        else {
                            UserOutput.displayMessage("Please make a valid section");
                            UserOutput.displayPurcahseScreen();
                            UserInput.getPurchaseScreen();
                        }
                    }
                    if (choice.equals("Finish Transaction")) {
                        UserOutput.displayEmptyLine();
                        UserOutput.displayMessage("Change to Receive: $" + money.getBalance());
                        UserOutput.displayFinalTransaction();
                        int[] array = new int[4];
                        array = money.getChange();
                        // How could we move this print statement to UserOutput while still having access to current balance?
                        // the static methods over there were causing an issue for us
                        if (array[0] > 0) {
                            System.out.println("Number of Dollars: " + array[0]);
                        }
                        if (array[1] > 0) {
                            System.out.println("Number of Quarters: " + array[1]);
                        }
                        if (array[2] > 0) {
                            System.out.println("Number of Dimes: " + array[2]);
                        }
                        if (array[3] > 0) {
                            System.out.println("Number of Nickels: " + array[3]);
                        }
                        fileAuditFinishTransaction();
                        salesReport();
                        money.balanceAfterChangeMade();
                        System.out.println("Current Balance: $" + money.getBalance());
                        UserOutput.displayEmptyLine();
                        UserOutput.displayMessage("Thanks for shopping with us!");
                        UserOutput.displayHomeScreen();
                    }
                }
            else if(choice.equals("exit")) {
                // good bye
                UserOutput.displayEmptyLine();
                UserOutput.displayMessage("Thanks for shopping with us!");
                break;
            }
            else if (choice.equals("sales report")) {
                UserOutput.displaySalesReport();
                UserOutput.displayEmptyLine();
                UserOutput.displayMessage("Press ENTER to continue");
                UserInput.getHomeScreenOption();
            }
        }
    }

    // the Audit should be keeping track of all
    public void fileAuditFeedMoney(BigDecimal amountToAdd) {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM/dd/YYYY");

        File auditFile = new File("Audit.txt");
        try (PrintWriter appendWriter = new PrintWriter(new FileWriter(auditFile, true))) {
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();
            LocalTime chronoCurrentTime = currentTime.truncatedTo(ChronoUnit.SECONDS);
            LocalTime noon = LocalTime.of(12,00, 00);
            String meridiem = "";
            if (currentTime.isBefore(noon)) {
                meridiem = "AM";
            }
            else {
                meridiem = "PM";
            }
            appendWriter.println(formatDate.format(currentDate) + " " + chronoCurrentTime + " " +
                    meridiem + " " + "Money Fed:" + " $" + amountToAdd + " $" + money.getBalance());
        } catch (FileNotFoundException e){
            UserOutput.displayMessage(auditFile.getName() + " had an error.");
        } catch (IOException e) {
            UserOutput.displayMessage(auditFile.getName() + " had an read/write error.");
        }
    }

    public void fileAuditSelectItem(String name, String idName, BigDecimal price) {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM/dd/YYYY");

        File auditFile = new File("Audit.txt");
        try (PrintWriter appendWriter = new PrintWriter(new FileWriter(auditFile, true))) {
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();
            LocalTime chronoCurrentTime = currentTime.truncatedTo(ChronoUnit.SECONDS);
            LocalTime noon = LocalTime.of(12,00, 00);
            String meridiem = "";
            if (currentTime.isBefore(noon)) {
                meridiem = "AM";
            }
            else {
                meridiem = "PM";
            }
            BigDecimal currentBalance = money.getBalance().subtract(price);
            appendWriter.println(formatDate.format(currentDate) + " " + chronoCurrentTime + " " + meridiem + " " +
                    name + " " + idName + " $" + money.getBalance() + " $" + currentBalance);
        } catch (FileNotFoundException e){
            UserOutput.displayMessage(auditFile.getName() + " had an error.");
        } catch (IOException e) {
            UserOutput.displayMessage(auditFile.getName() + " had an read/write error.");
        }
    }

    public void fileAuditFinishTransaction() {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM/dd/YYYY");

        File auditFile = new File("Audit.txt");
        try (PrintWriter appendWriter = new PrintWriter(new FileWriter(auditFile, true))) {
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();
            LocalTime chronoCurrentTime = currentTime.truncatedTo(ChronoUnit.SECONDS);
            LocalTime noon = LocalTime.of(12,00, 00);
            String meridiem = "";
            if (currentTime.isBefore(noon)) {
                meridiem = "AM";
            }
            else {
                meridiem = "PM";
            }
            appendWriter.println(formatDate.format(currentDate) + " " + chronoCurrentTime + " " +
                    meridiem + " " + "CHANGE GIVEN:" + " $" + money.getBalance() + " $0.00");
            appendWriter.println("****************************************************");
        } catch (FileNotFoundException e){
            UserOutput.displayMessage(auditFile.getName() + " had an error.");
        } catch (IOException e) {
            UserOutput.displayMessage(auditFile.getName() + " had an read/write error.");
        }
    }

    public void salesReport() {

        File salesReportFile = new File("SalesReport.txt");
        try (PrintWriter salesReportWriter = new PrintWriter(salesReportFile)) {
            salesReportWriter.println("Taste Elevator Sales Report");
            for (Item item : invList) {
                salesReportWriter.println(item.getName() + "|" + item.getStartingSaleAmount() + "|" + item.getStartingBOGODOSaleAmount());
            }
            salesReportWriter.println("TOTAL SALES " + money.getTotalSales());
        } catch (FileNotFoundException e) {
            UserOutput.displayMessage(salesReportFile.getName() + " had an error.");
        }
    }

}
