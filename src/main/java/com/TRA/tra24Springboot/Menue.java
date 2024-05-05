package MyInvoice;

import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menue {
    //ShopSettings shopSettings1 = new ShopSettings();
    static int count1 = 1;
    public static HashMap<Integer, Integer> optionCounts;

    static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(MenuForOptions.mainMenu);

            try {
                System.out.print("Enter your choice: ");
                int choice = 0;
                choice = scanner.nextInt();
                scanner.nextLine();

                countOption(choice);

                switch (choice) {
                    case 1:
                        shopSettingsMenu(scanner);
                        break;
                    case 2:
                        manageShopItemsMenu(scanner);
                        break;
                    case 3:
                        createNewInvoice(scanner);
                        break;
                    case 4:
                        reportStatistics();
                        break;
                    case 5:
                        reportAllInvoices();
                        break;
                    case 6:
                        searchInvoices(scanner);
                        break;
                    case 7:
                        programStatistics();
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter your choice number: ");
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void shopSettingsMenu(Scanner scanner) {
        while (true) {
            System.out.println(MenuForOptions.shopSettingMenu);

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                countOption(choice);

                switch (choice) {
                    case 1:
                        loadData(scanner); //
                        break;
                    case 2:
                        setShopName(scanner);
                        break;
                    case 3:
                        setInvoiceHeader(scanner);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter your choice number: ");
                scanner.nextLine();
            }
        }
    }

    static void manageShopItemsMenu(Scanner scanner) {
        while (true) {
            System.out.println(MenuForOptions.manageShopItemsMenu);

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            countOption(choice);

            switch (choice) {
                case 1:
                    addItems(scanner);
                    break;
                case 2:
                    deleteItems(scanner);
                    break;
                case 3:
                    changeItemPrice(scanner);
                    break;
                case 4:
                    reportAllItems();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void countOption(int option) {
        if (optionCounts == null) {
            optionCounts = new HashMap<>();
        }
        if (optionCounts.containsKey(option)) {
            int count = optionCounts.get(option);
            optionCounts.put(option, count + 1);
        } else {
            optionCounts.put(option, 1);
        }
    }

    public static void programStatistics() {
        for (Integer option : optionCounts.keySet()) {
            System.out.println("Option " + option + " has been visited " + optionCounts.getOrDefault(option, 0) + " times.");
        }
    }

    static ShopSettings shopSettings1 = new ShopSettings();
    static Invoice invoice1 = new Invoice();
    static Item item1 = new Item();
    static Menue menu1 = new Menue();
    static InvoicingSystem invoSy1 = new InvoicingSystem();

    static void createNewInvoice(Scanner scanner) {
        InvoicingSystem.main(null);
    }

    static void reportStatistics() {
        System.out.println("Number of items is: " + Item.itemsQuatity(Menue.invoice1.items));
        System.out.println("The number of invoives is: " + invoice1.getInvoiceNo());
        invoice1.setTotalAmount(Invoice.calculateTotalAmount(invoice1.getItems()));
        System.out.println("The total sales is: " + invoice1.getTotalAmount());
    }


    static void searchInvoices(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Enter the invoice number: ");
        int invoiceN = scanner.nextInt();

        if (invoiceN == invoice1.getInvoiceNo()) {
            loadData(scanner);
        }
    }

    static void setShopName(Scanner scanner) {
        //ShopSettings shopSettings1 = new ShopSettings();
        scanner = new Scanner(System.in);
        String a;
        a = scanner.nextLine();
        shopSettings1.shopName = a;
        //scanner.close();
    }


    static void loadData(Scanner scanner) {
        System.out.println("Shop name is: " + shopSettings1.shopName);

        int count = 1;
        for (int i = 1; i < InvoicingSystem.items.size(); i++) {
            count++;
        }
        invoice1.setInvoiceNo(count);

        System.out.println("Invoice No is: " + invoice1.getInvoiceNo());

        System.out.println("Customer name is: " + invoice1.getCustomerFullName());

        System.out.println("Customer phone number: " + invoice1.getPhoneNumber());

        Date inDate = new Date();
        invoice1.setInvoiceDate(inDate);
        System.out.println("Invoice date: " + invoice1.getInvoiceDate());

        for (Item i : invoice1.items) {
            System.out.println("Added Items: " + i.toString());

        }

        invoice1.setTotalAmount(Invoice.calculateTotalAmount(invoice1.getItems())); ///<-
        System.out.println("The total amout: " + invoice1.getTotalAmount());

        System.out.println("How much do you want to pay? ");
        double paid = scanner.nextDouble();
        invoice1.setPaidAmount(paid);
        System.out.println("The paid amount is: " + invoice1.getPaidAmount());

        item1.setQuantity(Item.itemsQuatity(InvoicingSystem.items));
    }

    static void reportAllInvoices() {
        System.out.println("The invoce number is: " + invoice1.getInvoiceNo());
        System.out.println("The invoce date is: " + invoice1.getInvoiceDate());
        System.out.println("Customer full name is: " + invoice1.getCustomerFullName());
        System.out.println("The number of items is: " + item1.getQuantity());
        System.out.println("The total amount is: " + invoice1.getTotalAmount());
        double balance = invoice1.getTotalAmount() - invoice1.getPaidAmount();
        invoice1.setBalance(balance);
        System.out.println("The balance is: " + invoice1.getBalance());

        invoice1.setTotalAmount(invoice1.getBalance());//
        invoice1.getTotalAmount(); //

    }

    static void setInvoiceHeader(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Enter your phone number: ");
        String phoneN = scanner.nextLine();
        System.out.println("Enter your fax: ");
        String fax = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your website: ");
        String website = scanner.nextLine();

    }

    static void addItems(Scanner scanner) {
        while (true) {
            System.out.println("What are you buying? When you are done, type " + "done ");
            String input = scanner.nextLine();
            if (input.equals("done")) {
                break;
            }
            Item obj = new Item();
            obj.itemName = input;
            obj.itemId = (int) (Math.random() * (253 - 1 + 1) + 1);
            obj.unitPrice = (int) (Math.random() * (5 - 1 + 1) + 1);
            System.out.println("How many " + obj.itemName + " do you want? ");
            obj.quantity = scanner.nextInt();
            scanner.nextLine();

            invoSy1.items.add(obj);
        }
        Menue.invoice1.items = invoSy1.items;
        invoSy1.items.toString();
    }

    static void deleteItems(Scanner scanner) {
        HashMap<Double, Item> itemHashMap = new HashMap<>();
        for (Item i : InvoicingSystem.items) {
            itemHashMap.put(i.itemId, i);
        }

        System.out.println("Choose the item that you want to remove: ");
        for (Item element : InvoicingSystem.items) {
            System.out.println(element.itemId + "-- " + "Item name is: " + element.itemName);
            count1++;
        }

        System.out.print("Enter your choice: ");
        Double choice = scanner.nextDouble();
        scanner.nextLine();

        if (itemHashMap.containsKey(choice)) {
            itemHashMap.remove(choice);
            InvoicingSystem.items = itemHashMap.values().stream().toList();

            for (Item element : InvoicingSystem.items) {
                System.out.println(element.itemId + "-- " + "Item name is: " + element.itemName);
            }
        }
    }

    static void changeItemPrice(Scanner scanner) {
        HashMap<Double, Item> itemHashMap = new HashMap<>();

        for (Item i : InvoicingSystem.items) {
            itemHashMap.put(i.itemId, i);
        }
        System.out.println("Choose the item that you want to change its price: ");

        for (Item element : InvoicingSystem.items) {
            System.out.println(element.itemId + "-- " + "Item name is: " + element.itemName + " and its current price is; " + element.unitPrice);
            count1++;
        }

        System.out.print("Enter your choice: ");
        Double choice = scanner.nextDouble();
        scanner.nextLine();

        if (itemHashMap.containsKey(choice)) {
            Item itemObjToChange = itemHashMap.get(choice);
            System.out.println("Original Item: " + itemObjToChange.toString());
            itemObjToChange.unitPrice = (int) (Math.random() * (9 - 7 + 1) + 7);
            System.out.println("Modified Item: " + itemObjToChange.toString());

            itemHashMap.remove(choice);
            itemHashMap.put(itemObjToChange.itemId, itemObjToChange);
            InvoicingSystem.items = itemHashMap.values().stream().toList();

            for (Item element : InvoicingSystem.items) {
                System.out.println(element.itemId + "-- " + "Item name is: " + element.itemName + " and its changed price is; " + element.unitPrice);
            }
        }
    }

    static void reportAllItems() {
        Scanner scanner = new Scanner(System.in);
        Menue.loadData(scanner);
    }
}