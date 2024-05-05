package com.TRA.tra24Springboot;

import java.util.List;

public class Item implements ItemInnterface {
    public double itemId;
    public String itemName;
    public double unitPrice;
    public int quantity;

    public double getItemId() {
        return itemId;
    }

    public void setItemId(double itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }

    public static int itemsQuatity(List<Item> items) {
        int quantity = 0;
        for (Item i : items) {
            quantity += i.quantity;
        }
        return quantity;
    }
}
