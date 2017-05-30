package services;

import domain.Comment;
import domain.Response;
import factories.ResponseFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.Impl.ResponseServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class ResponseServiceTest {
    ResponseService service;
    Map<String, String> values;
    Comment c;

    @BeforeMethod
    public void setUp() throws Exception
    {
        service = new ResponseServiceImpl();
        values = new HashMap<String, String>();
        values.put("comment", "This is an interesting post");
        values.put("ipaddress", "156.2.3.36");
    }

    @Test
    public void testCreate() throws Exception {
        Response response = ResponseFactory.getResponse(values, new Date(), c);
        service.create(response);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Response readResponse = service.read("156.2.3.36");
        assertEquals("This is an interesting post", readResponse.getComment());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Response response = service.read("156.2.3.36");
        Response newResponse = new Response.Builder()
                .comment("This is a bad post")
                .ipaddress(values.get("ipaddress"))
                .date(new Date())
                .comments(c)
                .build();
        service.update(newResponse);
        Response updateResponse = service.read("156.2.3.36");
        assertEquals("This is a bad post", updateResponse.getComment());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("156.2.3.36");
        Response response = service.read("156.2.3.36");
        assertNull(response);
    }

}