package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private Player player;
    protected static final int BOARDSIZE = 10;
    protected char[] board = new char[BOARDSIZE];


    public Board (Player player) {
         this.player = player;

    }

    protected static void boardDisplay(Board board) {
        for (int i = 0; i < BOARDSIZE; i++) {
            System.out.print(board.board[i]);
        }
    }

}