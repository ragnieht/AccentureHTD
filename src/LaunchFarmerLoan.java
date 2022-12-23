import java.util.Scanner;

class Farmer{
    float principal;
    float time;
    static float rateOfInterest = 2.5f;
    float simpleInterest;

    void acceptInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the principal");
        principal = s.nextFloat();
        System.out.println("Enter the duration");
        time = s.nextFloat();
    }

    void compute() {
        simpleInterest = (principal * time * rateOfInterest) / 100;
    }

    void display() {
        System.out.println("Your simple interest is " + simpleInterest);
    }
}

public class LaunchFarmerLoan {
    public static void main(String[] args) {
        Farmer f1 = new Farmer();
        Farmer f2 = new Farmer();
        Farmer f3 = new Farmer();

        f1.acceptInput();
        f1.compute();
        f1.display();

        f2.acceptInput();
        f2.compute();
        f2.display();

        f3.acceptInput();
        f3.compute();
        f3.display();
    }

}
