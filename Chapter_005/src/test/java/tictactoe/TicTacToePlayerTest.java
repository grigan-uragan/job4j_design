package tictactoe;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TicTacToePlayerTest {

    @Test
    public void whenMakeMoveOnTheFreeCellThenReturnTrue() {
        Chip[][] field = Chip.initGame();
        Player player = new TicTacToePlayer("X");
        assertThat(true, is(player.makeMove(field, Cell.FIVE)));
    }

    @Test
    public void whenMakeMoveOnTheCellThenCellRecord() {
        Cell cell = Cell.EIGHT;
        Chip[][] field = Chip.initGame();
        Player player = new TicTacToePlayer("X");
        player.makeMove(field, cell);
        assertThat(cell, is(player.getTurnRecords().get(0)));
    }
}