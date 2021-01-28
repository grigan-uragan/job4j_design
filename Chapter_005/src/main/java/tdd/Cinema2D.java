package tdd;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Cinema2D implements Cinema {

    private List<Session> sessions = new ArrayList<>();
    private Set<Ticket> tickets = new HashSet<>();

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        Ticket ticket = new ETicket(date, row, column);
        boolean isValid = tickets.add(ticket);
        if (!isValid) {
            throw new IllegalStateException("Ticket was sold, try change row or column");
        }
        return ticket;
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
