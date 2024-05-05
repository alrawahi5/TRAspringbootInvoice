package com.TRA.tra24Springboot;

import java.util.Date;
import java.util.List;

public interface InvoiceInterface {

    int getInvoiceNo();

    void setInvoiceNo(int invoiceNo);

    String getCustomerFullName();

    void setCustomerFullName(String customerFullName);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    Date getInvoiceDate();

    default void setInvoiceDate(Date invoiceDate) {
        Date invoDate = new Date();
        invoiceDate = invoDate;
    }

    List<Item> getItems();

    void setItems(List<Item> items);

    double getTotalAmount();

    void setTotalAmount(double totalAmount);

    double getPaidAmount();

    void setPaidAmount(double paidAmount);

    double getBalance();

    void setBalance(double balance);

    @Override
    String toString();

    static double calculateTotalAmount(List<Item> items) {
        double total = 0d;
        for (Item i : items) {
            total += (i.unitPrice * i.quantity);
        }

        return total;
    }
}
