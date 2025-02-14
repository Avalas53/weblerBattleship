package org.example;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("PlayerOne");
        Player player2 = new Player("PlayerTwo");
        Board boardP1 = new Board(player1);
        Board boardP2 = new Board(player2);

        //locateShip(boardP1);
        //locateShip(boardP2);
        Shot.shotPlace(boardP1);
        Board.boardDisplay(boardP1);
        //shooting(boardP2);
        //boardDisplayer(boardP2);
        //hasSomebodyWin(boardP1, boardP2);

        //boardDisplayer(boardP1);
        //shooting(boardP1);
        //boardDisplayer(boardP1);
        //hasSomebodyWin(boardP1, boardP2);

    }
}