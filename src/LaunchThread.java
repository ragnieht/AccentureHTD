class Demo11 extends Thread {
    public void run() {
        if(getName().equals("BANK")) {
            banking();
        } else if(getName().equals("PRINT")) {
            printing();
        } else if(getName().equals("ADD")) {
            addition();
        }
    }

    void banking() {
        System.out.println("Banking activity");
    }

    void printing() {
        try {
            System.out.println("Printing");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addition() {
        System.out.println("Adding");
    }
}

public class LaunchThread {
    public static void main(String[] args) {
        Demo11 d1 = new Demo11();
        Demo11 d2 = new Demo11();
        Demo11 d3 = new Demo11();

        d1.setName("BANK");
        d2.setName("PRINT");
        d3.setName("ADD");

        d1.start();
        d2.start();
        d3.start();
    }
}
