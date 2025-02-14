package org.example;

import java.util.Scanner;

public class Shot {

    ShotResult result;

    /* protected Shot(ShotResult result) {
        this.result = result;
    } */

    public void shooting(Board board, ShotResult result) {

            switch (result) {
                case BASE -> {
                    System.out.println("Nem talált.");
                    board.shotCells[board.shotCellCounter] = shot;
                    board.shotCellCounter++;
                }
                case USED -> {
                    System.out.println("Ide már lőttél korábban; válassz új célpontot!");
                    alreadyShot = true;
                }
                case HIT -> {
                    System.out.println("Talált!");
                    board.hits[board.hitCounter] = shot;
                    board.hitCounter++;
                }
            }
        } while (alreadyShot);
    }

    private ShotResult getShotResult(Board board) {

        for (int i = 0; i < board.shotCells.length; i++) {
            if (board.shotCells[i] == shot) {
                System.out.println("Ide már lőttél korábban; válassz új célpontot!");
                alreadyShot = true;
                break;
        return result;
    }
}

/*boolean alreadyShot;

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
                board.shotCells[board.shotCellCounter] = shot;
                board.shotCellCounter++;
            }
        } while (alreadyShot);*/
