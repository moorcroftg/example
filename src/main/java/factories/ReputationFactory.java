package factories;

import domain.Reputation;

import java.util.Date;
import java.util.Map;

/**
 * Created by Grey on 5/30/2017.
 */
public class ReputationFactory {
    public static Reputation getReputation(Map<String,Date> values, int v)
    {
        Reputation rep = new Reputation.Builder()
                .date(values.get(new Date()))
                .value(v)
                .build();
        return rep;
    }
}
