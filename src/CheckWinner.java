public class CheckWinner {

    private static boolean gameOver(char[][] Board) {
        if (playerXHasWon)(Board, 'X')) {
        printBoard(Board);
            System.out.println(playerX + "wins!");
            return true;
        }
        if(playerOHasWon)(Board, 'O')) {
            printBoard(Board);
            System.out.println(playerO + "wins!");
            return true;
        }
        for(int i = 0; i < Board.length; i++) {

        }
    }
}


// .toLowerCase