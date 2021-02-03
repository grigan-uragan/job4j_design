package tictactoe;

import java.util.ArrayList;
import java.util.List;

public enum Cell {
    ONE(0, 0),
    TWO(0, 1),
    THREE(0, 2),
    FOUR(1, 0),
    FIVE(1, 1),
    SIX(1, 2),
    SEVEN(2, 0),
    EIGHT(2, 1),
    NINE(2, 2);
    private int x;
    private int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Этот метод используется перед стартом игры
     * @return список всех возможных ходов.
     */
    public static List<Cell> startGame() {
        return new ArrayList<>(List.of(Cell.ONE, Cell.TWO, Cell.THREE, Cell.FOUR,
                Cell.FIVE, Cell.SIX, Cell.SEVEN, Cell.EIGHT, Cell.NINE));
    }
}
