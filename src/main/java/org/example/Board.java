package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    String id;
    private static final int BOARDSIZE = 10;
    char[][] board = new char[BOARDSIZE][BOARDSIZE];
    private int[] shotCells = new int[(BOARDSIZE * BOARDSIZE)];
    private int shotCellsCounter = 0;
    private int[] shipCoordinates = new int[5];

    public String getId() {
        return id;
    }

    public int getSize() {
        return BOARDSIZE;
    }

    public Board (String id) {
        this.id = id;
    }

    public void boardDisplayer (Board board){
        for (int i = 0; i < BOARDSIZE; i++) {
            for (int j = 0; j < BOARDSIZE; j++) {
               board.board[i][j] = '.';
            }
        }
        System.out.println(getId());
        System.out.print(" ");
        for (int i = 0; i < BOARDSIZE; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < BOARDSIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < BOARDSIZE; j++) {
                System.out.print(board.board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void shooting(Board board) {
        Scanner scanner = new Scanner(System.in);
        boolean alreadyShot;

        do {
            alreadyShot = false;
            System.out.print("Célozz! (Add meg a koordinátát sor+oszlop formátumban)!: ");
            int shot = scanner.nextInt();

            for (int i = 0; i < board.shotCells.length; i++) {
                if (board.shotCells[i] == shot) {
                    System.out.println("Ide már lőttél korábban; válassz új célpontot!");
                    alreadyShot = true;
                    break;
                }
            }

            if (!alreadyShot) {
                board.shotCells[board.shotCellsCounter] = shot;
                board.shotCellsCounter++;
            }
        } while (alreadyShot);
    }

    public void locateShip(Board board) {
        int shipCoordCounter = 0;
        for (int i = 0; i < board.shipCoordinates.length; i++) {

            Scanner scanner = new Scanner(System.in);
            boolean alreadyUsed;

            do {
                alreadyUsed = false;
                System.out.print(getId() + " hajó koordináta: ");
                int shot = scanner.nextInt();

                for (int j = 0; j < board.shipCoordinates.length; j++) {
                    if (board.shipCoordinates[j] == shot) {
                        System.out.println("Itt már van hajó.");
                        alreadyUsed = true;
                        break;
                    }
                }

                if (!alreadyUsed) {
                    board.shipCoordinates[shipCoordCounter] = shot;
                    shipCoordCounter++;
                }
            } while (alreadyUsed);
        }
        System.out.println("Itt vannak a hajóid: " + Arrays.toString(board.shipCoordinates));
    }
}
