package repositories.Impl;

import domain.Reputation;
import repositories.ReputaionRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grey on 5/30/2017.
 */
public class ReputationRepositoryImpl implements ReputaionRepository{
    private static ReputationRepositoryImpl rep = null;
    private Map<Date,Reputation> reputationTable;

    private ReputationRepositoryImpl()
    {
        reputationTable = new HashMap<Date, Reputation>();
    }

    public static ReputationRepositoryImpl getInstance()
    {
        if(rep == null)
            rep = new ReputationRepositoryImpl();
        return rep;
    }

    public Reputation create(Reputation reputation) {
        reputationTable.put(reputation.getDate(), reputation);
        Reputation savedRep = reputationTable.get(reputation.getDate());
        return savedRep;
    }

    public Reputation read(int value) {
        Reputation reputation = reputationTable.get(value);
        return reputation;
    }

    public Reputation update(Reputation reputation) {
        reputationTable.put(reputation.getDate(), reputation);
        Reputation savedRep = reputationTable.get(reputation.getDate());
        return savedRep;
    }

    public void delete(int value) {
        reputationTable.remove(value);
    }
}
