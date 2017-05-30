package factories;

import domain.Comment;
import domain.ContentFilter;

import java.util.Map;

/**
 * Created by Grey on 5/30/2017.
 */
public class ContentFilterFactory {
    public static ContentFilter getContentFilter(Map<String, String> values, Comment c)
    {
        ContentFilter cF = new ContentFilter.Builder()
                .contentCheck(values.get("contentCheck"))
                .comment(c)
                .build();
        return cF;
    }
}
