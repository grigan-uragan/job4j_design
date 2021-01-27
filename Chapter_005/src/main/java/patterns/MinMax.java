package patterns;

import java.util.Comparator;
import java.util.List;

public class MinMax {
    public <T> T max(List<T> list, Comparator<T> comparator) {
        T start = list.get(0);
        for (T element : list) {
           int res = comparator.compare(start, element);
           if (res > 0) {
               start = element;
           }
        }
        return start;
    }

    public <T> T min(List<T> list, Comparator<T> comparator) {
        return max(list, comparator.reversed());
    }

}
