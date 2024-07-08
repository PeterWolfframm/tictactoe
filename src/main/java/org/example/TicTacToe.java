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
            gameOn = false;

        }
    }

}
