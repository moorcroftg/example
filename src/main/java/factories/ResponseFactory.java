package factories;

import domain.Comment;
import domain.Response;

import java.util.Date;
import java.util.Map;

/**
 * Created by Grey on 5/30/2017.
 */
public class ResponseFactory {
    public static Response getResponse(Map<String, String> values, Date date, Comment c)
    {
        Response response = new Response.Builder()
                .comment(values.get("comment"))
                .ipaddress(values.get("ipaddress"))
                .date(date)
                .comments(c)
                .build();
        return response;
    }
}
