package repositories;

import domain.Comment;

/**
 * Created by Grey on 5/30/2017.
 */
public interface CommentRepository {
    Comment create(Comment comment);
    Comment read(String ipaddress);
    Comment update(Comment comment);
    void delete(String ipaddress);
}
