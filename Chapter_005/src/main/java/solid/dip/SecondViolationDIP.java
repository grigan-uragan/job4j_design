package solid.dip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SecondViolationDIP {
    List<String> store = new ArrayList<>();

    public SecondViolationDIP() {
    }

    public List<String> getStore() {
        return store;
    }

    public void setStore(List<String> store) {
        this.store = store;
    }
}
