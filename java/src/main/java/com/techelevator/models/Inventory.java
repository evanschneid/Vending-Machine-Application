package com.techelevator.models;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    private List<Item> inventoryList = new ArrayList<>();
    private Map<String, String> inventoryMap = new HashMap<>();

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

        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
        return inventoryList;
    }

    // What is the best way to test this?
    // we attempted to create a test that would compare a map we populated with the expected answers but the actual was always empty
    // we assumed it was an issue with the inventory list using the file from the method above
    public Map<String, String> inventoryListToMap() {
        for (Item itemMap: inventoryList) {
            inventoryMap.put(itemMap.getIdName(), itemMap.getName());
        }
        return inventoryMap;
    }

}
