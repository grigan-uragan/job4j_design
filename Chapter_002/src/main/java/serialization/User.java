package serialization;

import java.util.Arrays;

public class User {
    private String name;
    private int age;
    private Contact contact;
    private String[] role;
    private boolean sex;

    public User(String name, int age, Contact contact, String[] role, boolean sex) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.role = role;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getRole() {
        return role;
    }

    public boolean isSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\'' + ", age=" + age
                + ", contact=" + contact + ", role="
                + Arrays.toString(role) + ", sex=" + sex + '}';
    }
}
