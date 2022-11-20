package com.techelevator.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    Item item = new Gum("A4", "Teaberry", "2.95", "Gum", 6);
    Item item2 = new Drink("B3", "7Down", "3.25", "Drink", 6);
    Item item3 = new Candy("C3", "Moonpie", "2.95", "Candy", 6);
    Item item4 = new Munchy("D3", "Popcorn", "1.75", "Munchy", 6);


    @Before
    public void setup () {
        Item item4 = new Munchy("D3", "Popcorn", "1.75", "Munchy", 6);
        item.setStartingSaleAmount(0);
        item.setStartingBOGODOSaleAmount(0);
    }
     @Test
    public void decreaseInventory_returns_5_when_inventory_is_6(){
        item4.decreaseInventory();
        int expected = 5;
        int result = item4.getInventory();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void test_increaseSalesAmount_by_1() {
        int expected = 1;
        item.increaseSalesAmount();
        int result = item.getStartingSaleAmount();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void test_increaseBOGODOSalesAmount_by_1() {
        int expected = 1;
        item.increaseBOGODOSalesAmount();
        int result = item.getStartingBOGODOSaleAmount();
        Assert.assertEquals(expected, result);
    }

}