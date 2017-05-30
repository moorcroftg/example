package factories;

import domain.Reputation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Grey on 5/30/2017.
 */
public class ReputationFactoryTest {
    Map<String,Date> values;

    @BeforeMethod
    public void setUp() throws Exception
    {
        values = new HashMap<String, Date>();
        values.put("date",new Date());
    }

    @Test
    public void testGetReputation() throws Exception {
        Reputation reputation = ReputationFactory.getReputation(values,20);
        assertEquals(20,reputation.getValue());
    }

}