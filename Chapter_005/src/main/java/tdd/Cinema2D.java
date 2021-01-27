package tdd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Cinema2D implements Cinema {

    private List<Session> sessions = new ArrayList<>();

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return new ETicket(date, row, column);
    }

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return sessions.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public void add(Session session) {
        sessions.add(session);
    }
}
