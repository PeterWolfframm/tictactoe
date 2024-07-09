package org.example;

import java.util.InputMismatchException;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe(){
        player1 = new Player('❌');
        player2 = new Player('◯');
        currentPlayer = player1;
        board = new Board();
    }
    public void start() {
        board.clear();
        boolean gameOn = true;

        while (gameOn) {
            board.print();

                int reihe = getUserInput("Reihe eingeben (0,1,2)");
                int spalte = getUserInput("Spalte eingeben (0,1,2)");

                if (board.isCellEmpty(reihe, spalte)) {
                    board.place(reihe, spalte, currentPlayer.getZeichen());
                    if (hasWinner()) {
                        board.print();
                        System.out.println("Spieler " + currentPlayer.getZeichen() + " hat gewonnen!");
                        gameOn = false;
                    } else if (board.isFull()) {
                        board.print();
                        System.out.println("Unentschieden!");
                        gameOn = false;
                    } else {
                        System.out.println("____________________________");
                        switchCurrentPlayer();
                    }
                } else {
                    System.out.println("Zelle nicht benutzbar");
                }

        }
    }
    private int getUserInput(String message) {
        System.out.print(message);
        return new java.util.Scanner(System.in).nextInt();
    }
    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    private boolean hasWinner() {
        char position = currentPlayer.getZeichen();
        return (checkRows(position) || checkColumns(position) || checkDiagonals(position));
    }

    private boolean checkRows(char position) {
        for (int i = 0; i < 3; i++) {
            if (!board.isCellEmpty(i, 0) && !board.isCellEmpty(i, 1) && !board.isCellEmpty(i, 2)
                    && board.getCell(i, 0) == position && board.getCell(i, 1) == position && board.getCell(i, 2) == position) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char position) {
        for (int i = 0; i < 3; i++) {
            if (!board.isCellEmpty(0, i) && !board.isCellEmpty(1, i) && !board.isCellEmpty(2, i)
                    && board.getCell(0, i) == position && board.getCell(1, i) == position && board.getCell(2, i) == position) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char zeichen) {
        return (!board.isCellEmpty(0, 0) && !board.isCellEmpty(1, 1) && !board.isCellEmpty(2, 2)
                && board.getCell(0, 0) == zeichen && board.getCell(1, 1) == zeichen && board.getCell(2, 2) == zeichen)
                || (!board.isCellEmpty(0, 2) && !board.isCellEmpty(1, 1) && !board.isCellEmpty(2, 0)
                && board.getCell(0, 2) == zeichen && board.getCell(1, 1) == zeichen && board.getCell(2, 0) == zeichen);
    }
}
