package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private Player player;
    protected static final int BOARDSIZE = 10;
    protected static char[][] board = new char[BOARDSIZE][BOARDSIZE];


    public Board (Player player) {
         this.player = player;

    }

    protected static void boardDisplay(Player player) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}