package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Game {
    private Chip[][] field;
    private List<Player> players;
    private Mark<Chip> print;
    private Rule rule;
    private List<Cell> cells = Cell.startGame();
    private boolean isOver;

    public Game(Chip[][] field, List<Player> players, Rule rule, Mark<Chip> print) {
        this.field = field;
        this.players = players;
        this.rule = rule;
        this.print = print;
    }

    public void playGame(InputStream inputStream) throws IOException {
        isOver = false;
        int turn = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            while (!isOver) {
                print.print(field);
                Player player = rule.playSequence(players, turn);
                System.out.println("Please " + player + " chose you cell number");
                String answer = reader.readLine();
                int cell = 0;
                try {
                    cell = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter number only");
                }
                Cell result = null;
                for (Cell c : cells) {
                    if (cell == c.ordinal() + 1) {
                        result = c;
                    }
                }
                if (player == null || !player.makeMove(field, result)) {
                    System.out.println("please " + player + " try again");
                } else {

                    cells.remove(result);
                    turn++;
                }
                isOver = rule.validate(player);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game(Chip.initGame(),
                List.of(new TicTacToePlayer("X"), new TicTacToePlayer("O")),
                new TicTacToeRule(), new ChipPrint());
        game.playGame(System.in);
    }
}
