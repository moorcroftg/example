package services.Impl;

import domain.ContentFilter;
import repositories.ContentFilterRepository;
import repositories.Impl.ContentFilterRepositoryImpl;
import services.ContentFilterService;

/**
 * Created by Grey on 5/30/2017.
 */
public class ContentFilterServiceImpl implements ContentFilterService {
    private static ContentFilterServiceImpl service = null;
    ContentFilterRepository repository = ContentFilterRepositoryImpl.getInstance();

    public static ContentFilterServiceImpl getInstance()
    {
        if(service == null)
            service = new ContentFilterServiceImpl();
        return service;
    }

    public ContentFilter create(ContentFilter cF) {
        return repository.create(cF);
    }

    public ContentFilter read(String contentCheck) {
        return repository.read(contentCheck);
    }

    public ContentFilter update(ContentFilter cF) {
        return repository.update(cF);
    }

    public void delete(String contentCheck) {
        repository.delete(contentCheck);
    }
}
