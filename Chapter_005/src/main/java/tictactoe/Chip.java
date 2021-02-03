package tictactoe;

import java.util.Objects;

public class Chip {
    private String name;

    public Chip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Этот метод заполняет игровое поле номерами для удобства выбора клетки
     * @return двумерный массив с элементами имена которых соответсвуют номеру клетки
     */
    public static Chip[][] initGame() {
        Chip[][] result = new Chip[3][3];
        int count = 1;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = new Chip("" + count++);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Chip chip = (Chip) o;
        return Objects.equals(name, chip.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
