package ru.job4j.collection;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthDay;

    public User(String name, int children, Calendar birthDay) {
        this.name = name;
        this.children = children;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Calendar birthDay) {
        this.birthDay = birthDay;
    }
}
