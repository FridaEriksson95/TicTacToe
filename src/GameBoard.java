public class GameBoard {

    char[][] Board = {{' ', ' ', ' '},
                      {' ', ' ', ' '},
                      {' ', ' ', ' '}};

    public GameBoard() {

    }

    public void printBoard() {
        System.out.println(Board[0][0] + "|" + Board[0][1] + "|" + Board[0][2]);
        System.out.println("-----");
        System.out.println(Board[1][0] + "|" + Board[1][1] + "|" + Board[1][2]);
        System.out.println("-----");
        System.out.println(Board[2][0] + "|" + Board[2][1] + "|" + Board[2][2]);
    }

    public boolean updateBoard(int position, char symbol) {
        switch(position) {
            case 1:
                return placeMove(0, 0, symbol);
            case 2:
                return placeMove(0, 1, symbol);
            case 3:
                return placeMove(0, 2, symbol);
            case 4:
                return placeMove(1, 0, symbol);
            case 5:
                return placeMove(1, 1, symbol);
            case 6:
                return placeMove(1, 2, symbol);
            case 7:
                return placeMove(2, 0, symbol);
            case 8:
                return placeMove(2, 1, symbol);
            case 9:
                return placeMove(2, 2, symbol);
            default:
                System.out.println("Invalid move. Please choose a number between 1-9.");
                return false;
        }
    }

    private boolean placeMove(int row, int col, char symbol) {
        if (Board[row][col] == ' ') {
            Board[row][col] = symbol;
            return true;
        } else {
            System.out.println("That spot is already taken, choose another!");
            return false;
        }
    }
}

