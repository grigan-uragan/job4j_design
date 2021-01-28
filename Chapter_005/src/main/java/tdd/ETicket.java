package tdd;

import java.util.Calendar;
import java.util.Objects;

public class ETicket implements Ticket {
    private Calendar date;
    private int row;
    private int column;

    public ETicket(Calendar date, int row, int column) {
        if (row < 1 || column < 1) {
            throw new IllegalArgumentException("row and column should be more than 0");
        }
        this.date = date;
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ETicket eTicket = (ETicket) o;
        return row == eTicket.row && column == eTicket.column && Objects.equals(date, eTicket.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, row, column);
    }
}
