package org.example;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        // UserHelper helper = new UserHelper();
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Board player1Board = new Board();
        Board player2Board = new Board();

        System.out.println("Szabályok");

        player1.placeShip();
        player2.placeShip();

        do {
            player2Board.displayBoard();
            game.checkShot(player1.takeShot());
            player1Board.displayBoard();
            game.checkShot(player2.takeShot());
            game.hasSomebodyWin();
        } while (!game.hasSomebodyWin);
    }
}