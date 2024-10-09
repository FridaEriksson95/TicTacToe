public class CheckWinner {
    /**
     * Checks if specific player has won the game by controlling each winner combinations(row, col,diagnoal)
     * @param board
     * @param player
     * @return true if specified player has three symbols in a row, otherwise false
     */
    public boolean winnerCheck(char[][] board, char player) {
        //rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        //columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        //diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the board is full, if a cell is occupied or empty
     * @param board my 2D array gameboard
     * @return true if board is full
     */
    public boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}