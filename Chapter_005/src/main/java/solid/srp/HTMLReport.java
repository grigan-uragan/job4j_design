package solid.srp;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;

public class HTMLReport implements Report {
    private Store store;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private final String pattern = "<tr><td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td>";

    public HTMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> result = store.findBy(filter);
        StringBuilder builder = new StringBuilder();
        result.stream().forEach(employee -> {
            builder.append(String.format(pattern, employee.getName(),
                    format.format(employee.getHired().getTime()),
                    format.format(employee.getFired().getTime()),
                    employee.getSalary()) + System.lineSeparator());
        });
        return "<html> "
                + "<body>"
                + "<table>" + System.lineSeparator()
                + "<tr><td>name</td> <td>hired</td> <td>fired</td> <td>salary</td>"
                + builder.toString()
                + "</table>"
                + " </body>"
                + "</html>";
    }
}
