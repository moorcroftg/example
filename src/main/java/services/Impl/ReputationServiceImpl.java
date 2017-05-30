package services.Impl;

import domain.Reputation;
import repositories.Impl.ReputationRepositoryImpl;
import repositories.ReputaionRepository;
import services.ReputationService;

/**
 * Created by Grey on 5/30/2017.
 */
public class ReputationServiceImpl implements ReputationService {
    private static ReputationServiceImpl ser = null;
    ReputaionRepository repository = ReputationRepositoryImpl.getInstance();

    public static ReputationServiceImpl getInstance()
    {
        if(ser == null)
            ser = new ReputationServiceImpl();
        return ser;
    }

    public Reputation create(Reputation reputation) {
        return repository.create(reputation);
    }

    public Reputation read(int value) {
        return repository.read(value);
    }

    public Reputation update(Reputation reputation) {
        return repository.update(reputation);
    }

    public void delete(int value) {
        repository.delete(value);
    }
}
