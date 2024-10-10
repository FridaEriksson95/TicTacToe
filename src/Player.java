import java.util.Scanner;

public class Player {
    //Instancevariables for player
    private String name;
    private char symbol;
    private int wins;

    //Constructor
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    //Getters for name, symbol and wins
    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }
    public int getWins() {
        return wins;
    }

    //Setter for wins, that prints out the scores and scoreboard between players
    public void setWins(Player opponent) {
        this.wins++;
        System.out.println(getName() + " wins the game 🥇and has a score of: " + getWins());
        System.out.println("The scoreboard is now: ");
        System.out.println(getName() + ": " + getWins() + " " + opponent.getName() + ": " + opponent.getWins());
        System.out.println(" ");
    }

    /**
     * @param scanner Creating player and asks who they would like to challenge, friend or Ai
     * @return Asking for the players name and returning their input to the game
     */
    public static Player[] setupPlayers(Scanner scanner) {
        System.out.println("Welcome to TicTacToe! Let's start a game ❌⭕️");

        //Create player X
        System.out.println("Enter name for player X: ");
        String playerXName = scanner.nextLine();
        Player playerX = new Player(playerXName, 'X');

        //Asks who they would like to challenge
        System.out.println("Who would you like to challenge?");
        System.out.println("1. A friend👊🏽");
        System.out.println("2. An AI bot🤖");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Player playerO;
       //Press 1, name for the friend shows
        if (choice == 1) {
            // Create player O
            System.out.println("Enter name for player O: ");
            String playerOName = scanner.nextLine();
            playerO = new Player(playerOName, 'O');
        //Press 2, an Ai bot will challenge
        }else {
            playerO = new CPU('O');
        }
        //Return players
        return new Player[]{playerX, playerO};
    }
}