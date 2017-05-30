package services.Impl;

import domain.Comment;
import repositories.CommentRepository;
import repositories.Impl.CommentRepositoryImpl;
import services.CommentService;

/**
 * Created by Grey on 5/30/2017.
 */
public class CommentServiceImpl implements CommentService{
    private static CommentServiceImpl service = null;

    CommentRepository repository = CommentRepositoryImpl.getInstance();

    public static CommentServiceImpl getInstance()
    {
        if(service == null)
            service = new CommentServiceImpl();
        return service;
    }

    public Comment create(Comment comment) {
        return repository.create(comment);
    }

    public Comment read(String ipaddress) {
        return repository.read(ipaddress);
    }

    public Comment update(Comment comment) {
        return repository.update(comment);
    }

    public void delete(String ipaddress) {
        repository.delete(ipaddress);
    }
}
