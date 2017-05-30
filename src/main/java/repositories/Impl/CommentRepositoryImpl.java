package repositories.Impl;

import domain.Comment;
import repositories.CommentRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grey on 5/30/2017.
 */
public class CommentRepositoryImpl implements CommentRepository{
    private static CommentRepositoryImpl repository = null;

    private Map<String, Comment> commentTable;

    private CommentRepositoryImpl()
    {
        commentTable = new HashMap<String, Comment>();
    }

    public static CommentRepositoryImpl getInstance()
    {
        if(repository == null)
             repository = new CommentRepositoryImpl();
        return repository;
    }

    public Comment create(Comment comment) {
        commentTable.put(comment.getIpaddress(),comment);
        Comment savedComment = commentTable.get(comment.getIpaddress());
        return savedComment;
    }

    public Comment read(String ipaddress) {
        Comment comment = commentTable.get(ipaddress);
        return comment;
    }

    public Comment update(Comment comment) {
        commentTable.put(comment.getIpaddress(), comment);
        Comment savedCommet = commentTable.get(comment.getIpaddress());
        return savedCommet;
    }

    public void delete(String ipaddress) {
        commentTable.remove(ipaddress);
    }
}
