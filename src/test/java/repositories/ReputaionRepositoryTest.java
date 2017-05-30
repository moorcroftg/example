package repositories;

import domain.Reputation;
import factories.ReputationFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repositories.Impl.ReputationRepositoryImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class ReputaionRepositoryTest {
    Map<String,Date> values;
    ReputaionRepository repository;

    @BeforeMethod
    public void setUp() throws Exception
    {
        repository = ReputationRepositoryImpl.getInstance();
        values = new HashMap<String,Date>();
        values.put("Date", new Date());
    }

    @Test
    public void testCreate() throws Exception {
        Reputation reputation = ReputationFactory.getReputation(values, 20);
        repository.create(reputation);
        assertEquals(20, reputation.getValue());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Reputation readRep = repository.read(20);
        assertEquals(20, readRep.getValue());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Reputation reputation = repository.read(20);
        Reputation newRep = new Reputation.Builder()
                .date(new Date())
                .value(25)
                .build();
        repository.update(newRep);
        Reputation updateRep = repository.read(25);
        assertEquals(25, updateRep.getValue());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        repository.delete(25);
        Reputation reputation = repository.read(25);
        assertNull(reputation);
    }

}