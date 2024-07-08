package org.example;

public class TicTacToe {

    private Board board;

    public TicTacToe(){
        board = new Board();
    }

    public void start() {
        board.clear();
        boolean gameOn = true;

        while (gameOn) {
            board.print();

            // manuell testen ob es funktioniert

            int reihe = 0;

            int spalte = 0;

            char zeichen = 'x';

            board.place(reihe, spalte, zeichen);

            board.print();

            gameOn = false;


        }
    }

}
