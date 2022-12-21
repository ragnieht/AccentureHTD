import java.sql.SQLOutput;
import java.util.Scanner;

public class Launch1 {
    public static void main(String[] args) {
        int marks[] = new int[5];

        Scanner s = new Scanner(System.in);
        // storing user input into marks array
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Enter marks of student " + (i+1) );
            marks[i] = s.nextInt();
        }
        // printing each mark from marks array
        for (int mark : marks) {
            System.out.println(mark);
        }
    }
}
