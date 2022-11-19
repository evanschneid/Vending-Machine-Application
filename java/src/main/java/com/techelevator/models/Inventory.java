package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private List<Item> inventoryList = new ArrayList<>();

    public List<Item> getInventoryList() {
        File newInventory = new File("catering.csv");

        try (Scanner fileInput = new Scanner(newInventory);){

            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] arrayLine = line.split(",");
                if (arrayLine[3].equals("Gum")) {
                    Item itemDetails = new Gum(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], 6);
                    inventoryList.add(itemDetails);
                }
                if (arrayLine[3].equals("Candy")) {
                    Item itemDetails = new Candy(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], 6);
                    inventoryList.add(itemDetails);
                }
                if (arrayLine[3].equals("Munchy")) {
                    Item itemDetails = new Munchy(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], 6);
                    inventoryList.add(itemDetails);
                }
                if (arrayLine[3].equals("Drink")) {
                    Item itemDetails = new Drink(arrayLine[0], arrayLine[1], arrayLine[2], arrayLine[3], 6);
                    inventoryList.add(itemDetails);
                }
            }

        }catch (FileNotFoundException e){}

        return inventoryList;
    }

}
