package solid.isp;

import java.util.List;

public class ClientWithOutAdminRole implements Server {
    private List<User> users;

    public ClientWithOutAdminRole(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean create(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(int index, User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public User read(int index) {
        return users.get(index);
    }
}

interface Server {
    boolean create(User user);

    boolean update(int index, User user);

    boolean delete(int index);

    User read(int index);
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
