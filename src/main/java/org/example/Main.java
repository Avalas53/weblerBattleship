package org.example;

public class Main {
    public static void main(String[] args) {

        Board boardP1 = new Board("P1");
        // boardP1.boardDisplayer();
        // Board boardP2 = new Board("P2");

        boardP1.locateShip();
        //boardP2.locateShip();

        for (int i = 0; i < 5; i++) {
            boardP1.shooting();
        }

        boardP1.boardDisplayer();
        // boardP2.shooting();
    }
}