package tictactoe;

import java.util.List;

public interface Rule {
    boolean validate(Player player);

    Player playSequence(List<Player> players, int turn);
}
