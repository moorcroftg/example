package services;

import domain.Response;

/**
 * Created by Grey on 5/30/2017.
 */
public interface ResponseService {
    Response create(Response response);
    Response read(String ipaddress);
    Response update(Response response);
    void delete(String ipaddress);
}
