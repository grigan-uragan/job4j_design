package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToePlayer  implements Player {
    private String name;
    private List<Cell> cellList = new ArrayList<>();

    public TicTacToePlayer(String name) {
        this.name = name;
    }

    public boolean makeMove(Chip[][] field, Cell cell) {
        if (cell != null) {
            cellList.add(cell);
            field[cell.getX()][cell.getY()] = new Chip(name);
            return true;
        }
        return false;
    }

    public List<Cell> getTurnRecords() {
        return cellList;
    }

    @Override
    public String toString() {
        return "Player " + name;
    }

}
