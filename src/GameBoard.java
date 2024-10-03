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
}
