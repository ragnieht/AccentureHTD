import java.util.Scanner;

class InvalidAgeException extends Exception {
    public String getMessage() {
        return "You are too young to drive";
    }
}

class Applicant {
    int age;

    void acceptInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your age");
        age = s.nextInt();
    }

    void verify() throws InvalidAgeException {
        if (age >= 18) {
            System.out.println("Please proceed");
        }
        else {
            InvalidAgeException iae = new InvalidAgeException();
            System.out.println(iae.getMessage() + " - Message displayed on Applicant's screen");
            throw iae;
        }
    }
}

class Rto {
    void initiate() {
        Applicant a = new Applicant();
        try {
            a.acceptInput();
            a.verify();
        }
        catch (InvalidAgeException iae) {
            System.out.println(iae.getMessage()+ " - Message displayed on RTO's screen");
        }
    }
}

public class LaunchDriving {
    public static void main(String[] args) {
        Rto rto = new Rto();
        rto.initiate();
    }
}
