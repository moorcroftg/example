package factories;

import domain.Comment;
import domain.ContentFilter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class ContentFilterFactoryTest {
    Map<String, String> values;
    Comment c;

    @BeforeMethod
    public void setUp() throws Exception
    {
        values = new HashMap<String, String>();
        values.put("contentFilter", "Active");
    }

    @Test
    public void testGetContentFilter() throws Exception {
        ContentFilter cf = ContentFilterFactory.getContentFilter(values, c);
        assertEquals("Active", cf.getContentCheck());
    }

}