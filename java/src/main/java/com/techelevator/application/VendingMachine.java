package com.techelevator.application;

import com.techelevator.models.Inventory;
import com.techelevator.models.Item;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import javax.crypto.spec.IvParameterSpec;
import java.util.List;

public class VendingMachine 
{
    public void run()
    {
        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                Inventory name = new Inventory();
                for (Item tester: name.getInventoryList()){
                    System.out.println(tester.toString());
                }

            }
            else if(choice.equals("purchase"))
            {
                // make a purchase

            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    
}
