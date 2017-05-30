package services.Impl;

import domain.Reputation;
import domain.Response;
import repositories.Impl.ResponseRepositoryImpl;
import repositories.ResponseRepository;
import services.ReputationService;
import services.ResponseService;

/**
 * Created by Grey on 5/30/2017.
 */
public class ResponseServiceImpl implements ResponseService {
    private static ResponseServiceImpl service = null;
    ResponseRepository repository = ResponseRepositoryImpl.getInstance();

    public static ResponseServiceImpl getInstance()
    {
        if(service == null)
            service = new ResponseServiceImpl();
        return service;
    }


    public Response create(Response response) {
        return repository.create(response);
    }

    public Response read(String ipaddress) {
        return repository.read(ipaddress);
    }

    public Response update(Response response) {
        return repository.update(response);
    }

    public void delete(String ipaddress) {
        repository.delete(ipaddress);
    }
}
