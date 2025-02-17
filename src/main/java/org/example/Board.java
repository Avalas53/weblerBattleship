package org.example;

public class Board {

    Player player;
    protected final int BOARD_SIZE = 6;
    protected char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    public Board(Player player) {
        this.player = player;
    }

    protected void boardDisplay(Board board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board.board[i][j] = '.';
            }
        }
    }
}
