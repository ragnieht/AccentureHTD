import java.util.Scanner;

interface Calculator {
    void add();
    void sub();
    void mul();
    void div();
}

class MyCalculator1 implements Calculator {
    public void add() {
        int a = 10;
        int b = 20;
        int c = a+b;
        System.out.println(c);
    }
    public void sub() {
        int a = 30;
        int b = 20;
        int c = a-b;
        System.out.println(c);
    }
    public void mul() {
        int a = 10;
        int b = 20;
        int c = a*b;
        System.out.println(c);
    }
    public void div() {
        int a = 100;
        int b = 20;
        int c = a/b;
        System.out.println(c);
    }
}

class MyCalculator2 implements Calculator {
    public void add() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = s.nextInt();
        System.out.println("Enter the second number");
        int b = s.nextInt();
        int c = a+b;
        System.out.println(c);
    }
    public void sub() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = s.nextInt();
        System.out.println("Enter the second number");
        int b = s.nextInt();
        int c = a-b;
        System.out.println(c);
    }
    public void mul() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = s.nextInt();
        System.out.println("Enter the second number");
        int b = s.nextInt();
        int c = a*b;
        System.out.println(c);
    }
    public void div() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = s.nextInt();
        System.out.println("Enter the second number");
        int b = s.nextInt();
        int c = a/b;
        System.out.println(c);
    }
}

class MyCalculator3 implements Calculator {
    public void add() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = s.nextInt();
        System.out.println("Enter the second number");
        int b = s.nextInt();
        if (a > 0  && b > 0) {
            int c = a+b;
            System.out.println(c);
        }
        else {
            System.out.println("Invalid input");
        }
    }
    public void sub() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = s.nextInt();
        System.out.println("Enter the second number");
        int b = s.nextInt();
        if ( a > b) {
            int c = a-b;
            System.out.println(c);
        }
        else {
            System.out.println("Invalid input");
        }
    }
    public void mul() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = s.nextInt();
        System.out.println("Enter the second number");
        int b = s.nextInt();
        if (a > 0  && b > 0) {
            int c = a*b;
            System.out.println(c);
        }
        else {
            System.out.println("Invalid input");
        }
    }
    public void div() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = s.nextInt();
        System.out.println("Enter the second number");
        int b = s.nextInt();
        if (b != 0) {
            int c = a/b;
            System.out.println(c);
        }
        else {
            System.out.println("Invalid denominator");
        }
    }
}

class Demo {
    void permit(Calculator ref) {
        ref.add();
        ref.sub();
        ref.mul();
        ref.div();
    }
}

public class LaunchCalculator {
    public static void main(String[] args) {
        MyCalculator1 mc1 = new MyCalculator1();
        MyCalculator2 mc2 = new MyCalculator2();
        MyCalculator3 mc3 = new MyCalculator3();

        Demo d = new Demo();
        d.permit(mc1);
        d.permit(mc2);
        d.permit(mc3);
    }
}
