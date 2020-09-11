package ru.job4j.it;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

public class ListUtils {
    public static <T> void addBefore(List<T> list, int index,  T value) {
        int point = Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.nextIndex() == point) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        int point = Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.previousIndex() == point) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }
    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> iterator = list.listIterator();
       while (iterator.hasNext()) {
           T temp = iterator.next();
           if (filter.test(temp)) {
               iterator.remove();
           }
       }
       return list;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            T temp = iterator.next();
            if (filter.test(temp)) {
                iterator.set(value);
            }
        }
        return list;
    }

    public static <T> List<T> removeAll(List<T> list, List<T> element) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            T temp = iterator.next();
            if (element.contains(temp)) {
                iterator.remove();
            }
        }
        return list;
    }
}
