package services;

import domain.Comment;
import factories.CommentFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.Impl.CommentServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class CommentServiceTest {
    CommentService service;
    Map<String, String> values;

    @BeforeMethod
    public void setUp() throws Exception
    {
        service = new CommentServiceImpl();
        values = new HashMap<String, String>();
        values.put("comment", "This is an interesting post");
        values.put("ipaddress", "156.2.3.36");
    }

    @Test
    public void testCreate() throws Exception {
        Comment comment = CommentFactory.getComment(values, new Date());
        service.create(comment);
        assertEquals("156.2.3.36", comment.getIpaddress());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Comment readComment = service.read("156.2.3.36");
        assertEquals("156.2.3.36", readComment.getIpaddress());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Comment comment = service.read("156.2.3.36");
        Comment newComment = new Comment.Builder()
                .comment("This is a horrible post")
                .ipaddress(values.get("ipaddress"))
                .date(new Date())
                .build();
        service.update(newComment);
        Comment updateComment = service.read("156.2.3.36");
        assertEquals("This is a horrible post", updateComment.getComment());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("156.2.3.36");
        Comment comment = service.read("156.2.3.36");
        assertNull(comment);
    }

}