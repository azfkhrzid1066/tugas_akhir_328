
import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private char currentPlayer;
    private int moveCount;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        moveCount = 0;
    }

    public void startGame() {
        while (moveCount < 9) {
            printBoard();
            System.out.println(currentPlayer + "'s turn");
            int row = getInput("Enter row (0-2): ");
            int col = getInput("Enter column (0-2): ");
            makeMove(row, col);
        }
        System.out.println("Game Over!");
    }

    private void makeMove(int row, int col) {
        if (board[row][col] == '\u0000') {
            board[row][col] = currentPlayer;
            moveCount++;
            checkWinner();
            switchPlayer();
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    private void checkWinner() {
        // horizontal check
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                System.out.println(board[i][0] + " wins!");
                System.exit(0);
            }
        }

        // vertical check
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                System.out.println(board[0][i] + " wins!");
                System.exit(0);
            }
        }

        // diagonal check
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            System.out.println(board[0][0] + " wins!");
            System.exit(0);
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            System.out.println(board[0][2] + " wins!");
            System.exit(0);
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();
    }
}
