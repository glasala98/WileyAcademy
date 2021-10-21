package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VendingMachineDao {

    void removeItemFromInventory(String name) throws VendingMachinePersistenceException;
    List<Item> getAllItems() throws VendingMachinePersistenceException ;
    int getItemInventory(String name) throws VendingMachinePersistenceException;
    Item getItem(String name)throws VendingMachinePersistenceException;
    Map<String,BigDecimal> getMapOfItems()throws VendingMachinePersistenceException;

}





