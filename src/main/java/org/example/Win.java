package org.example;

public class Win {

    boolean end;

    public static boolean hasSomebodyWin (Board board1, Board board2) {
        for (int item : board1.shipCoordinates) {
            boolean found = false;
            for (int item2 : board1.hits) {
                if (item == item2) {
                    found = true;
                    System.out.println(board2.getId() + " Nyertél!");
                }
            }
            if (!found) {
                return false;
            }
        } return true;
    }
}
