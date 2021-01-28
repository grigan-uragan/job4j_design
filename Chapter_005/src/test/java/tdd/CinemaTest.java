package tdd;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CinemaTest {

    @Test
    public void shouldBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema2D();
        Calendar date = Calendar.getInstance();
        date.set(2021, Calendar.FEBRUARY, 21);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new ETicket(date, 1, 1)));
    }

    @Test
    public void shouldFindSession() {
        Cinema cinema = new Cinema2D();
        cinema.add(new Session2D("Batman"));
        List<Session> result = cinema.find(session -> true);
        assertThat(result, is(List.of(new Session2D("Batman"))));
    }

    @Test
    public void shouldAddSession() {
        Cinema cinema = new Cinema2D();
        cinema.add(new Session2D("Resident Evil"));
        List<Session> result = cinema.find(session -> true);
        assertThat(result.size(), is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfRowFewerThanZero() {
        Cinema cinema = new Cinema2D();
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2021, Calendar.FEBRUARY, 1);
        Ticket ticket = cinema.buy(account, -1, 1, date);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfBuyTwinTicket() {
        Cinema cinema = new Cinema2D();
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2021, Calendar.FEBRUARY, 1);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Ticket twinTicket = cinema.buy(account, 1, 1, date);
    }

}