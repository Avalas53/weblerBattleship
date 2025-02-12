package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    String id;
    private static final int BOARDSIZE = 10;
    private static int[] shotCells = new int[(BOARDSIZE * BOARDSIZE)];
    private static int shotCellsCounter = 0;
    private static int[] shipCoordinates = new int[10];

    public String getId() {
        return id;
    }

    public int getSize() {
        return BOARDSIZE;
    }

    public Board (String id) {
        this.id = getId();
    }

    public void boardDisplayer (){
        System.out.print("  ");
        for (int i = 0; i < BOARDSIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int row = 0; row < BOARDSIZE; row++) {
            System.out.print(row + " ");
            for (int i = 0; i < BOARDSIZE; i++) {
                boolean isShot = false;
                for (int cell : shotCells) {
                    if (cell == row * BOARDSIZE + i) {
                        isShot = true;
                        break;
                    }
                }
                if (isShot) {
                    System.out.print("- ");
                } else {
                    System.out.print("| ");
                }
            }
            System.out.println();
        }
        // TODO hit
    }

    public static void shooting() {
        Scanner scanner = new Scanner(System.in);
        boolean alreadyShot;

        do {
            alreadyShot = false;
            System.out.print("koordináta: ");
            int shot = scanner.nextInt();

            for (int i = 0; i < shotCells.length; i++) {
                if (shotCells[i] == shot) {
                    System.out.println("ide már lőttél");
                    alreadyShot = true;
                    break;
                }
            }

            if (!alreadyShot) {
                shotCells[shotCellsCounter] = shot;
                shotCellsCounter++;
            }
        } while (alreadyShot);

        //TODO talált?
        //TODO típus- és formátumellenőrzés
    }

    public void locateShip() {
        int shipCoordCounter = 0;
        for (int i = 0; i < shipCoordinates.length; i++) {

            Scanner scanner = new Scanner(System.in);
            boolean alreadyUsed;

            do {
                alreadyUsed = false;
                System.out.print("hajó koordináta: ");
                int shot = scanner.nextInt();

                for (int j = 0; j < shipCoordinates.length; j++) {
                    if (shipCoordinates[j] == shot) {
                        System.out.println("Itt már van hajó.");
                        alreadyUsed = true;
                        break;
                    }
                }

                if (!alreadyUsed) {
                    shipCoordinates[shipCoordCounter] = shot;
                    shipCoordCounter++;
                }
                System.out.println(Arrays.toString(shipCoordinates));
            } while (alreadyUsed);
        }

        //TODO típus- és formátumellenőrzés
        //TODO talált?
    }
}
