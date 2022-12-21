import java.util.InputMismatchException;
import java.util.Scanner;

class Demo10 {
    void fun1() throws ArithmeticException, InputMismatchException {
        System.out.println("Connectionn2 establisshed");
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the numerator");
            int a = s.nextInt();
            System.out.println("Enter the denominator");
            int b = s.nextInt();
            int c = a/b;
            System.out.println(c);
        }
        catch (ArithmeticException e){
            System.out.println("Problem resolved in fun1");
            throw e;
        }
        catch (InputMismatchException e) {
            System.out.println("Problem resolved in fun1");
            throw e;
        }
        finally {
            System.out.println("Connection2 terminated");
        }
    }
}

public class LaunchErrors {
    public static void main(String[] args) {
        System.out.println("Connection1 established");
        try {
            Demo10 d1 = new Demo10();
            d1.fun1();
        }
        catch(ArithmeticException e) {
            System.out.println("Problem resolved in main");
        }
//        Demo10 d1 = new Demo10();
//        d1.fun1();
        System.out.println("Connection1 terminated");
    }
}
