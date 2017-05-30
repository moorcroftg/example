package repositories.Impl;

import domain.User;
import repositories.UserRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grey on 5/30/2017.
 */
public class UserRepositoryImpl implements UserRepository{
    private static UserRepositoryImpl rep = null;

    private Map<String, User> userTable;

    private UserRepositoryImpl()
    {
        userTable = new HashMap<String, User>();
    }

    public static UserRepositoryImpl getInstance()
    {
        if(rep == null)
            rep = new UserRepositoryImpl();
        return rep;
    }

    public User create(User user) {
        userTable.put(user.getEmail(),user);
        User savedUser = userTable.get(user.getEmail());
        return savedUser;
    }

    public User read(String email) {
        User user = userTable.get(email);
        return user;
    }

    public User update(User user) {
        userTable.put(user.getEmail(),user);
        User savedUser = userTable.get(user.getEmail());
        return savedUser;
    }

    public void delete(String email) {
        userTable.remove(email);
    }
}
