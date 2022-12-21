import java.util.Scanner;

class Demo15 implements Runnable {
    public void run() {
        System.out.println("Banking Activity started");

        Scanner s = new Scanner(System.in);
        System.out.println("Enter account number");
        int an = s.nextInt();
        System.out.println("Enter password");
        int pw = s.nextInt();
        System.out.println("Collect your money");

        System.out.println("Banking activity completed");
    }
}

class Demo25 implements Runnable {
    public void run() {
        try {
            System.out.println("Printing activity started");

            for (int i = 0; i < 5; i++) {
                System.out.println("ABC");
                Thread.sleep(3000);
            }

            System.out.println("Printing activity completed");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Demo35 implements Runnable {
    public void run() {
        System.out.println("Addition activity started");

        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println(c);

        System.out.println("Addition activity completed");
    }
}

public class LaunchMultiThread {
    public static void main(String[] args) {
        Demo15 d1 = new Demo15();
        Demo25 d2 = new Demo25();
        Demo35 d3 = new Demo35();

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        Thread t3 = new Thread(d3);

        t1.start();
        t2.start();
        t3.start();
    }
}
