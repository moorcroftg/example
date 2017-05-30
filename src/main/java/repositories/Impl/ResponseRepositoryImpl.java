package repositories.Impl;

import domain.Response;
import repositories.ResponseRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grey on 5/30/2017.
 */
public class ResponseRepositoryImpl implements ResponseRepository{
    private static ResponseRepositoryImpl repository = null;
    private Map<String, Response> responseTable;

    private ResponseRepositoryImpl()
    {
        responseTable = new HashMap<String, Response>();
    }

    public static ResponseRepositoryImpl getInstance()
    {
        if(repository == null)
            repository = new ResponseRepositoryImpl();
        return repository;
    }

    public Response create(Response response) {
        responseTable.put(response.getIpaddress(), response);
        Response savedResponse = responseTable.get(response.getIpaddress());
        return savedResponse;
    }

    public Response read(String ipaddress) {
        Response response = responseTable.get(ipaddress);
        return response;
    }

    public Response update(Response response) {
        responseTable.put(response.getIpaddress(), response);
        Response savedResponse = responseTable.get(response.getIpaddress());
        return savedResponse;
    }

    public void delete(String ipaddress) {
        responseTable.remove(ipaddress);
    }
}
