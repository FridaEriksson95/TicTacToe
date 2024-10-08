import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private int wins;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getWins() {
        return wins;
    }

//    public void incrementWins() {
//        this.wins++;
//    }
    public void setWins(Player opponent) {
        this.wins++;
        System.out.println(getName() + " wins the game and has a score of: " + getWins());
        System.out.println("The scoreboard is now: ");
        System.out.println(getName() +  ": " + getWins() + " " + opponent.getName() + ": " + opponent.getWins());
        System.out.println(" ");
    }

    public static Player createPlayer(Scanner scanner, char symbol) {
        System.out.println("Enter name for player " + symbol + ": ");
        String playerName = scanner.nextLine();
        return new Player(playerName, symbol);
    }
    /**
     *
     * @param game
     * @param scanner
     */
    public void makeMove(GameBoard game, Scanner scanner) {
        boolean validMove;
        do {
            System.out.println("Where would " + getName()  + " like to play their " + getSymbol() + " (1-9)?");
            int move = scanner.nextInt();
            validMove = game.updateBoard(move, getSymbol());
            System.out.println(" ");
        } while (!validMove);
    }
}

