import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameBoard game = new GameBoard();
        game.printBoard();


        System.out.println("Where would you like to play? (1-9)");

        String user1 = scanner.nextLine();
        System.out.println(user1);
    }
}