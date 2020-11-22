package ru.job4j.collection;

import java.util.List;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<People> previous, List<People> current) {
        Long added = 0L;
        Long deleted = previous.stream().filter(people -> !current.contains(people)).count();
        List<People> changes = previous.stream().
                filter(current::contains)
                .collect(Collectors.toList());
        int change = 0;
        for (People p: changes) {
           int index = current.indexOf(p);
           if (!p.getName().equals(current.get(index).getName())) {
               change++;
           }
        }

        return new Info(added.intValue(), deleted.intValue(), change);
    }


}
