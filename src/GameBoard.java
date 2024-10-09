import java.util.Scanner;

//My gameBoard class
public class GameBoard {
    //instance to determine a winner after players move
    CheckWinner checkWinner = new CheckWinner();

    // the outprinted gameboard for players to visualize where to play
    char[][] board =
            {{' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}};

    //constructor
    public GameBoard() {
    }

    //getter for board
    public char[][] getBoard() {
        return board;
    }

    //visual board
    public void printBoard() {
        System.out.println(" " + board[0][0] + " ║ " + board[0][1] + " ║ " + board[0][2]);
        System.out.println("═══╬═══╬═══");
        System.out.println(" " + board[1][0] + " ║ " + board[1][1] + " ║ " + board[1][2]);
        System.out.println("═══╬═══╬═══");
        System.out.println(" " + board[2][0] + " ║ " + board[2][1] + " ║ " + board[2][2]);
    }

    /**
     * Method for players to make a move on the board
     * @param player
     * @param scanner
     */
    public void makeMove(Player player, Scanner scanner) {
        boolean validMove;
        do {
        // Getting players input between 1-9
            System.out.println("Where would " + player.getName() + " like to play their " + player.getSymbol() + " (1-9)?");
            try {
            //Gets the valid move and place it on the board
                int move = Integer.parseInt(scanner.nextLine());
                validMove = updateBoard(move, player.getSymbol());
            //Catches if players input is a letter or other character then 1-9
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between 1-9 please!");
                validMove = false;
            }
            System.out.println(" ");
        } while (!validMove);
    }

    /**
     * Method to play the game
     * @param playerX
     * @param playerO
     * @param scanner
     */
    public void playGame(Player playerX, Player playerO, Scanner scanner) {
        boolean gameOver = false;

        //when game is not over, the board prints out
        while (!gameOver) {
            System.out.println(" ");
            printBoard();

            //player x makes their move
            makeMove(playerX, scanner);
            printBoard();
            System.out.println(" ");

            //Method checks if player x wins on their past move
            if (checkWinner.winnerCheck(getBoard(), playerX.getSymbol())) {
            //counts player x:s wins
                playerX.setWins(playerO);
            //if player x gets three in a row,col or diagnoal, game ends
                gameOver = true;
            //if no one wins, it checks and prints out tie
            } else if (checkWinner.isBoardFull(getBoard())) {
                System.out.println("It's a tie!");
                gameOver = true;
            }
            if (gameOver)
                break;
            //player O makes their move
            makeMove(playerO, scanner);
            printBoard();
            System.out.println(" ");

            //Method checks if player o wins on their past move
            if (checkWinner.winnerCheck(getBoard(), playerO.getSymbol())) {
                //counts player o:s wins
                playerO.setWins(playerX);
                gameOver = true;
            } else if (checkWinner.isBoardFull(getBoard())) {
                System.out.println("It's a tie!");
                gameOver = true;
            }
        }
    }

    /**
     * Attempt to place players move on the board at choosen number
     * @param row the row index
     * @param col the column index
     * @param symbol representing the players symbol, X and O
     * @return if move was successfull the symbol is placed, false if spot is taken
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

    /**
     * Places the players symbols on the board by positioning with number 1-9, where 1 is top left  and 9 is bottom right
     * @param position positioning where the players wants to place symbbol
     * @param symbol the representing of players character, x or o
     * @return place true if successfull position, false if taken spot or incorrect move
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

    //Reset board
    public void resetBoard() {
        this.board = new char[][]
                        {{' ', ' ', ' '},
                        {' ', ' ', ' '},
                        {' ', ' ', ' '}};
    }

    //Start new game if players choose to continue
    public void startGame(Player playerX, Player playerO, Scanner scanner) {
        resetBoard();
        playGame(playerX, playerO, scanner);
    }
}