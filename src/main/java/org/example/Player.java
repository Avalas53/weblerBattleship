package org.example;

public class Player {

    private String id;
    protected Fleet fleet;
    protected Board board;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player(String id) {
        this.id = id;
    }
}
