import java.util.Scanner;
//My gameBoard
public class GameBoard {

    char[][] board = {{' ', ' ', ' '},
                      {' ', ' ', ' '},
                      {' ', ' ', ' '}};

    public GameBoard() {
    }

    public char[][] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println(" " + board[0][0] + " ║ " + board[0][1] + " ║ " + board[0][2]);
        System.out.println("═══╬═══╬═══");
        System.out.println(" " + board[1][0] + " ║ " + board[1][1] + " ║ " + board[1][2]);
        System.out.println("═══╬═══╬═══");
        System.out.println(" " + board[2][0] + " ║ " + board[2][1] + " ║ " + board[2][2]);
    }

    /**
     * @param position
     * @param symbol
     * @return
     */
    public boolean updateBoard(int position, char symbol) {
        switch (position) {
            case 1:
                return placeMove(0, 0, symbol);
            case 2:
                return placeMove(0, 1, symbol);
            case 3:
                return placeMove(0, 2, symbol);
            case 4:
                return placeMove(1, 0, symbol);
            case 5:
                return placeMove(1, 1, symbol);
            case 6:
                return placeMove(1, 2, symbol);
            case 7:
                return placeMove(2, 0, symbol);
            case 8:
                return placeMove(2, 1, symbol);
            case 9:
                return placeMove(2, 2, symbol);
            default:
                System.out.println("Invalid move. Please choose a number between 1-9.");
                return false;
        }
    }

    /**
     * @param row
     * @param col
     * @param symbol
     * @return
     */

    public boolean placeMove(int row, int col, char symbol) {
        if (board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        } else {
            System.out.println("That spot is already taken, choose another!");
            return false;
        }
    }
}

