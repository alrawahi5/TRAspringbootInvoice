package com.TRA.tra24Springboot;

import java.util.Date;
import java.util.List;

public class Invoice implements InvoiceInterface {
    public int invoiceNo;
    public String customerFullName;
    public String phoneNumber;
    public Date invoiceDate;
    public List<Item> items;
    public double totalAmount;
    public double paidAmount;
    public double balance;

    Item itemObject = new Item();

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Invoice() {
        //this.invoiceDate = new Date();
        Date invoDate = new Date();
        invoiceDate = invoDate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        Date invoDate = new Date();
        invoiceDate = invoDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {

        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNo=" + invoiceNo +
                ", customerFullName='" + customerFullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                ", balance=" + balance +
                '}';
    }

    static double calculateTotalAmount(List<Item> items) {
        double total = 0d;
        for (Item i : items) {
            total += (i.unitPrice * i.quantity);
        }

        return total;
    }
}
