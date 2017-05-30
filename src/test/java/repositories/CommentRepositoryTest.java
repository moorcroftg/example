package repositories;

import domain.Comment;
import factories.CommentFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repositories.Impl.CommentRepositoryImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class CommentRepositoryTest {
    Map<String, String> values;
    CommentRepository repository;

    @BeforeMethod
    public void setUp() throws Exception
    {
        repository = CommentRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("comment", "This is an interesting post");
        values.put("ipaddress", "156.2.3.36");
    }

    @Test
    public void testCreate() throws Exception {
        Comment comment = CommentFactory.getComment(values, new Date());
        repository.create(comment);
        assertEquals("156.2.3.36", comment.getIpaddress());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Comment readComment = repository.read("156.2.3.36");
        assertEquals("156.2.3.36", readComment.getIpaddress());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Comment comment = repository.read("156.2.3.36");
        Comment newComment = new Comment.Builder()
                .comment("This is a horrible post")
                .ipaddress(values.get("ipaddress"))
                .date(new Date())
                .build();
        repository.update(newComment);
        Comment updateComment = repository.read("156.2.3.36");
        assertEquals("This is a horrible post", updateComment.getComment());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        repository.delete("156.2.3.36");
        Comment comment = repository.read("156.2.3.36");
        assertNull(comment);
    }

}