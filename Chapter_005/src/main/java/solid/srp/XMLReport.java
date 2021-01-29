package solid.srp;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class XMLReport implements Report {

    private List<Employee> employees;
    private String pattern = "<employee name = %s salary = %s>" + System.lineSeparator()
            + "<hired> %s </hired>" + System.lineSeparator()
            + "<fired> %s </fired>" + System.lineSeparator()
            + "</employee>" + System.lineSeparator();

    public XMLReport(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> result = employees.stream()
                .filter(filter)
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version='1.0' encoding='UTF-8'?>");
        result.forEach(employee -> builder.append(String.format(pattern, employee.getName(),
                employee.getSalary(), employee.getHired(), employee.getFired())));
        return builder.toString();
    }
}
