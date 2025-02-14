package org.example;

public class Shot {

    protected static void shotPlace(Board board) {
        for (int i = 0; i < board.BOARDSIZE; i++) {
            board.board[i] = '.';
        }
    }

}


