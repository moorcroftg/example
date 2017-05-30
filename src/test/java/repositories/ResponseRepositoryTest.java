package repositories;

import domain.Comment;
import domain.Response;
import factories.ResponseFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repositories.Impl.ResponseRepositoryImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class ResponseRepositoryTest {
    Map<String, String> values;
    ResponseRepository repository;
    Comment c;

    @BeforeMethod
    public void setUp() throws Exception
    {
        repository = ResponseRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("comment", "This is an interesting post");
        values.put("ipaddress", "156.2.3.36");
        c = new Comment();
    }

    @Test
    public void testCreate() throws Exception {
        Response response = ResponseFactory.getResponse(values, new Date(), c);
        repository.create(response);
        assertEquals("This is an interesting post", response.getComment());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Response readResponse = repository.read("156.2.3.36");
        assertEquals("This is an interesting post", readResponse.getComment());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Response response = repository.read("156.2.3.36");
        Response newResponse = new Response.Builder()
                .comment("This is a bad post")
                .ipaddress(values.get("ipaddress"))
                .date(new Date())
                .comments(c)
                .build();
        repository.update(newResponse);
        Response UpdateResponse = repository.read("156.2.3.36");
        assertEquals("This is a bad post", UpdateResponse.getComment());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        repository.delete("156.2.3.36");
        Response response = repository.read("156.2.3.36");
        assertNull(response);
    }

}