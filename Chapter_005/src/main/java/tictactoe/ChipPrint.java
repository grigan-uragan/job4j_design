package tictactoe;

public class ChipPrint implements Mark<Chip> {

    @Override
    public void print(Chip[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
                if (j == field[i].length - 1) {
                    System.out.println();
                }
            }
        }
    }
}
