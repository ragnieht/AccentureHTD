import java.util.Scanner;

public class Launch2 {
    public static void main(String[] args) {
        int[][][] schools = new int[2][3][3];

        Scanner s = new Scanner(System.in);

        for (int i = 0; i < schools.length; i++) {
            for (int j = 0; j < schools[i].length; j++) {
                for(int k = 0; k < schools[i][j].length; k++) {
                    System.out.println("Enter marks for student " + (k+1) + " of class " + j + " of school " + i );
                    schools[i][j][k] = s.nextInt();
                }
            }
        }
        for (int i = 0; i < schools.length; i++) {
            for (int j = 0; j < schools[i].length; j++) {
                for(int k = 0; k < schools[i][j].length; k++) {
                    System.out.println("Student " + (k+1) + " of class " + j + " of school " + i + " scored " + schools[i][j][k] + " marks.");
                }
            }
        }
    }
}
