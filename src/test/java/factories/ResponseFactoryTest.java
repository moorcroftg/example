package factories;

import domain.Comment;
import domain.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class ResponseFactoryTest {
    Map<String, String> values;
    Comment c;

    @BeforeMethod
    public void setUp() throws Exception{
        values = new HashMap<String, String>();
        values.put("comment", "This is an interesting post");
        values.put("ipaddress", "123.2.3.36");
        c = new Comment();
    }

    @Test
    public void testGetResponse() throws Exception {
        Response response = ResponseFactory.getResponse(values, new Date(), c);
        assertEquals("This is an interesting post", response.getComment());
    }

}