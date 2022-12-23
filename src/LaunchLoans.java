import java.util.Scanner;

public class LaunchLoans {
    public static void main(String[] args) {
        Farmer f1 = new Farmer();
        f1.newEntry();
        Farmer f2 = new Farmer();
        f2.newEntry();
        Farmer f3 = new Farmer();
        f3.newEntry();
    }

    public static class Farmer {
        int principal;
        int duration;
        float interest;
        double simpleInt;
        Scanner s = new Scanner(System.in);

        public void input(){
            System.out.println("What is your Principal amount?");
            principal = s.nextInt();
            System.out.println("What is the duration of your Loan?");
            duration = s.nextInt();
            System.out.println("What is your monthly Interest?");
            interest = s.nextInt();

        }

        public void compute(){
            simpleInt = ( principal * duration * interest) / 100;
        }

        public String disp(){
            String statement = "Your simple interest is " + simpleInt;
            System.out.println(statement);
            return statement;
        }

        public void newEntry() {
            this.input();
            this.compute();
            this.disp();
        }
    }




}
