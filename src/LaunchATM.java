import java.util.Scanner;

class InvalidCredentials extends Exception {
    public String getMessage() {
        return "Invalid credentials, Please try again!";
    }
}

class UserBlockedException extends Exception {
    public String getMessage() {
        return "Maximum attempts reached! Your card is blocked!";
    }
}
class Users {
    int username;
    int password;

    Users (int username, int password) {
        this.username = username;
        this.password = password;
    }

    int getUsername() {
        return this.username;
    }

    int getPassword() {
        return this.password;
    }
}

class Atm {
    int inputUsername;
    int inputPassword;
    int attempts = 3;
    int getAttempts() {
        return this.attempts;
    }
    void acceptInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter username");
        inputUsername = s.nextInt();
        System.out.println("Please enter password");
        inputPassword = s.nextInt();
    }
    void login(Users u) throws InvalidCredentials, UserBlockedException {

        if (inputUsername != u.getUsername() || inputPassword != u.getPassword()) {
            InvalidCredentials ic = new InvalidCredentials();
            UserBlockedException ube = new UserBlockedException();
            attempts--;
            while (attempts > 0) {
                System.out.println(ic.getMessage()+ " -Message displayed in ATM");
                throw ic;
            }
            System.out.println(ube.getMessage() + " -Message displayed in ATM");
            throw ube;
        } else {
            System.out.println("Login Successful, Please proceed");
        }
    }
}

class Bank {
    Users u = new Users(1111,2222);
    Atm atm = new Atm();
    void init() {
        try {
            while (atm.getAttempts() > 0) {
                try {
                    atm.acceptInput();
                    atm.login(u);
                }
                catch (InvalidCredentials ic) {
                    System.out.println(ic.getMessage() + " -Message displayed in Bank");
                }
            }
        }
        catch (UserBlockedException ube) {
            System.out.println(ube.getMessage() + " -Message displayed in Bank");
        }
    }
}

public class LaunchATM {
    public static void main(String[] args) {
        Bank b = new Bank();
        b.init();
    }
}
