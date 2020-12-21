package ru.job4j.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int del = 0;
        int change = 0;
        int add;
        List<User> tempPrev = new ArrayList<>(previous);
        List<User> tempCur = new ArrayList<>(current);
        tempPrev.removeAll(current);
        tempCur.removeAll(previous);
        for (User prev : tempPrev) {
            boolean wasChanged = false;
            for (User cur : tempCur) {
                if (prev.id == cur.id) {
                    change++;
                    wasChanged = true;
                    break;
                }
            }
            if (wasChanged) {
                del++;
            }
        }
        add = tempCur.size() - change;
        return new Info(add, change, del);
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }

    public static class Info {

        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
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
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }

        @Override
        public String toString() {
            return "Info{" + "added=" + added + ", changed="
                    + changed + ", deleted=" + deleted + '}';
        }
    }
}


