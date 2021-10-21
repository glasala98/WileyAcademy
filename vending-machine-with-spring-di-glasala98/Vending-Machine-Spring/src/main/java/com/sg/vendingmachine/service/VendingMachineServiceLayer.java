package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;


public interface VendingMachineServiceLayer {
    @Autowired
    void checkIfEnoughMoney(Item item, BigDecimal inputMoney) throws InsufficientFundsException;
    void removeOneItemFromInventory(String name) throws NoItemInventoryException, VendingMachinePersistenceException;
    Map<String, BigDecimal>  getItemsInStockWithCosts () throws VendingMachinePersistenceException;
    Item getItem(String name, BigDecimal inputMoney) throws InsufficientFundsException,NoItemInventoryException,VendingMachinePersistenceException;
    Map<BigDecimal, BigDecimal> getChangePerCoin(Item item, BigDecimal money);
}
