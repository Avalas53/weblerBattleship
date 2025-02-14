package org.example;

public class Main {
    public static void main(String[] args) {

        Board boardP1 = new Board("P1");
        Board boardP2 = new Board("P2");

        boardP1.locateShip(boardP1);
        boardP2.locateShip(boardP2);

        //boardP1.boardDisplayer(boardP2);
        //boardP1.shooting(boardP2);
        //boardP1.boardDisplayer(boardP2);
        Win.hasSomebodyWin(boardP1, boardP2);

        //boardP2.boardDisplayer(boardP1);
        //boardP2.shooting(boardP1);
        //boardP2.boardDisplayer(boardP1);
        Win.hasSomebodyWin(boardP1, boardP2);

    }
}