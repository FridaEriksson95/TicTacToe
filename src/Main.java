/*
steg 1. Göra en spelplan.
steg 2. Fixa två spelare som får skriva in sina namn, spelare x och spelare o
steg 3. Få spelarna att kunna välja en siffra mellan 1-9 att placera på spelplanen
steg 4: Göra en metod så att spelarna inte kan välja samma siffra
steg 5. Göra en klass med en metod som kollar om någon spelare vunnit
Steg 6. Skriv ut vem som vunnit eller om det blivit oavgjort.
steg 7. Fråga om spelarna vill spela igen efter avslutat spel eller avsluta.
steg 8. Gör en resultaträknare.
steg 9. Få så lite kod som möjligt i main och flytta resten till andra klasser.
steg 10. Få allt att skrivas ut snyggt på brädan och fånga upp alla fel som kan bli.
steg 11. Gå igenom koden och kolla om det är något som inte används/överflödigt.
steg 12. Kontrollera kommentarer och snygga till.
steg 13. Testkör, testkör, testkör för att hitta alla olika fel som kan komma.
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean playAgain = true;

        GameBoard game = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        game.setupPlayers(scanner);

        while (playAgain) {
            game.startGame(scanner);

            playAgain = menu.ifPlayAgain();
        }
    }
}