package com.TRA.tra24Springboot;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvoicingSystem {
    private static ShopSettings shopSettings;
    public static List<Item> items = new ArrayList<>();
    private static List<Invoice> invoices = new ArrayList<>();
    static Invoice invoice1 = new Invoice();

    public static ShopSettings getShopSettings() {
        return shopSettings;
    }

    public static void setShopSettings(ShopSettings shopSettings) {
        InvoicingSystem.shopSettings = shopSettings;
    }

    public static List<Item> getItems() {
        return items;
    }

    public static void setItems(List<Item> items) {
        InvoicingSystem.items = items;
    }

    public static List<Invoice> getInvoices() {
        return invoices;
    }

    public static void setInvoices(List<Invoice> invoices) {
        InvoicingSystem.invoices = invoices;
    }

    public static Invoice getInvoice1() {
        return invoice1;
    }

    public static void setInvoice1(Invoice invoice1) {
        InvoicingSystem.invoice1 = invoice1;
    }

    @Override
    public String toString() {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).toString();
        }
        return items.toString();
    }

    public static boolean isValidString(String inputV) {
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputV);
        return matcher.matches();
    }

    public static boolean isValidPhoneN(String inputV) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputV);
        return matcher.matches();
    }

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String name = null;

        Menue.invoice1.customerFullName = name;
        invoice1.setCustomerFullName(name);
        while (name == null) {
            try {
                System.out.println("Enter your full name: ");
                name = scanner.nextLine();

                if (!isValidString(name)) {
                    throw new IllegalArgumentException("Invalid input. ");
                }

            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
                name = null;
            }
        }

        //System.out.println("Enter your phone number: ");
        String phoneNumber = null;
        Menue.invoice1.phoneNumber = phoneNumber;
        invoice1.setPhoneNumber(phoneNumber);

        while (phoneNumber == null) {
            try {
                System.out.println("Enter your phone number: ");
                phoneNumber = scanner.nextLine();

                if (!isValidPhoneN(phoneNumber)) {
                    throw new IllegalArgumentException("Invalid input. ");
                }
            } catch (Exception e) {
                System.out.print(e.getMessage());
                phoneNumber = null;
            }
        }

        Menue.addItems(scanner);
        Menue.showMainMenu();*/
    }
}
