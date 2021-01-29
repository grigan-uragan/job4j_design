package solid.srp;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JSONReport implements Report {
    private List<Employee> employees;
    private String pattern = "{"
            + "\"name\":\"%s\", "
            + "\"hired\":{\"year\":%s, \"month\":%s, \"dayOfMonth\":%s},"
            + "\"fired\":{\"year\":%s, \"month\":%s, \"dayOfMonth\":%s},"
            + "\"salary\":%s, "
            + "}";

    public JSONReport(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> result = employees.stream()
                .filter(filter).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        result.forEach(employee -> {
            builder.append(String.format(pattern, employee.getName(),
                    employee.getHired().get(Calendar.YEAR),
                    employee.getHired().get(Calendar.MONTH),
                    employee.getHired().get(Calendar.DAY_OF_MONTH),
                    employee.getFired().get(Calendar.YEAR),
                    employee.getFired().get(Calendar.MONTH),
                    employee.getFired().get(Calendar.DAY_OF_MONTH),
                    employee.getSalary()
            ));
        });
        return builder.toString();
    }
}
