package org.example;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe(){
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        boolean gameOn = true;

        while (gameOn) {
            board.print();

            // manuell testen ob es funktioniert

            int reihe = getUserInput("Reihe eingeben (0,1,2)");

            int spalte = getUserInput("Spalte eingeben (0,1,2)");

            char zeichen = 'x';

            if(board.isCellEmpty(reihe, spalte)){
                board.place(reihe, spalte, currentPlayer.getZeichen());
                switchCurrentPlayer();
            }
            else{
                System.out.println("Zelle nicht benutzbar");
            }

            board.place(reihe, spalte, zeichen);

            board.print();

            gameOn = false;


        }
    }

    private int getUserInput(String message) {
        System.out.print(message);
        return new java.util.Scanner(System.in).nextInt();
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
