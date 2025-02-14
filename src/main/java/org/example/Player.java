package org.example;

public class Player {
    String id;
    Board board;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player (String id) {
        this.id = id;
    }

    public boolean hasSomebodyWin() {
        boolean win = false;
        return win;
    }
}
