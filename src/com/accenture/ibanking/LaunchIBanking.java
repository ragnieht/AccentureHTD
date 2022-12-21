package com.accenture.ibanking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Functions {
    void welcome();
    void selectSteps();
    void createUser();
    void getAccounts();
    void logIn();
    void logOut();
    void getBalance();
    void deposit();
    void withdraw();
    void transfer();
}
class Accounts {
    int accNum;
    String accName;
    String accPw;
    int accBal;

    Accounts(int accNum, String accName, String accPw, int accBal) {
        this.accNum = accNum;
        this.accName = accName.toLowerCase();
        this.accPw = accPw;
        this.accBal = accBal;
    }
    int getAccNum() {
        return this.accNum;
    }
    String getAccName() {
        return this.accName;
    }
    String getAccPw() {
        return this.accPw;
    }
    int getAccBal() {
        return this.accBal;
    }
    void setAccBal(int newBal) {
        this.accBal = newBal;
    }
    void display() {
        System.out.println();
        System.out.println("Account No.      :" + accNum);
        System.out.println("Account Name     :" + accName);
        System.out.println("Account Password :" + accPw);
        System.out.println("Latest Acc Bal   :" + accBal);
        System.out.println();
    }
}
class IBanking implements Functions {
    Scanner s = new Scanner(System.in);
    int curStep = 0;
    Accounts curAcc;
    Map<Integer, Accounts> accounts = new HashMap<>();

    public void welcome() {
        Scanner s = new Scanner(System.in);
        int input;

        // Initialise 2 default accounts
        if (!accounts.containsKey(123) && !accounts.containsKey(234)) {
            accounts.put(123,new Accounts(123,"test1","Test123",100_000));
            accounts.put(234,new Accounts(234,"test2","Test234",50_000));
        }

        // Welcome message and option
        System.out.println();
        System.out.println("Welcome to Bank XYZ, what would you like to do today?");
        System.out.println("1)Create new account" + "\n" + "2)Log In" + "\n" + "3)Exit Application");
        input = s.nextInt();
        switch (input) {
            case 1:
                curStep = 1;
                createUser();

            case 2:
                curStep = 2;
                logIn();

            case 3:
                curStep = 9;
                exit();

            default:
                System.out.println("Invald input! Please try again");
                selectSteps();
        }
        getAccounts();
    }

    public void createUser() {
        Scanner s = new Scanner(System.in);
        int accNum;
        String accName;
        String accPw;
        int accBal;
        int totalLoan = 0;

        // Ask for new account name
        System.out.println();
        System.out.println("Please enter your new account name");

        // Check if input is Integer
        if (s.hasNextInt()) {
            System.out.println("Please enter letters!");
            createUser();
        }
        accName = s.nextLine();
//        System.out.println("acc name: " + accName);

        // Check if account name is taken
        if (accounts.containsValue(accName)) {
            System.out.println("Name is taken! Please try again!");
            createUser();
        }

        // Ask for account number
        System.out.println();
        System.out.println("Please enter your new account number");
        // Check if input is Integer
        if (!s.hasNextInt()) {
            System.out.println("Please enter numbers only!");
            createUser();
        }
        accNum = s.nextInt();
//        System.out.println("Account number: " + accNum);

        // Check if account name is taken
        if (accounts.containsKey(accNum)) {
            System.out.println("Account number is taken! Please try again!");
            createUser();
        }

        // Ask for acc password
        System.out.println();
        System.out.println("Please enter your new account password!(Case-Sensitive, more than 5 characters)");
        s.nextLine();
        accPw = s.nextLine();
        System.out.println("Account password: " + accPw);

        // Check if password fulfils condition
        if (accPw.length() < 5) {
            System.out.println("Password length not long enough! Please try again!");
            createUser();
        }

        // Ask for starting balance
        System.out.println();
        System.out.println("Please enter your starting balance");
        accBal = s.nextInt();
        System.out.println("Starting Balance: " + accBal);

        // Creating new account
        accounts.put(accNum,new Accounts(accNum,accName,accPw,accBal));
        System.out.println("Your account has been created!");
        curAcc = accounts.get(accNum);
        // Display accounts and bring back to menu
        selectSteps();
    }

    public void getAccounts() {
        System.out.println("Shown below are all current active accounts");

        // reach display method in Account Obj
        for (Map.Entry a: accounts.entrySet()){
            accounts.get(a.getKey()).display();
        }
        selectSteps();
    }

    public void logIn() {
        Scanner s = new Scanner(System.in);
        int accNum;
        String accPw;

        // Verify account number
        System.out.println("Please enter account number");

        // Check if input is Integer
        if (!s.hasNextInt()) {
            System.out.println("Please enter numbers only!");
            logIn();
        }
        accNum = s.nextInt();

        if (!accounts.containsKey(accNum)) {
            System.out.println("No account found! Please try again!");
            logIn();
        }
        curAcc = accounts.get(accNum);


        // Verify account password
        System.out.println("Please enter account password");
        s.nextLine();
        accPw = s.nextLine();
        if (!accPw.equals(curAcc.getAccPw())) {
            System.out.println("Wrong password! Please try again!");
            logIn();
        }

        // Success login, redirect to steps
        System.out.println("Login successful!");
        System.out.println("Welcome " + curAcc.getAccName());
        selectSteps();
    }

    public void logOut() {
        System.out.println();
        System.out.println("You have successfully logged out!");
        curAcc = null;
        curStep = 0;
        welcome();
    }

