package org.example;

public class Board {

    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j]);
                if (j < 2) {
                    System.out.print("I");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-----");
            }
        }
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void place(int x, int y, char zeichen) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = zeichen;
        }
    }

    public char getCell(int x, int y) {
        return cells[x][y];
    }




}
