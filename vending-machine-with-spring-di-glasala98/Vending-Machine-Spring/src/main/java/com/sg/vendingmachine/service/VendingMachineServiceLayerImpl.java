package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Item;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{

    private VendingMachineAuditDao auditDao;
    private VendingMachineDao dao;

    public VendingMachineServiceLayerImpl(VendingMachineAuditDao auditDao, VendingMachineDao dao) {
        this.auditDao = auditDao;
        this.dao = dao;
    }

    @Override
    public void checkIfEnoughMoney(Item item, BigDecimal inputMoney) throws InsufficientFundsException {
        if (item.getCost().compareTo(inputMoney)==1) {
            throw new InsufficientFundsException (
            "ERROR: insufficient funds. Available funds:  "+ inputMoney);
        }
    }
    
    @Override
    public Map<String, BigDecimal>  getItemsInStockWithCosts () throws VendingMachinePersistenceException {
         Map<String, BigDecimal> itemsInStockWithCosts = dao.getMapOfItems();
         return itemsInStockWithCosts;
    }
    
    @Override
    public Map<BigDecimal, BigDecimal> getChangePerCoin(Item item, BigDecimal money) {
        BigDecimal itemCost = item.getCost();
        Map<BigDecimal, BigDecimal> changeDuePerCoin = Change.changeDue(itemCost, money);
        return changeDuePerCoin;
    }
    
    @Override
    public Item getItem(String name, BigDecimal inputMoney) throws InsufficientFundsException, NoItemInventoryException, VendingMachinePersistenceException {
        Item wantedItem = dao.getItem(name);   //the inputs are case sensitive.
        if (wantedItem == null) {
            throw new NoItemInventoryException (
                "ERROR: there are no " + name + "'s in the vending machine.");
        }

        checkIfEnoughMoney(wantedItem,inputMoney);
        removeOneItemFromInventory(name);
        return wantedItem;
    }
    
    
    public void removeOneItemFromInventory (String name) throws NoItemInventoryException, VendingMachinePersistenceException {
        if (dao.getItemInventory(name)>0) {
            dao.removeItemFromInventory(name);
            auditDao.writeAuditEntry(" One " + name + " removed");
        }
        else
        {
            throw new NoItemInventoryException (
            "ERROR: " + name + " is out of stock.");
        }
    }

}
    
    
