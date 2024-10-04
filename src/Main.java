/*
steg 1. Göra en spelplan.
steg 2. Fixa två spelare som får skriva in sina namn, spelare x och spelare o
steg 3. Få spelarna att kunna välja en siffra mellan 1-9 att placera på spelplanen
steg 4: Göra en metod så att spelarna inte kan välja samma siffra
steg 5. Göra en klass med en metod som kollar om någon spelar vunnit
 */

import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameBoard game = new GameBoard();
        CheckWinner checkWinner = new CheckWinner();

        System.out.println("Enter name for player X: ");
        String playerXName = scanner.nextLine();
        Player playerX = new Player(playerXName, 'X');
        System.out.println("Enter name for player O: ");
        String playerOName = scanner.nextLine();
        Player playerO = new Player(playerOName, 'O');

//TODO fixa så att spelarna kan välja att starta om spelet och köra igen
// TODO fixa resultaträknare

        boolean gameOver = false;

        while (!gameOver) {
            playerX.makeMove(game, scanner);
            game.printBoard();
            if (checkWinner.winnerCheck(game.getBoard(), playerX.getSymbol())) {
                System.out.println(playerX.getName() + " has defeated you " + playerO.getName() + "! Play Again? Y/N");
                gameOver = true;
                break;
            }
            playerO.makeMove(game, scanner);
            game.printBoard();
            if (checkWinner.winnerCheck(game.getBoard(), playerO.getSymbol())) {
                System.out.println(playerO.getName() + " has defeated you " + playerX.getName() + "! Play Again? Y/N");
                gameOver = true;
                break;
            }

        }
    }
}