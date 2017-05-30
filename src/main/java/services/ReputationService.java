package services;

import domain.Reputation;

/**
 * Created by Grey on 5/30/2017.
 */
public interface ReputationService {
    Reputation create(Reputation reputation);
    Reputation read(int value);
    Reputation update(Reputation reputation);
    void delete(int value);
}
