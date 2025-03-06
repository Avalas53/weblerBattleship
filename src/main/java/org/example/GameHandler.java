package org.example;

import java.util.Scanner;

public class GameHandler {

    private static final int BOARD_SIZE = 6;
    private static final int SHIP_3_SIZE = 3;
    private static final int SHIP_2_SIZE = 2;
    private static final int SHIP_1_SIZE = 1;
    private static final int NUM_SHIP_2 = 2;
    private static final int NUM_SHIP_1 = 2;

    private Player player1;
    private Player player2;
    private Player onePlayer;
    private Player otherPlayer;

    public GameHandler() {
        player1 = new Player("player1");
        player2 = new Player("player2");
        onePlayer = player1;
        otherPlayer = player2;
    }

    public void handleGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("player1 hajói:");
        placeShips(player1, scanner);

        System.out.println("player2 hajói:");
        placeShips(player2, scanner);

        while (true) {
            System.out.println("Te jössz, " + onePlayer.getName());
            printBoard(otherPlayer.getBoard());

            int row, col;
            while (true) {
                System.out.print("Add meg a sor számát (1-" + BOARD_SIZE + "): ");
                row = scanner.nextInt() - 1;
                System.out.print("Add meg az oszlop számát (1-" + BOARD_SIZE + "): ");
                col = scanner.nextInt() - 1;

                if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
                    System.out.println("Nem OK koordináták! Próbáld újra.");
                } else if (otherPlayer.getBoard().isShot(row, col)) {
                    System.out.println("Ide már lőttél. Próbáld újra.");
                } else {
                    break;
                }
            }

            boolean hit = otherPlayer.getBoard().shoot(row, col);

            if (hit) {
                System.out.println("Talált!");
                if (otherPlayer.getBoard().allShipsSunk()) {
                    System.out.println(onePlayer.getName() + " nyert!");
                    break;
                }
            } else {
                System.out.println("Nem talált!");
            }

            switchPlayers();
        }

        scanner.close();
    }

    private void placeShips(Player player, Scanner scanner) {
        placeShip(player, scanner, SHIP_3_SIZE, 1);
        for (int i = 0; i < NUM_SHIP_2; i++) {
            placeShip(player, scanner, SHIP_2_SIZE, i + 1);
        }
        for (int i = 0; i < NUM_SHIP_1; i++) {
            placeShip(player, scanner, SHIP_1_SIZE, i + 1);
        }
    }

    private void placeShip(Player player, Scanner scanner, int shipSize, int shipNum) {
        while (true) {
            System.out.println(player.getName() + " helyezd el a(z) " + shipNum + ". hajód (" + shipSize + " hosszú):");
            System.out.print("Add meg a kezdő sor számát (1-" + BOARD_SIZE + "): ");
            int startRow = scanner.nextInt() - 1;
            System.out.print("Add meg a kezdő oszlop számát (1-" + BOARD_SIZE + "): ");
            int startCol = scanner.nextInt() - 1;
            System.out.print("Add meg az irányt (f/l/j/b): ");
            char direction = scanner.next().charAt(0);

            if (player.getBoard().placeShip(startRow, startCol, shipSize, direction)) {
                break;
            } else {
                System.out.println("Érvénytelen! Próbáld újra.");
            }
        }
        printBoard(player.getBoard());
    }

    private void printBoard(Board board) {
        System.out.print("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                char cell = board.getCell(i, j);
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private void switchPlayers() {
        Player temp = onePlayer;
        onePlayer = otherPlayer;
        otherPlayer = temp;
    }
}
