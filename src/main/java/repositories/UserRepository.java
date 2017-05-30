package repositories;

import domain.User;

/**
 * Created by Grey on 5/30/2017.
 */
public interface UserRepository {
    User create(User user);
    User read(String email);
    User update(User user);
    void delete(String email);
}
