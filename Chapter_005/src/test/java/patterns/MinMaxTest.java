package patterns;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MinMaxTest {

    private MinMax minMax = new MinMax();
    private List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private List<Integer> negativeList = List.of(-1, -2, -3, -4, -5, -6, -7, -8, -9, -10);

    @Test
    public void shouldReturnMaxValue10() {
        Integer result = minMax.max(list, (x, y) -> y - x);
        assertThat(result, is(10));
    }

    @Test
    public void shouldReturnMinValue1() {
        Integer result = minMax.min(list, (x, y) -> y - x);
        assertThat(result, is(1));
    }

    @Test
    public void shouldReturnMaxValueMinusOne() {
        Integer result = minMax.max(negativeList, (x, y) -> y - x);
        assertThat(result, is(-1));
    }

    @Test
    public void shouldReturnMinValueMinusTen() {
        Integer result = minMax.min(negativeList, (x, y) -> y - x);
        assertThat(result, is(-10));
    }

}