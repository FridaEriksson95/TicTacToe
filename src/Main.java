/*
steg 1. Göra en spelplan.
steg 2. Fixa två spelare som får skriva in sina namn, spelare x och spelare o
steg 3. Få spelarna att kunna välja en siffra mellan 1-9 att placera på spelplanen
steg 4: Göra en metod så att spelarna inte kan välja samma siffra
steg 5. Göra en klass med en metod som kollar om någon spelare vunnit
Steg 6. Skriv ut vem som vunnit eller om det blivit oavgjort.
steg 7. Fråga om spelarna vill spela igen efter avslutat spel eller avsluta.
steg 8. Gör en resultaträknadre.
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean playAgain = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe! Let's start the game❗️");
        Player playerX = Player.createPlayer(scanner, 'X');
        Player playerO = Player.createPlayer(scanner, 'O');

        while (playAgain) {
            playGame(playerX, playerO);

            int choice = menu.showMenu();
            playAgain = choice == 1;
            menu.handleMenuOption(choice);
        }
    }

    public static void playGame(Player playerX, Player playerO) {
        Scanner scanner = new Scanner(System.in);

        GameBoard game = new GameBoard();
        CheckWinner checkWinner = new CheckWinner();

        boolean gameOver = false;

        while (!gameOver) {
            System.out.println(" ");
            game.printBoard();

            playerX.makeMove(game, scanner);
            game.printBoard();
            System.out.println(" ");
            if (checkWinner.winnerCheck(game.getBoard(), playerX.getSymbol())) {
                playerX.setWins(playerO);
                gameOver = true;
            } else if (checkWinner.isBoardFull(game.getBoard())) {
                System.out.println("It's a tie!");
                gameOver = true;
            }

            if (gameOver) {
                break;
            }

            playerO.makeMove(game, scanner);
            game.printBoard();
            System.out.println(" ");
            if (checkWinner.winnerCheck(game.getBoard(), playerO.getSymbol())) {
                playerO.setWins(playerX);
                gameOver = true;
            } else if (checkWinner.isBoardFull(game.getBoard())) {
                System.out.println("It's a tie!");
                gameOver = true;
            }
        }
    }
}