    public void selectSteps() {
        Scanner s = new Scanner(System.in);
        System.out.println("What would you like to do today?");
        System.out.println("3)Check balance" + "\n" + "4)Deposit" + "\n" + "5)Withdraw" + "\n" + "6)Transfer" + "\n" + "7)Check com.accenture.ibanking.Accounts" + "\n" + "8)Log Out" + "\n" + "9)Exit Application");
        curStep = s.nextInt();
        switch(curStep) {
            case 3: getBalance();
                break;
            case 4: deposit();
                break;
            case 5: withdraw();
                break;
            case 6: transfer();
                break;
            case 7: getAccounts();
                break;
            case 8: logOut();
                break;
            case 9: exit();
                break;
            default:
                System.out.println("Invald input! Please try again");
                selectSteps();
        }
    }

    public void getBalance() {
        System.out.println("Your latest balance is $" + accounts.get(curAcc.getAccNum()).getAccBal());
        System.out.println();
        selectSteps();
    }

    public void deposit() {
        Scanner s = new Scanner(System.in);
        int depositAmnt;
        String confirm;

        // Ask for deposit amount
        System.out.println("Please enter deposit amount");

        // Check if input is Integer
        if (!s.hasNextInt()) {
            System.out.println("Please enter numeric value");
            deposit();
        }
        depositAmnt = s.nextInt();

        // Check if deposit amount is positive value
        if (depositAmnt < 0) {
            System.out.println("Please enter a value greater than 0");
            deposit();
        }

        // Confirmation of deposit
        System.out.println("Confirm to deposit $" + depositAmnt + " into account? (y/n)");
        s.nextLine();
        confirm = s.nextLine();

        // Successful deposit
        if (confirm.equals("y")) {
            curAcc.setAccBal(depositAmnt += curAcc.getAccBal());
            System.out.println("Deposit Successful!");
            getBalance();
            selectSteps();
        } else

        // Cancel Deposit
        if (confirm.equals("n")) {
            System.out.println("Deposit canceled, returning to menu");
            selectSteps();
        } else System.out.println("Invalid input! Please try again!");
    }

    public void withdraw() {
        Scanner s = new Scanner(System.in);
        int withdrawAmnt;
        String confirm;

        // Ask for withdraw amount
        System.out.println("Please enter withdraw amount");

        // Check if input is Integer
        if (!s.hasNextInt()) {
            System.out.println("Please enter numeric value");
            withdraw();
        }
        withdrawAmnt = s.nextInt();

        // Check if withdraw amount is more than balance
        if (withdrawAmnt > curAcc.getAccBal()) {
            System.out.println("Not enough funds in account! Please try again!");
            withdraw();
        }

        // Confirmation of withdrawal
        System.out.println("Confirm to withdraw $" + withdrawAmnt + " from account? (y/n)");
        s.nextLine();
        confirm = s.nextLine();

        // Successful withdrawal
        if (confirm.equals("y")) {
            int bal = curAcc.getAccBal();
            curAcc.setAccBal(bal -= withdrawAmnt);
            System.out.println("Withdrawal Successful!");
            getBalance();
            selectSteps();
        } else

            // Cancel Withdrawal
            if (confirm.equals("n")) {
                System.out.println("Withdrawal canceled, returning to menu");
                selectSteps();
            } else System.out.println("Invalid input! Please try again!");
    }

    public void transfer() {
        Scanner s = new Scanner(System.in);
        int targetAcc;
        int transAmnt;
        String confirm;

        // Ask for recipient account number
        System.out.println("Please enter recipient account number");
        targetAcc = s.nextInt();

        // Check if recipient account exists
        if (!accounts.containsKey(targetAcc)) {
            System.out.println("No account found! Please try again!");
            transfer();
        }

        // Check if recipient is self
        if (targetAcc == curAcc.getAccNum()) {
            System.out.println("Not allowed to transfer to self! Please try again!");
            transfer();
        }

        // Ask for transfer amount
        System.out.println("Please enter amount to transfer");
        transAmnt = s.nextInt();

        // Check if transfer amount is positive value
        if (transAmnt < 0) {
            System.out.println("Please enter a positive value! Try again!");
            transfer();
        }

        // Check if transfer amount exceeds balance
        if (transAmnt > curAcc.getAccBal()) {
            System.out.println("Not enough funds in account! Please try again!");
            transfer();
        }

        // Confirmation of transfer
        System.out.println("Confirm to transfer $" + transAmnt + " from account no." + curAcc.getAccNum() + "to account no." + targetAcc + "? (y/n)");
        s.nextLine();
        confirm = s.nextLine();

        // Successful transfer
        if (confirm.equals("y")) {
            int bal = curAcc.getAccBal();
            // change sender balance
            curAcc.setAccBal(bal -= transAmnt);
            // change recipient balance
            bal = accounts.get(targetAcc).getAccBal();
            accounts.get(targetAcc).setAccBal(bal += transAmnt);
            System.out.println("Transfer Successful!");
            getBalance();
            selectSteps();
        } else
            // Cancel transfer
            if (confirm.equals("n")) {
                System.out.println("Transfer canceled, returning to menu");
                selectSteps();
            } else System.out.println("Invalid input! Please try again!");
    }

    public void exit() {
        System.out.println("Thank you for banking with us! See you again soon!");
        System.exit(0);
    }
}
class Init {
    void init(Functions ref) {
        ref.welcome();
    }
}
public class LaunchIBanking {
    public static void main(String[] args) {
        IBanking b1 = new IBanking();
        Init i = new Init();
        i.init(b1);
    }
}
