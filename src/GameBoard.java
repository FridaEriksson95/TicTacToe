import java.util.Scanner;
//My gameBoard
public class GameBoard {

    CheckWinner checkWinner = new CheckWinner();
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
    public void resetBoard() {
        this.board = new char[][]
                {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
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
    public void makeMove(Player player, Scanner scanner) {
        boolean validMove;
        do {
            System.out.println("Where would " + player.getName() + " like to play their " + player.getSymbol() + " (1-9)?");
            try {
                int move = Integer.parseInt(scanner.nextLine());
                validMove = updateBoard(move, player.getSymbol());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between 1-9 please!");
                validMove = false;
            }
            System.out.println(" ");
        } while (!validMove);
    }

    private Player playerX;
    private Player playerO;

    public void setupPlayers(Scanner scanner) {
        System.out.println("Welcome to TicTacToe! Let's start the game❗️");
        this.playerX = Player.createPlayer(scanner, 'X');
        this.playerO = Player.createPlayer(scanner, 'O');
    }
    public void startGame(Scanner scanner) {
        resetBoard();
        playGame(scanner);
    }
    public void playGame(Scanner scanner){
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println(" ");
            printBoard();

            makeMove(playerX, scanner);
            printBoard();
            System.out.println(" ");

            if (checkWinner.winnerCheck(getBoard(), playerX.getSymbol())) {
                playerX.setWins(playerO);
                gameOver = true;
            } else if (checkWinner.isBoardFull(getBoard())) {
                System.out.println("It's a tie!");
                gameOver = true;
            }

            if (gameOver) break;

            makeMove(playerO, scanner);
            printBoard();
            System.out.println(" ");
            if (checkWinner.winnerCheck(getBoard(), playerO.getSymbol())) {
                playerO.setWins(playerX);
                gameOver = true;
            } else if (checkWinner.isBoardFull(getBoard())) {
                System.out.println("It's a tie!");
                gameOver = true;
            }
        }
    }
}

