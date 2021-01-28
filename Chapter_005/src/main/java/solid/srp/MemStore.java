package solid.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {
    private List<Employee> store = new ArrayList<>();

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return store.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public void add(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("employee can't be  null");
        }
        store.add(employee);
    }
}
