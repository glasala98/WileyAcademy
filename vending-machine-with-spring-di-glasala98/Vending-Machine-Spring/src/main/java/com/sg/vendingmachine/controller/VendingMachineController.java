
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.NoItemInventoryException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class VendingMachineController {
    private UserIO io = new UserIOConsoleImpl();
    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    @Autowired
    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean keepGoing = true;
        String itemSelection = "";
        BigDecimal inputMoney;
        view.displayBanner();
        try {
            getMenu();
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
        inputMoney = getMoney();
            while (keepGoing) {
            try {
                itemSelection = getItemSelection();
                if (itemSelection.equalsIgnoreCase("Exit")) {
                    keepGoing = false;
                    break;
                }
                getItem(itemSelection, inputMoney);
                keepGoing = false;
                break;
            } catch (InsufficientFundsException | NoItemInventoryException | VendingMachinePersistenceException e) {
                view.displayErrorMessage(e.getMessage());
                view.displaySelectDifferentItem();
            }
            }
            exitMessage();

    }
    private void getMenu() throws VendingMachinePersistenceException {
        Map<String, BigDecimal> itemsInStockWithCosts = service.getItemsInStockWithCosts();
        view.displayMenu(itemsInStockWithCosts);
    }    
    
    private BigDecimal getMoney() {
        return view.depositMoney();
    }
    
    private String getItemSelection(){
        return view.getItemSelection();
    }
    
    private void exitMessage() {
        view.displayExit();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommand();
    }
    
    private void getItem(String name, BigDecimal money) throws InsufficientFundsException, NoItemInventoryException, VendingMachinePersistenceException {
        Item wantedItem = service.getItem(name, money);
        Map<BigDecimal, BigDecimal> changeDuePerCoin = service.getChangePerCoin(wantedItem, money);
        view.displayChangeDuePerCoin(changeDuePerCoin);
        view.displayEnjoy(name);
    }
}
    
    

