package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private static final int BOARD_SIZE = 6;
    private List<Cell> cells;

    public Board() {
        cells = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i++) {
            cells.add(new Cell());
            // System.out.println(getCell(i, i));
        }
    }

    public char getCell(int row, int col) {
        return cells.get(row * BOARD_SIZE + col).getStatus();
    }

    public boolean isShot(int row, int col) {
        return cells.get(row * BOARD_SIZE + col).isShot();
    }

    public boolean shoot(int row, int col) {
        return cells.get(row * BOARD_SIZE + col).shoot();
    }

    public boolean placeShip(int startRow, int startCol, int shipSize, char direction) {
        int endRow = startRow;
        int endCol = startCol;

        switch (direction) {
            case 'f':
                endRow += shipSize - 1;
                break;
            case 'l':
                endCol -= shipSize - 1;
                break;
            case 'j':
                endRow -= shipSize - 1;
                break;
            case 'b':
                endCol += shipSize - 1;
                break;
            default:
                return false;
        }

        if (endRow < 0 || endRow >= BOARD_SIZE || endCol < 0 || endCol >= BOARD_SIZE) {
            return false;
        }

        for (int i = 0; i < shipSize; i++) {
            int row, col;
            switch (direction) {
                case 'f':
                    row = startRow + i;
                    col = startCol;
                    break;
                case 'l':
                    row = startRow;
                    col = startCol - i;
                    break;
                case 'j':
                    row = startRow - i;
                    col = startCol;
                    break;
                case 'b':
                    row = startRow;
                    col = startCol + i;
                    break;
                default:
                    return false;
            }
            if (cells.get(row * BOARD_SIZE + col).hasShip()) {
                return false;
            }
        }

        for (int i = 0; i < shipSize; i++) {
            int row, col;
            switch (direction) {
                case 'f':
                    row = startRow + i;
                    col = startCol;
                    break;
                case 'l':
                    row = startRow;
                    col = startCol - i;
                    break;
                case 'j':
                    row = startRow - i;
                    col = startCol;
                    break;
                case 'b':
                    row = startRow;
                    col = startCol + i;
                    break;
                default:
                    return false;
            }
            cells.get(row * BOARD_SIZE + col).setShip(true);
        }
        return true;
    }

    public boolean allShipsSunk() {
        for (Cell cell : cells) {
            if (cell.hasShip() && !cell.isShot()) {
                return false;
            }
        }
        return true;
    }
}
