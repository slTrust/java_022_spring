package user.model;

import org.springframework.stereotype.Component;
import user.model.User;
import user.model.UserDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Dao data access object 用户实现和管理数据访问的对象，比如访问数据库
 */
//@Component // 告诉 spring 这是一个组件 可以用来注入到其他的对象里
public class UserMockDao implements UserDao {
    private final HashMap<String, User> users = new HashMap<String, User>();

    public UserMockDao() {
        System.out.println("创建UserMockDao");
        users.put("aaa",new User("aaa",11));
        users.put("bbb",new User("bbb",22));
        users.put("ccc",new User("ccc",33));
    }

    @Override
    public boolean contains(String key) {
        return users.containsKey(key);
    }

    @Override
    public User get(String key) {
        return users.get(key);
    }

     @Override
    public void put(User user) {
        users.put(user.getName(),user);
    }

    @Override
    public void delete(String key) {
        users.remove(key);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }
}
