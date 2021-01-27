package tdd;

import java.util.Objects;

public class Session2D implements Session {
    private String name;

    public Session2D(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Session2D session2D = (Session2D) o;
        return Objects.equals(name, session2D.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
