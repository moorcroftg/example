package services.Impl;

import domain.User;
import repositories.Impl.UserRepositoryImpl;
import repositories.UserRepository;
import services.UserService;

/**
 * Created by Grey on 5/30/2017.
 */
public class UserServiceImpl implements UserService {
    private static UserServiceImpl ser = null;

    UserRepository rep = UserRepositoryImpl.getInstance();

    public static UserServiceImpl getInstance()
    {
        if (ser == null)
            ser = new UserServiceImpl();
        return ser;
    }

    public User create(User user) {
        return rep.create(user);
    }

    public User read(String email) {
        return rep.read(email);
    }

    public User update(User user) {
        return rep.update(user);
    }

    public void delete(String email) {
        rep.delete(email);
    }
}
