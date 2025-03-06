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
        }

    }
}
