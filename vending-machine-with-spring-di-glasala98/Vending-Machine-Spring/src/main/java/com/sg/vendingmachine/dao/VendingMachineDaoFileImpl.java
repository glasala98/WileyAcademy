package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class VendingMachineDaoFileImpl implements VendingMachineDao {
    private Map <String, Item> items = new HashMap<>();
    public static final String DELIMITER = "::";
    private final String VENDING_MACHINE_FILE;
    public VendingMachineDaoFileImpl() {
        VENDING_MACHINE_FILE = "VendingMachine.txt";
    }
    public VendingMachineDaoFileImpl(String testFile) {
        VENDING_MACHINE_FILE = testFile;
    }

    @Override
    public int getItemInventory(String item) throws VendingMachinePersistenceException {
        loadVendingMachine();
        return items.get(item).getInventory();
    }

    @Override
    public void removeItemFromInventory(String item) throws VendingMachinePersistenceException {
        loadVendingMachine();
        int prevInventory = items.get(item).getInventory();
        items.get(item).setInventory(prevInventory-1);
        writeVendingMachine();
    }

    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException {
        loadVendingMachine();
        return items.get(name);
    }

    @Override
    public Map<String,BigDecimal> getMapOfItems() throws VendingMachinePersistenceException{
        loadVendingMachine();
        Map<String, BigDecimal> itemsInStockWithCosts = items.entrySet().stream().filter(map -> map.getValue().getInventory() > 0).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue().getCost()));
        return itemsInStockWithCosts;
    }

    private String dataMarshall(Item data) {
        String itemAsText = data.getName() + DELIMITER;
        itemAsText += data.getCost() + DELIMITER;
        itemAsText += data.getInventory();
        return itemAsText;
    }

    private Item dataUnmarshall(String data){
        String [] itemTokens = data.split("::");
        String name = itemTokens[0];
        Item itemFromFile = new Item(name);
        BigDecimal bigDecimal = new BigDecimal(itemTokens[1]);
        itemFromFile.setCost(bigDecimal);
        itemFromFile.setInventory(Integer.parseInt(itemTokens[2]));
        return itemFromFile;
    }
    
    
    private void loadVendingMachine() throws VendingMachinePersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(VENDING_MACHINE_FILE)));
        }
        catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "Data could not be loaded to memory.", e);
        }
        String currentLine;
        Item currentItem;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = dataUnmarshall(currentLine);
            items.put(currentItem.getName(), currentItem);
        }
        scanner.close();
        }
    
    
    @Override
    public  List<Item> getAllItems() throws VendingMachinePersistenceException {
        loadVendingMachine();
        return new ArrayList(items.values());
    }

    private void writeVendingMachine() throws VendingMachinePersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(VENDING_MACHINE_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Student data could not be saved.", e);
        }
        String itemFormatted;
        List <Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            itemFormatted = dataMarshall(currentItem);
            out.println(itemFormatted);
            out.flush();
        }
        out.close();
        }
    }
    
    
    
