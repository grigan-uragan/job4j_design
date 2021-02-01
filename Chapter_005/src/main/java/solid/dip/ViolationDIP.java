package solid.dip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ViolationDIP {
    private List<String> store = new ArrayList<>();
    private HashMap<String, String> map;

    public ViolationDIP(HashMap<String, String> map) {
        this.map = map;
    }

    public HashSet<String> strings(ArrayList<String> str) {
        return new HashSet<>(str);
    }
}
