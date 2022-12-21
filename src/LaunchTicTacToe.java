import java.util.*;

class TTT {
    char[][] gameBoard = {{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '},{'-','+','-','+','-'},{' ','|',' ','|',' '},};
    String curPlayer = "Player";
    Scanner s = new Scanner(System.in);
    int pos;
    char symbol;
    int turnsLeft = 9;
    int[] arr;
    ArrayList<Integer> playerPos = new ArrayList<Integer>();
    ArrayList<Integer> botPos = new ArrayList<Integer>();
    void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    void placePiece(char[][] gameBoard, int pos, String user) {
        symbol =  user.equals("Player") ? 'X' :  'O';

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }
        if (user.equals("Player")) playerPos.add(pos);
        if (user.equals("Bot")) botPos.add(pos);
        turnsLeft -= 1;

//        Integer[] playerPosArr = new Integer[playerPos.size()];
//        playerPosArr = playerPos.toArray(playerPosArr);
//        System.out.println("Player positions: " + Arrays.toString(playerPosArr));
//        Integer[] botPosArr = new Integer[botPos.size()];
//        botPosArr = botPos.toArray(botPosArr);
//        System.out.println("Bot positions: " + Arrays.toString(botPosArr));
//        System.out.println(turnsLeft);

        checkWinner();
        curPlayer = curPlayer.equals("Player") ? "Bot" : "Player";
        printGameBoard(gameBoard);
    }

    void askForPlacementPos() {
        System.out.println("Please enter a placement (1-9)");
        pos = s.nextInt();
    }

    boolean gameEnded() {
        return (turnsLeft > 0) ? false : true;
    }

    boolean checkWinner() {
        boolean output = false;
        List<Integer> rule1 = Arrays.asList(1,2,3);
        List<Integer> rule2 = Arrays.asList(4,5,6);
        List<Integer> rule3 = Arrays.asList(7,8,9);
        List<Integer> rule4 = Arrays.asList(1,4,7);
        List<Integer> rule5 = Arrays.asList(2,5,8);
        List<Integer> rule6 = Arrays.asList(3,6,9);
        List<Integer> rule7 = Arrays.asList(1,5,9);
        List<Integer> rule8 = Arrays.asList(3,5,7);
        List<List<Integer>> allRules = Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6,rule7,rule8);

        for (List<Integer> rule : allRules) {
            if (playerPos.containsAll(rule) || botPos.containsAll(rule)) {
                System.out.println(curPlayer + " has won the game!");
                output = true;
                System.exit(0);
            }
        }
        return output;
    }

    void init() {
        printGameBoard(gameBoard);

        while (!gameEnded() && !checkWinner()) {
            askForPlacementPos();
            placePiece(gameBoard,pos,curPlayer);
        }
    }
}



public class LaunchTicTacToe {
    public static void main(String[] args) {
        TTT game = new TTT();
        game.init();
    }
}
