package serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int age;
    private Contact contact;
    @XmlElementWrapper(name = "roles")
    private String[] role;
    @XmlAttribute
    private boolean sex;

    public User() {
    }

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
