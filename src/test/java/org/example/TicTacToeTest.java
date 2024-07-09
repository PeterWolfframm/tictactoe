package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private Board board;


    @BeforeEach
    public void setUp() {
        ticTacToe = new TicTacToe();
        playerX = new Player('❌');
        playerO = new Player('◯');
        board = new Board();

    }

    @Test
    public void testSwitchCurrentPlayer() {
        assertEquals('❌', ticTacToe.getCurrentPlayer().getZeichen());
        ticTacToe.switchCurrentPlayer();
        assertEquals('◯', ticTacToe.getCurrentPlayer().getZeichen());
        ticTacToe.switchCurrentPlayer();
        assertEquals('❌', ticTacToe.getCurrentPlayer().getZeichen());
    }

    @Test
    public void testHasWinnerRows() {
        Board board = new Board();
        ticTacToe.setBoard(board);
        board.place(0, 0, '❌');
        board.place(0, 1, '❌');
        board.place(0, 2, '❌');
        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    public void testHasWinnerColumns() {
        Board board = new Board();
        ticTacToe.setBoard(board);
        board.place(0, 0, '❌');
        board.place(1, 0, '❌');
        board.place(2, 0, '❌');
        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    public void testHasWinnerDiagonals() {
        Board board = new Board();
        ticTacToe.setBoard(board);
        board.place(0, 0, '❌');
        board.place(1, 1, '❌');
        board.place(2, 2, '❌');
        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    public void testNoWinner() {
        Board board = new Board();
        ticTacToe.setBoard(board);
        board.place(0, 0, '❌');
        board.place(0, 1, '❌');
        board.place(0, 2, '◯');
        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    public void testCheckRows() {
        Board board = new Board();
        ticTacToe.setBoard(board);
        board.place(1, 0, '❌');
        board.place(1, 1, '❌');
        board.place(1, 2, '❌');
        assertTrue(ticTacToe.checkRows('❌'));
        assertFalse(ticTacToe.checkRows('◯'));
    }

    @Test
    public void testCheckColumns() {
        Board board = new Board();
        ticTacToe.setBoard(board);
        board.place(0, 1, '❌');
        board.place(1, 1, '❌');
        board.place(2, 1, '❌');
        assertTrue(ticTacToe.checkColumns('❌'));
        assertFalse(ticTacToe.checkColumns('◯'));
    }

    @Test
    public void testCheckDiagonals() {
        Board board = new Board();
        ticTacToe.setBoard(board);
        board.place(0, 0, '❌');
        board.place(1, 1, '❌');
        board.place(2, 2, '❌');
        assertTrue(ticTacToe.checkDiagonals('❌'));
        board.clear();
        board.place(0, 2, '❌');
        board.place(1, 1, '❌');
        board.place(2, 0, '❌');
        assertTrue(ticTacToe.checkDiagonals('❌'));
    }

    private Player playerX;
    private Player playerO;

    @BeforeEach

    @Test
    public void testConstructor() {
        assertNotNull(playerX);
        assertNotNull(playerO);
    }

    @Test
    public void testGetZeichen() {
        assertEquals('❌', playerX.getZeichen());
        assertEquals('◯', playerO.getZeichen());
    }

    @Test
    public void testClear() {
        board.place(0, 0, '❌');
        board.clear();
        assertEquals(' ', board.getCell(0, 0));
        assertEquals(' ', board.getCell(1, 1));
    }

    @Test
    public void testIsCellEmpty() {
        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, '❌');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsFull() {
        assertFalse(board.isFull());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, '❌');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testPlace() {
        board.place(0, 0, '❌');
        assertEquals('❌', board.getCell(0, 0));
        board.place(0, 0, '◯'); // should not overwrite
        assertEquals('❌', board.getCell(0, 0));
    }

    @Test
    public void testGetCell() {
        board.place(1, 1, '❌');
        assertEquals('❌', board.getCell(1, 1));
        assertEquals(' ', board.getCell(0, 0));
    }

    @Test
    public void testPrint() {
        // This test will just call the method to ensure no exceptions
        board.print();
    }
}