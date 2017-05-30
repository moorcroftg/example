package services;

import domain.User;
import factories.UserFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.Impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class UserServiceTest {
    UserService ser;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception
    {
        ser = new UserServiceImpl();
        values = new HashMap<String, String>();
        values.put("screenName", "MrGrey");
        values.put("password", "P@ssow0rd");
        values.put("status", "Active");
    }

    @Test
    public void testCreate() throws Exception {
        User user = UserFactory.getUser(values, "moorcroft.g@gmail.com");
        ser.create(user);
        assertEquals("Active", user.getStatus());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        User readUser = ser.read("moorcroft.g@gmail.com");
        assertEquals("Active", readUser.getStatus());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        User user = ser.read("moorcroft.g@gmail.com");
        User newUser = new User.Builder()
                .status("Inactive")
                .email(values.get("email"))
                .screenName(values.get("screenName"))
                .password(values.get("password"))
                .build();
        ser.update(newUser);
        User updateUser = ser.read("moorcroft.g@gmail.com");
        assertEquals("Inactive", updateUser.getStatus());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        ser.delete("moorcroft.g@gmail.com");
        User user = ser.read("moorcroft.g@gmail.com");
        assertNull(user);
    }

}