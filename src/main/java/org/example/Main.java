package org.example;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Board player1Board = new Board();
        Board player2Board = new Board();

        System.out.println("Szabályok");

        player1.placeShip();
        player2.placeShip();

        do {
            player2Board.displayBoard();
            Game.checkShot(player1.takeShot());
            player1Board.displayBoard();
            Game.checkShot(player2.takeShot());
            Game.hasSomebodyWin();
        } while (!Game.hasSomebodyWin);
    }
}