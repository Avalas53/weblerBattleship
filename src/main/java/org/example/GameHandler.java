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
    private Player currentPlayer; //TODO rename
    private Player opponentPlayer; //TODO rename

    public GameHandler() {
        player1 = new Player("player1");
        player2 = new Player("player2");
        currentPlayer = player1;
        opponentPlayer = player2;
    }

    public void handleGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. játékos hajóinak elhelyezése:");
        placeShips(player1, scanner);

        System.out.println("\n2. játékos hajóinak elhelyezése:");
        placeShips(player2, scanner);

        while (true) {
            System.out.println(currentPlayer.getName() + " köre:");
            printBoard(opponentPlayer.getBoard());

            int row, col;
            while (true) {
                System.out.print("Adja meg a sor számát (1-" + BOARD_SIZE + "): ");
                row = scanner.nextInt() - 1;
                System.out.print("Adja meg az oszlop számát (1-" + BOARD_SIZE + "): ");
                col = scanner.nextInt() - 1;

                if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
                    System.out.println("Érvénytelen koordináták! Próbálja újra.");
                } else if (opponentPlayer.getBoard().isShot(row, col)) {
                    System.out.println("Ezt a cellát már lőtte! Próbálja újra.");
                } else {
                    break;
                }
            }

            boolean hit = opponentPlayer.getBoard().shoot(row, col);

            if (hit) {
                System.out.println("Talált!");
                if (opponentPlayer.getBoard().allShipsSunk()) {
                    System.out.println(currentPlayer.getName() + " nyert!");
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
            System.out.println(player.getName() + " helyezze el a(z) " + shipNum + ". hajóját (" + shipSize + " hosszú):");
            System.out.print("Adja meg a kezdő sor számát (1-" + BOARD_SIZE + "): ");
            int startRow = scanner.nextInt() - 1;
            System.out.print("Adja meg a kezdő oszlop számát (1-" + BOARD_SIZE + "): ");
            int startCol = scanner.nextInt() - 1;
            System.out.print("Adja meg az irányt (f/l/j/b): ");
            char direction = scanner.next().charAt(0);

            if (player.getBoard().placeShip(startRow, startCol, shipSize, direction)) {
                break;
            } else {
                System.out.println("Érvénytelen elhelyezés! Próbálja újra.");
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
        Player temp = currentPlayer;
        currentPlayer = opponentPlayer;
        opponentPlayer = temp;
    }
}
