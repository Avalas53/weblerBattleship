package org.example;

public class Cell {
    private boolean hasShip;
    private boolean isShot;

    public Cell() {
        this.hasShip = false;
        this.isShot = false;
    }

    public char getStatus() {
        if (isShot) {
            if (hasShip) {
                return 'X'; // Talált
            } else {
                return 'O'; // Nem talált
            }
        } else {
            return '~'; // Ismeretlen
        }
    }

    public boolean hasShip() {
        return hasShip;
    }

    public void setShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public boolean isShot() {
        return isShot;
    }

    public boolean shoot() {
        isShot = true;
        return hasShip;
    }
}
