package solid.srp;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FirstWrongSRP {
    private List<String> orders;

    public FirstWrongSRP(List<String> orders) {
        this.orders = orders;
    }

    public List<String> findOrders(Predicate<String> predicate) {
       return orders.stream().filter(predicate).collect(Collectors.toList());
    }

    public void printOrders(String order) {
        System.out.println(order);
    }
}
