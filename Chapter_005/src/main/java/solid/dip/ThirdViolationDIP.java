package solid.dip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ThirdViolationDIP {
    private List<String> store;

    public ThirdViolationDIP(List<String> store) {
        this.store = store;
    }

    public HashSet<String> stringSet(ArrayList<String> list) {
        return new HashSet<>(list);
    }
}
