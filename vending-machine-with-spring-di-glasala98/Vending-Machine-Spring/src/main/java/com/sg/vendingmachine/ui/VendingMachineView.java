package com.sg.vendingmachine.ui;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class VendingMachineView {
    
    private UserIO io;

    public VendingMachineView (UserIO io){
        this.io = io;
    }

    public BigDecimal depositMoney() {
        return io.readBigDecimal("Please enter the amount money deposited : ");
    }
    
    public void displayBanner() {
        io.print("*** Menu ***");
    }
    
    public void displayMenu(Map<String, BigDecimal> itemsInStockWithCosts){
        itemsInStockWithCosts.entrySet().forEach(entry ->{
        System.out.println(entry.getKey() + ": $" +entry.getValue());
        });
    }
    
    public String getItemSelection(){
        return io.readString("Select an item from the menu above or enter exit");
    }

    public void displayEnjoy(String name) {
        io.print("Here is your change.");
        io.print("Enjoy your " + name + "!");
    }
    
    public void displayInsufficientFundsMsg(BigDecimal money){
        io.print("Insufficient funds, you have only deposited $"+ money);
    }
    
    public void displayItemOutOfStockMsg(String name){
        io.print("Error, " + name + " is out of stock.");
    }   

    public void displayChangeDuePerCoin(Map<BigDecimal, BigDecimal> changeDuePerCoin) {
        changeDuePerCoin.entrySet().forEach(entry ->{
                 System.out.println(entry.getKey() + "c : " +entry.getValue());
         });
    }

    public void displayExit() {
        io.print("Bye!");
    }
    
    public void displayUnknownCommand() {
        io.print("Unknown Command!");
    }
    
    public void displayErrorMessage (String errorMsg) {
        io.print("*** Error ***");
        io.print(errorMsg);
    }
    
    public void displaySelectDifferentItem() {
        io.print("Please select a different item.");
    }
}
