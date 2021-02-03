package tictactoe;

import java.util.List;

public class TicTacToeRule implements Rule {
    /**
     * Список всех победных комбинаций
     */
    private static final List<List<Cell>> COMBINATIONS =
            List.of(List.of(Cell.ONE, Cell.TWO, Cell.THREE),
                    List.of(Cell.ONE, Cell.FOUR, Cell.SEVEN),
                    List.of(Cell.TWO, Cell.FIVE, Cell.EIGHT),
                    List.of(Cell.THREE, Cell.SIX, Cell.NINE),
                    List.of(Cell.ONE, Cell.FIVE, Cell.NINE),
                    List.of(Cell.THREE, Cell.FIVE, Cell.SEVEN),
                    List.of(Cell.FOUR, Cell.FIVE, Cell.SIX),
                    List.of(Cell.SEVEN, Cell.EIGHT, Cell.NINE));

    @Override
    public boolean validate(Player player) {
        List<Cell> playerList = player.getTurnRecords();
        if (playerList.size() >= 5) {
            System.out.println("Friendship");
            return true;
        } else if (playerList.size() > 2) {
            for (List<Cell> wins: COMBINATIONS) {
                if (playerList.containsAll(wins)) {
                    System.out.println("Player " + player + " win!");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Player playSequence(List<Player> players, int turn) {
        return players.get(turn % players.size());
    }
}
