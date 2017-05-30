package repositories.Impl;

import domain.ContentFilter;
import repositories.ContentFilterRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grey on 5/30/2017.
 */
public class ContentFilterRepositoryImpl implements ContentFilterRepository {
    private static ContentFilterRepositoryImpl repository = null;
    private Map<String, ContentFilter> cFTable;

    private ContentFilterRepositoryImpl()
    {
        cFTable = new HashMap<String, ContentFilter>();
    }

    public static ContentFilterRepositoryImpl getInstance()
    {
        if(repository == null)
            repository = new ContentFilterRepositoryImpl();
        return repository;
    }

    public ContentFilter create(ContentFilter cF) {
        cFTable.put(cF.getContentCheck(), cF);
        ContentFilter savedCF = cFTable.get(cF.getContentCheck());
        return savedCF;
    }

    public ContentFilter read(String contentCheck) {
        ContentFilter cf = cFTable.get(contentCheck);
        return cf;
    }

    public ContentFilter update(ContentFilter cF) {
        cFTable.put(cF.getContentCheck(), cF);
        ContentFilter savedcf = cFTable.get(cF.getContentCheck());
        return savedcf;
    }

    public void delete(String contentCheck) {
        cFTable.remove(contentCheck);
    }
}
