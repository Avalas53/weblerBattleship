package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Player {

    private String id;
    private Board board;
    protected int ownShipNumber = 9;
    private int[] ownShip = new int[ownShipNumber];
    protected int shotCoordinateCounter = 0;
    protected int[] shotCoordinates = new int[Board.BOARD_SIZE * Board.BOARD_SIZE];
    protected int hitCounter = 0;
    protected int[] hit = new int[ownShipNumber];

    public String getId() {
        return id;
    }

    public Player(String id) {
        this.id = id;
    }

    public void placeShip() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adj meg " + ownShipNumber + " koordinátát!");
        for (int i = 0; i < ownShipNumber; i++) {
            ownShip[i] = scanner.nextInt();
        }
        System.out.println("Ezek a hajóid koordinátái:");
        System.out.println(Arrays.toString(ownShip));
    }

    public int takeShot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Célozz! ");
        int shot = scanner.nextInt();
        return shot;
    }
}
