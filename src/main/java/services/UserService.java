package services;

import domain.User;

/**
 * Created by Grey on 5/30/2017.
 */
public interface UserService {
    User create(User user);
    User read(String email);
    User update(User user);
    void delete(String email);
}
