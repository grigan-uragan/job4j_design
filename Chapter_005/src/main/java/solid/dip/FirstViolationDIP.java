package solid.dip;

import java.util.ArrayList;

public class FirstViolationDIP {
    private ArrayList<String> store;

    public FirstViolationDIP(ArrayList<String> store) {
        this.store = store;
    }
}
