package ro.ovidiuconeac.server.features.featurex.data.dao;

import ro.ovidiuconeac.models.features.featurex.Fruit;

/**
 * Created by ovidiu on 2/7/17.
 */

public interface FruitsDao {
    Fruit getFruitById(int id);
}
