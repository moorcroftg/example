package repositories;

import domain.User;
import factories.UserFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repositories.Impl.UserRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class UserRepositoryTest {
    Map<String,String> values;
    UserRepository rep;

    @BeforeMethod
    public void setUp() throws Exception
    {
        rep = UserRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("screenName", "MrGrey");
        values.put("password", "P@ssow0rd");
        values.put("status", "Active");
    }

    @Test
    public void testCreate() throws Exception {
        User user = UserFactory.getUser(values, "moorcroft.g@gmail.com");
        rep.create(user);
        assertEquals("Active", user.getStatus());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        User readUser = rep.read("moorcroft.g@gmail.com");
        assertEquals("Active", readUser.getStatus());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        User user = rep.read("moorcroft.g@gmail.com");
        User newUser = new User.Builder()
                .status("Inactive")
                .email(values.get("email"))
                .password(values.get("password"))
                .screenName(values.get("screenName"))
                .build();
        rep.update(newUser);
        User updateUser = rep.read("moorcroft.g@gmail.com");
        assertEquals(updateUser.getStatus(), "Inactive");
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        rep.delete("moorcroft.g@gmail.com");
        User user = rep.read("moorcroft.g@gmail.com");
        assertNull(user);
    }

}