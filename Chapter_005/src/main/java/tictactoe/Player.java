package tictactoe;

import java.util.List;

public interface Player {
    boolean makeMove(Chip[][] field, Cell cell);

    List<Cell> getTurnRecords();
}
