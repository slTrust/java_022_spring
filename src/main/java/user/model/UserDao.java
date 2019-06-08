package user.model;

import java.util.List;

public interface UserDao {

    boolean contains(String key);

    User get(String key);

    void put(User user);

    void delete(String key);

    List<User> getAll();
}
