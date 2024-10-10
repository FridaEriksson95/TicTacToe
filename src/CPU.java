import java.util.Random;
//My Ai player that extends from my player class
public class CPU extends Player {

    public CPU(char symbol) {
        super("AI", symbol);
    }

    //Method for the Ai to make a random move between 1-9
    public int chooseMove(GameBoard board) {
        Random rand = new Random();
        int move;
        do {
            move = rand.nextInt(9) + 1;
        } while (!board.updateBoard(move, getSymbol()));
        return move;
    }
}
