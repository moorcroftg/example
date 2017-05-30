package factories;

import domain.Comment;

import java.util.Date;
import java.util.Map;

/**
 * Created by Grey on 5/30/2017.
 */
public class CommentFactory {

    public static Comment getComment(Map<String, String> values, Date date)
    {
        Comment comment = new Comment.Builder()
                .comment(values.get("comment"))
                .ipaddress(values.get("ipaddress"))
                .date(date)
                .build();
        return comment;
    }
}
