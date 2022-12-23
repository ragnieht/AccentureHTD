import java.util.Random;
import java.util.Scanner;

interface PasswordGenerator {
    void conditionChecker();
    void builder();
    void disp();
    void init();
}
class Data {
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    // defining available characters
    String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numbers = "0123456789";
    String symbols = "!@#$%^&*()";
    String characters = lowerCase + upperCase;
    int length = 0;
    String numCondition = null;
    String symCondition = null;
    String result = null;
}
class Generator extends Data implements PasswordGenerator {
    public void conditionChecker () {
        System.out.println("Please enter length of password");
        length = s.nextInt();
        System.out.println("Do you want numbers in your password? (y/n)");
        numCondition = s.next();
        System.out.println("Do you want symbols in your password? (y/n)");
        symCondition = s.next();
    }

    public void builder () {
        if (numCondition.equals("y")) characters += numbers;
        if (symCondition.equals("y")) characters += symbols;

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomNum = r.nextInt(characters.length());
            password.append(characters.charAt(randomNum));
        }
        result = password.toString();
    }

    public void disp() {
        System.out.println("Your generated random password is: " + result);
    }

    public void init() {
        conditionChecker();
        builder();
        disp();
    }
}
public class LaunchPasswordGenerator {
    public static void main(String[] args) {
        Generator g = new Generator();
        g.init();
    }
}

