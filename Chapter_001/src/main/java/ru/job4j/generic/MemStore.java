package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = mem.indexOf(findById(id));
        T res = mem.set(index, model);
        return res != null;
    }

    @Override
    public boolean delete(String id) {

        return mem.remove(findById(id));
    }

    @Override
    public T findById(String id) {
        Optional<T> optional = mem
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
        return optional.orElse(null);
    }
}
