import java.util.*;

class Hotel {
    Scanner s = new Scanner(System.in);
    // initialise items information
    String[] itemNames = {"Water","Pepsi","Pizza","Fries","Burger"};
    int[] itemPrices = {10,25,50,35,60};
    Map<Integer,Integer> orderIdPrice = new HashMap<Integer,Integer>();
    Map<Integer,Integer> orderIdQuantity = new HashMap<Integer,Integer>();
    Map<Integer,Integer> orderIdTotal = new HashMap<Integer,Integer>();
    String curName = null;
    void greetingsMessage() {
        // Welcome Message and introduction
        System.out.println("Welcome to hotel" + "\n" + "Dear customer, please enter your name");
        curName = s.nextLine();
        System.out.println("Dear " + curName + ", below is the menu");
    }
    void printMenu() {
        // Printing Menu
        String format = "| %-6s | %-12s | %-9s | %n";
        System.out.format("+--------+--------------+-----------+%n");
        System.out.format("| ItemID |   ItemName   | ItemPrice |%n");
        System.out.format("+--------+--------------+-----------+%n");
        for (int i = 0; i < itemNames.length; i++) {
            System.out.format(format,i+1,itemNames[i],itemPrices[i]);
        }
        System.out.format("+--------+--------------+-----------+%n");
    }
    void takeOrder() {
        Scanner s = new Scanner(System.in);
        int orderId = 0;
        int orderQuantity = 0;
        int orderPrice = 0 ;
        int subTotal = 0;
        Map<Integer,Integer> menuIdPrice = new HashMap<Integer,Integer>();
        menuIdPrice.put(1, 10);
        menuIdPrice.put(2, 25);
        menuIdPrice.put(3, 50);
        menuIdPrice.put(4, 35);
        menuIdPrice.put(5, 60);

        printMenu();

        System.out.println("Enter the Item ID");
        orderId = s.nextInt();
        System.out.println("Enter the quantity");
        orderQuantity = s.nextInt();
        // Extract ID:PRICE pair and calculate subtotal
        for(Map.Entry m:menuIdPrice.entrySet()) {
            if (m.getKey().equals(orderId)) {
                orderPrice = (int) m.getValue();
                subTotal = orderPrice * orderQuantity;
                orderIdPrice.put((int)m.getKey(), (int)m.getValue());
                orderIdQuantity.put((int)m.getKey(), orderQuantity);
                orderIdTotal.put((int)m.getKey(), subTotal);
            }
        }
        continueOrder();
    }
    void continueOrder() {
        String input;
        System.out.println("Would you like to order more? (y/n)");
        input = s.next();
        if (input.equals("y")) {
            takeOrder();
        }
        else {
            giveBill();
        }
    }
    void showOrders() {
        String format = "| %-8s | %-9s | %-8s | %-8s | %n";
        System.out.format("+----------+-----------+----------+----------+%n");
        System.out.format("| ItemName | ItemPrice | Quantity | Subtotal |%n");
        System.out.format("+----------+-----------+----------+----------+%n");
        for (Map.Entry<Integer,Integer> order : orderIdPrice.entrySet()) {
            int id = order.getKey();
            int price = order.getValue();
            int quantity = orderIdQuantity.get(id);
            int subTotal = orderIdTotal.get(id);
            System.out.format(format, itemNames[id-1], price, quantity, subTotal);
        }
        System.out.format("+----------+-----------+----------+----------+%n");
    }
    void giveBill() {
        int total = 0;
        int finalTotal = 0;
        int tip = 0;
        float gst = 10.0f;
        showOrders();
        for (int i = 1; i <= orderIdTotal.size(); i++) {
            total += orderIdTotal.get(i);
        }
        System.out.println("Dear " + curName + ", your total bill amount is: " + total );
        System.out.println("Please enter the tip");
        tip = s.nextInt();
        System.out.println("GST: " + gst + "%");
        finalTotal = (total + tip) * ((int)(100+gst)) / 100;
        System.out.println("The total amount payable is: " + finalTotal);
    }
    void init() {
        greetingsMessage();
        takeOrder();
    }
}
public class LaunchHotelBillProj {
    public static void main(String[] args) {
        Hotel h = new Hotel();
        h.init();
    }
}
