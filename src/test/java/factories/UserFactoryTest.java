package factories;

import domain.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class UserFactoryTest {
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception
    {
        values = new HashMap<String, String>();
        values.put("screenName", "MrGrey");
        values.put("password", "P@ssow0rd");
        values.put("status", "Active");
    }

    @Test
    public void testGetUser() throws Exception {
        User user = UserFactory.getUser(values, "moorcroft.g@gmail.com");
        assertEquals("Active", user.getStatus());
    }

}