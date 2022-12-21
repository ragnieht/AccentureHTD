package com.accenture.billingsystem.demo;

import java.util.Scanner;

public class LaunchBillingSystem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // initialise items information
        String[] itemNames = {"Water","Pepsi","Pizza","Fries","Burger"};
        int[] itemPrices = {10,25,50,35,40};

        // Welcome Message and introduction
        System.out.println("Welcome to hotel" + "\n" + "Dear customer, please enter your name");
        String curName = s.nextLine();
        System.out.println("Dear " + curName + ", below is the menu");

        // Printing Menu
        String format = "| %-6s | %-12s | %-9s | %n";
        System.out.format("+--------+--------------+-----------+%n");
        System.out.format("| ItemID |   ItemName   | ItemPrice |%n");
        System.out.format("+--------+--------------+-----------+%n");
        for (int i = 0; i < itemNames.length; i++) {
            System.out.format(format,i+1,itemNames[i],itemPrices[i]);
        }
        System.out.format("+--------+--------------+-----------+%n");

        // Take order
        int itemID = 0;
        int quantity = 0;
        int subTotal = 0;
        String itemName = null;
        int itemPrice = 0;
        String order = "y";

        do {
            System.out.println("Please enter the item ID");
            itemID = s.nextInt();
            System.out.println("Please enter the quantity");
            quantity = s.nextInt();

            switch(itemID) {
                case 1: itemName = "Water";
                    itemPrice = 10;
                    subTotal = itemPrice*quantity;
                    break;
                case 2: itemName = "Pepsi";
                    itemPrice = 25;
                    subTotal = itemPrice*quantity;
                    break;
                case 3: itemName = "Pizza";
                    itemPrice = 50;
                    subTotal = itemPrice*quantity;
                    break;
                case 4: itemName = "Fries";
                    itemPrice = 35;
                    subTotal = itemPrice*quantity;
                    break;
                case 5: itemName = "Burger";
                    itemPrice = 40;
                    subTotal = itemPrice*quantity;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
            System.out.println("Item: " + itemName + "\n" + "Price: " + itemPrice + "\n" + "Quantity: " + quantity + "\n" + "Subtotal: " + subTotal);
            System.out.println("Would you like to order more? (y/n)");
            order = s.nextLine();

        } while (order == "y");
        System.out.println("Your order has finished");

    }
}
