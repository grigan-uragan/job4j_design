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
        T res = mem.set(indexById(id), model);
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

    public int indexById(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
