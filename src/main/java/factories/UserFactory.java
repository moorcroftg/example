package factories;

import domain.User;

import java.util.Map;

/**
 * Created by Grey on 5/30/2017.
 */
public class UserFactory {
    public static User getUser(Map<String, String> values, String email)
    {
        User user = new User.Builder()
                .email(email)
                .screenName(values.get("screenName"))
                .password(values.get("password"))
                .status(values.get("status"))
                .build();
        return user;
    }
}
