package tictactoe;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ChipTest {

    @Test
    public void whenChipInitGameThenOk() {
        Chip[][] expected = new Chip[][]{
                new Chip[]{new Chip("1"), new Chip("2"), new Chip("3")},
                new Chip[]{new Chip("4"), new Chip("5"), new Chip("6")},
                new Chip[]{new Chip("7"), new Chip("8"), new Chip("9")}
        };
        assertThat(expected, is(Chip.initGame()));
    }

}