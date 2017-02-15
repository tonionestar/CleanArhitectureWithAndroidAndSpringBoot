package ro.ovidiuconeac.server.features.featurex.data.transformers;

import ro.ovidiuconeac.models.features.featurex.Sweet;
import ro.ovidiuconeac.server.features.featurex.data.entities.SweetEntity;

/**
 * Created by Ovidiu CONEAC on 2/15/2017.
 */
public class SweetTransformer {

    public Sweet getModelFrom(SweetEntity sweetEntity) {
        return new Sweet(sweetEntity.getName());
    }
}