import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;

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

    public void makeMove(GameBoard game, Scanner scanner) {
        boolean validMove;
        do {
            System.out.println("Where would " + getName() + " like to play? (1-9)");
            int move = scanner.nextInt();
            validMove = game.updateBoard(move, getSymbol());
        } while (!validMove);
    }
}

