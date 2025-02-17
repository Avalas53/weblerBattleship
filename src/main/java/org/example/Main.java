package org.example;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Board board1 = new Board(player1);
        Board board2 = new Board(player2);

        board1.boardDisplay();
        board2.boardDisplay();

        Game.shotResult(player1.takeShot());

        Game.shotResult(player2.takeShot());

        Game.hasSomebodyWin();

    }
}