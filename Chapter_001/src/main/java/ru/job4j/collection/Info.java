package ru.job4j.collection;

import java.util.Objects;

public class Info {
    private int added;
    private int changed;
    private int delete;

    public Info(int added, int changed, int delete) {
        this.added = added;
        this.changed = changed;
        this.delete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Info info = (Info) o;
        return added == info.added
                && changed == info.changed
                && delete == info.delete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(added, changed, delete);
    }

    public void setAdded(int added) {
        this.added = added;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "added= " + added
                + ", changed= " + changed
                + ", delete= " + delete;
    }
}
