package solid.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HRReport implements Report {
    private Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        StringBuilder builder = new StringBuilder();
        employees.forEach(employee -> {
            builder.append(employee.getName() + " " + employee.getSalary()
                    + System.lineSeparator());
        });
        return "name salary " + System.lineSeparator() + builder;
    }
}
