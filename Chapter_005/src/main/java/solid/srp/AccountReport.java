package solid.srp;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;

public class AccountReport implements Report {
    private Store store;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public AccountReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        StringBuilder builder = new StringBuilder();
        employees.forEach(employee -> {
            builder.append(employee.getName() + " " + format.format(employee.getHired().getTime())
                    + " " + format.format(employee.getFired().getTime()) + " "
                    + employee.getSalary()
                    + " RUR" + System.lineSeparator());
        });
        return " name hired fired salary " + System.lineSeparator() + builder;
    }
}
