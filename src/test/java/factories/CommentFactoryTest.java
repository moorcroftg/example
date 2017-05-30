package factories;

import domain.Comment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class CommentFactoryTest {
    Map<String, String> values;

    @BeforeMethod
    public void setUp() throws Exception
    {
        values = new HashMap<String, String>();
        values.put("comment", "This is an interesting post");
        values.put("ipaddress", "156.2.3.36");
    }

    @Test
    public void testGetComment() throws Exception {
        Comment comment = CommentFactory.getComment(values, new Date());
        assertEquals("156.2.3.36", comment.getIpaddress());
    }

}