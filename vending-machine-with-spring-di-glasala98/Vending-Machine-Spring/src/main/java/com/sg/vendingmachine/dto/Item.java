package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private String name;
    private BigDecimal cost;
    private int inventory;

    public Item(String name, String cost, int inventory) {
        this.name = name;
        this.cost = new BigDecimal(cost);
        this.inventory = inventory;
    }
    
    public Item(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    public int getInventory() {
        return inventory;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public int hashCode() {
        int hashValue = 9;
        hashValue = 97 * hashValue + Objects.hashCode(this.name);
        hashValue = 97 * hashValue + Objects.hashCode(this.cost);
        hashValue = 97 * hashValue + this.inventory;
        return hashValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.inventory != other.inventory) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", cost=" + cost + ", inventory=" + inventory + '}';
    }
    
    
    
    
    
    
}
