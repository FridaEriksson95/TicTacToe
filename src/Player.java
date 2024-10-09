import java.util.Scanner;
//Player class
public class Player {
    //instancevariables for player
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
        System.out.println(getName() + " wins the game and has a score of: " + getWins());
        System.out.println("The scoreboard is now: ");
        System.out.println(getName() + ": " + getWins() + " " + opponent.getName() + ": " + opponent.getWins());
        System.out.println(" ");
    }

    //Welcoming to the game, player setup with symbols
    public static Player[] setupPlayers(Scanner scanner) {
        System.out.println("Welcome to TicTacToe! Let's start the game❗️");
        Player playerX = Player.createPlayer(scanner, 'X');
        Player playerO = Player.createPlayer(scanner, 'O');
        return new Player[]{playerX, playerO};
    }

    //Asking for the players name and returning their input to the game
    public static Player createPlayer(Scanner scanner, char symbol) {
        System.out.println("Enter name for player " + symbol + ": ");
        String playerName = scanner.nextLine();
        return new Player(playerName, symbol);
    }
}


