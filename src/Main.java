import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name for player X: ");
        String playerXName = scanner.nextLine();
        System.out.println("Enter name for player O: ");
        String playerOName = scanner.nextLine();

        Player playerX = new Player(playerXName);
        Player playerO = new Player(playerOName);

        GameBoard game = new GameBoard();
        game.printBoard();
//TODO Gör en while loop så att spelet startar om efter varje drag tills en vinnare utsetts eller det blivit tie
        boolean validMove;
        do {
            System.out.println("Where would " + playerX.getName() + " like to play? (1-9)");
            int player1Move = scanner.nextInt();
            validMove = game.updateBoard(player1Move, 'X');
        } while (!validMove);
        game.printBoard();

        do {
        System.out.println("Where would " + playerO.getName() + " like to play? (1-9)");
        int player2Move = scanner.nextInt();
            validMove = game.updateBoard(player2Move, 'O');
        } while (!validMove);
        game.printBoard();
    }
}