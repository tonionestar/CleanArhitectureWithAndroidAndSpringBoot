package ro.ovidiuconeac.server.features.featurex.data.dao;

import ro.ovidiuconeac.models.features.featurex.Cheese;

/**
 * Created by ovidiu on 2/7/17.
 */

public interface CheesesDao {
    Cheese getCheeseById(int id);
}
