package tictactoe;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TicTacToeRuleTest {

    @Test
    public void whenTurnEvenThenReturnSamePlayers() {
        Rule rule = new TicTacToeRule();
        List<Player> players = List.of(new TicTacToePlayer("X"), new TicTacToePlayer("O"));
        Player first = rule.playSequence(players, 0);
        Player second = rule.playSequence(players, 2);
        assertThat(true, is(first.equals(second)));
    }

    @Test
    public void whenTurnDifferenceThenReturnAnotherPlayers() {
        Rule rule = new TicTacToeRule();
        List<Player> players = List.of(new TicTacToePlayer("X"), new TicTacToePlayer("O"));
        Player first = rule.playSequence(players, 1);
        Player second = rule.playSequence(players, 2);
        assertThat(false, is(first.equals(second)));
    }

    @Test
    public void whenCallPlaySequenceTwiceThenReturnSamePlayer() {
        Rule rule = new TicTacToeRule();
        List<Player> players = List.of(new TicTacToePlayer("X"), new TicTacToePlayer("O"));
        Player first = rule.playSequence(players, 3);
        Player second = rule.playSequence(players, 3);
        assertThat(true, is(first.equals(second)));
    }

    @Test
    public void whenPlayerWinThenReturnTrue() {
        Chip[][] field = Chip.initGame();
        Rule rule = new TicTacToeRule();
        Player player = new TicTacToePlayer("X");
        player.makeMove(field, Cell.ONE);
        player.makeMove(field, Cell.TWO);
        player.makeMove(field, Cell.THREE);
        assertThat(true, is(rule.validate(player)));
    }

    @Test
    public void whenPlayerNoWinThenReturnFalse() {
        Chip[][] field = Chip.initGame();
        Rule rule = new TicTacToeRule();
        Player player = new TicTacToePlayer("X");
        player.makeMove(field, Cell.ONE);
        player.makeMove(field, Cell.TWO);
        player.makeMove(field, Cell.FOUR);
        assertThat(false, is(rule.validate(player)));
    }

    @Test
    public void whenPlayerMoveManyTimesThenReturnTrue() {
        Chip[][] field = Chip.initGame();
        Rule rule = new TicTacToeRule();
        Player player = new TicTacToePlayer("X");
        player.makeMove(field, Cell.ONE);
        player.makeMove(field, Cell.TWO);
        player.makeMove(field, Cell.FOUR);
        player.makeMove(field, Cell.SIX);
        player.makeMove(field, Cell.NINE);
        player.makeMove(field, Cell.EIGHT);
        assertThat(true, is(rule.validate(player)));
    }
}