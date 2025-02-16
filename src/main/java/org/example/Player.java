package org.example;

import java.util.Scanner;

public class Player {
    String id;
    Board board;
    int [] ship = new int[20];
    int [] shot = new int[Board.BOARDSIZE*Board.BOARDSIZE];
    int [] hit = new int[ship.length];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player (String id) {
        this.id = id;
    }

    public boolean hasSomebodyWin() {
        boolean win = false;
        return win;
    }

    public int shot() {
        Scanner scanner = new Scanner(System.in);
        int shot = scanner.nextInt();
        //TODO használt, nem talált, talált
        return shot;
    }

    public int[] placeShips() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < ship.length; i++) {
            ship[i] = scanner.nextInt();
        }
        //TODO használt
        return shot;
    }
}
