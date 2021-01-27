package tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface Cinema {

    Ticket buy(Account account, int row, int column, Calendar date);

    List<Session> find(Predicate<Session> filter);

    void add(Session session);
}
