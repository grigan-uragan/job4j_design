package solid.srp;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReportTest {

    private Store store;
    private String htmlPattern;

    @Before
    public void setup() {
        Calendar hiredDate = Calendar.getInstance();
        hiredDate.set(2021, Calendar.JANUARY, 21);
        Calendar firedDate = Calendar.getInstance();
        firedDate.set(2021, Calendar.JULY, 21);
        htmlPattern = "<html> "
                + "<body>"
                + "<table>" + System.lineSeparator()
                + "<tr><td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td>"
                + "<tr><td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td>"
                + System.lineSeparator()
                + "</table>"
                + " </body>"
                + "</html>";
        store = new MemStore();
        store.add(new Employee("Bob", hiredDate, firedDate, 100d));
        store.add(new Employee("Tom", hiredDate, firedDate, 90d));
    }

    @Test
    public void shouldReturnReportForProgrammers() {
        String expected = String.format(htmlPattern,
                "name", "hired", "fired", "salary", "Bob", "2021-01-21", "2021-07-21", 100d);
        Report report = new HTMLReport(store);
        String result = report.generate(employee -> employee.getName().equals("Bob"));
        assertThat(result, is(expected));
    }

    @Test
    public void shouldReturnReportForHR() {
        String expected = String.format("name salary " + System.lineSeparator()
                + "%s" + " %s"
                + System.lineSeparator()
                + "%s" + " %s"
                + System.lineSeparator(), "Bob", 100d, "Tom", 90d);
        Report report = new HRReport(store);
        String result = report.generate(employee -> true);
        assertThat(expected, is(result));
    }

    @Test
    public void shouldReturnReportForAccounting() {
        String expected = " name hired fired salary "
                + System.lineSeparator() + "Bob 2021-01-21 2021-07-21 " + 100d + " RUR"
                + System.lineSeparator();
        Report report = new AccountReport(store);
        assertThat(expected, is(report.generate(employee -> employee.getName().equals("Bob"))));
    }
}