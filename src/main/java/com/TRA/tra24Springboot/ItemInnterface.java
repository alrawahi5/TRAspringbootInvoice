package com.TRA.tra24Springboot;

import java.util.List;

public interface ItemInnterface {

    double getItemId();

    void setItemId(double itemId);

    String getItemName();

    void setItemName(String itemName);

    double getUnitPrice();

    void setUnitPrice(double unitPrice);

    int getQuantity();

    void setQuantity(int quantity);

    @Override
    String toString();

    static int itemsQuatity(List<Item> items) {
        int quantity = 0;
        for (Item i : items) {
            quantity += i.quantity;
        }
        return quantity;
    }
}
