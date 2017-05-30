package services;

import domain.ContentFilter;

/**
 * Created by Grey on 5/30/2017.
 */
public interface ContentFilterService {
    ContentFilter create(ContentFilter cF);
    ContentFilter read(String contentCheck);
    ContentFilter update(ContentFilter cF);
    void delete(String contentCheck);
}
