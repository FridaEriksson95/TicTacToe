import java.util.Scanner;

//My gameBoard class
public class GameBoard {
    //instance to determine a winner after players move
    CheckWinner checkWinner = new CheckWinner();

    // the rows and cols for the board with the spaces to fill
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
     * Method for players and Ai to make a move on the board
     * @param player
     * @param scanner
     */
    public void makeMove(Player player, Scanner scanner) {
        //If choosen to play with Ai, method to place its move
        if(player instanceof CPU) {
            int move = ((CPU) player).chooseMove(this);
            System.out.println("AI bot chooses position: " + move);
        }else {
            boolean validMove;
        do {
            //Getting players input between 1-9
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
    }

    /**
     * Method to play the game with either two players or player vs AI
     * @param playerX
     * @param playerO
     * @param scanner
     */
    public void playGame(Player playerX, Player playerO, Scanner scanner) {
        boolean gameOver = false;

        //When game is not over, the board prints out
        while (!gameOver) {
            System.out.println(" ");
            printBoard();

            //Player x makes their move
            makeMove(playerX, scanner);
            printBoard();

            //Calls method that checks if player x wins on their past move
            if (checkWinner.winnerCheck(getBoard(), playerX.getSymbol())) {
                //Counts player X:s wins
                playerX.setWins(playerO);
                //If player x gets three in a row,col or diagnoal, game ends
                gameOver = true;
                //If no one wins, it checks and prints out tie
            } else if (checkWinner.isBoardFull(getBoard())) {
                System.out.println("It's a tie!");
                gameOver = true;
            }
            if (gameOver)
                break;

            //Player O makes their move
            makeMove(playerO, scanner);

            //Calling method that checks if player o wins on their past move
            if (checkWinner.winnerCheck(getBoard(), playerO.getSymbol())) {
                //Counts player O:s wins
                playerO.setWins(playerX);
                gameOver = true;
                printBoard();
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
     * Places the players symbols on the board by positioning with number 1-9, where 1 is top left and 9 is bottom right
     * @param position positioning where the player wants to place symbol
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